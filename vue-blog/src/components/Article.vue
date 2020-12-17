<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>文章管理</el-breadcrumb-item>
      <el-breadcrumb-item>文章列表</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>


      <!--:gutter el-col之间的间距-->
      <el-row :gutter="20">
        <!--:span 设置比重-->
        <el-col :span="8">
          <el-input placeholder="请输入内容" v-model="queryParam.query" clearable @clear="getArticleList">
            <el-button slot="append" icon="el-icon-search" @click="getArticleList"></el-button>
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-button type="primary" @click="markDownDialogVisible = true">添加文章</el-button>
        </el-col>
      </el-row>
      <!--表格-->
      <el-table border stripe
                :data="articleList"
                style="width: 100%">
        <el-table-column
            fixed
            prop="category.cateName"
            label="分类"
            width="150">
        </el-table-column>
        <el-table-column
            prop="title"
            label="标题">
        </el-table-column>
        <el-table-column
            prop="modifyDate"
            label="最近编辑时间"
            width="160">
        </el-table-column>
        <el-table-column
            prop="creator"
            label="作者"
            width="120">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)">编辑
            </el-button>
            <el-button
                size="mini"
                type="danger"
                @click="removeArticleById(scope.row.id)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页区域 -->
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="queryParam.pageNum"
          :page-sizes="[2, 5, 10, 15]"
          :page-size="queryParam.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
      ></el-pagination>


      <!--:visible.sync 控制对话框显示  你动吧-->
      <el-dialog title="发表文章" :visible.sync="markDownDialogVisible" width="75%" :close-on-click-modal="false"
                 @close="addMarkDownDialogClosed">
        <!--                    <AddArticle />-->
        <div class="article-header">


          <div>
            <!--下拉选择框-->
            <el-select v-model="article.cid" placeholder="请选择文章栏目" style="width: 150px;">
              <el-option
                  v-for="item in categoryList"
                  :key="item.id"
                  :label="item.cateName"
                  :value="item.id">
              </el-option>
            </el-select>
          </div>
          <div>
            <!--标题-->
            <el-input v-model="article.title" placeholder="请输入标题..." style="width: 400px;margin-left: 10px"></el-input>
          </div>

          <!--标签-->


          <div>
            <el-tag
                :key="tag"
                v-for="tag in article.tags"
                closable
                :disable-transitions="false"
                @close="handleClose(tag)">
              {{ tag }}
            </el-tag>
            <el-input
                class="input-new-tag"
                v-if="inputVisible"
                v-model="inputValue"
                ref="saveTagInput"
                size="small"
                @keyup.enter.native="handleInputConfirm"
                @blur="handleInputConfirm"
            >
            </el-input>
            <el-button v-else type="primary" style="margin-left: 10px" icon="el-icon-circle-plus-outline" circle size="small" @click="showInput"></el-button>

          </div>
        </div>


        <mavon-editor ref="md" class="editor" v-model="article.mdContent"/>
        <span slot="footer" class="dialog-footer">
                    <el-button @click="markDownDialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="saveArticle">确 定</el-button>
                </span>
      </el-dialog>


    </el-card>
  </div>
</template>

<script>
import {isNotNullORBlank} from "@/utils/utils";

export default {
  data() {
    return {

      //标签
      inputVisible: false,
      inputValue: '',

      //分类列表
      categoryList: [],
      queryParam: {
        query: '',
        pageNum: 1,
        pageSize: 10
      },
      article: {
        title: '',
        mdContent: '',
        htmlContent: '',
        cid: '',
        tags: ['赞','后端'],
        content: ''
      },
      value: '',
      total: 0,
      articleList: [],
      markDownDialogVisible: false,
    }
  },
  created() {
    this.getArticleList()
    this.getCategoryList()
  },
  methods: {
    async getCategoryList() {
      const {data: res} = await this.$http.get('categoryList')
      this.categoryList = res.data

    },
    /*标签*/
    handleClose(tag) {
      this.article.tags.splice(this.article.tags.indexOf(tag), 1);
    },

    showInput() {
      this.inputVisible = true;
      this.$nextTick(() => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    },

    handleInputConfirm() {
      let inputValue = this.inputValue;
      if (inputValue) {
        this.article.tags.push(inputValue);
      }
      this.inputVisible = false;
      this.inputValue = '';
    },

    //新增文章
    async saveArticle() {
      if (!isNotNullORBlank(this.article.cid, this.article.title, this.article.mdContent))
        return this.$message.error('数据不能为弄！');
      this.article.htmlContent = this.$refs.md.d_render
      this.article.content = this.$refs.md.d_value
      const {data: res} = await this.$http.post('article', this.article)
      console.log(res)
      this.$message.success('添加文章成功！')
      // 隐藏添加用户对话框
      this.markDownDialogVisible = false
      this.getArticleList()
    },
    //关闭新增文章对话框
    addMarkDownDialogClosed() {
      this.resetArticle()
    },
    resetArticle() {
      this.article.cid = ''
      this.article.title = ''
      this.article.mdContent = ''
      this.article.htmlContent = ''
      this.article.content = ''
    },
    async getArticleList() {
      const {data: res} = await this.$http.get('article', {params: this.queryParam})
      console.log(res)
      this.articleList = res.data
      this.total = res.count

    },

    // 监听 pagesize改变的事件
    handleSizeChange(newSize) {
      // console.log(newSize)
      this.queryParam.pageSize = newSize
      this.getArticleList()
    },
    // 监听 页码值 改变事件
    handleCurrentChange(newSize) {
      // console.log(newSize)
      this.queryParam.pageNum = newSize
      this.getArticleList()
    },
    //删除
    async removeArticleById(id) {
      console.log(id)
      const confirmResult = await this.$confirm(
          '此操作将永久删除该文章, 是否继续?',
          '提示',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }
      ).catch(err => err)
      // 点击确定 返回值为：confirm
      // 点击取消 返回值为： cancel
      if (confirmResult !== 'confirm') {
        return this.$message.info('已取消删除')
      }
      await this.$http.delete('article/' + id)
      this.$message.success('删除文章成功！')
      this.getArticleList()
    },
  }

}
</script>
<!--你改改试试-->
<style lang="less">

.article-header{
  margin-bottom: 5px;
  display: flex;
  align-items: center;
}
.el-tag{
  margin: 0 ;
  margin-left: 8px;
}
.input-new-tag {
  width: 90px;
  margin-left: 10px;
}

.content-input-wrapper {
  max-height: 50vh;
}

/*.editor{*/
/*    max-height: 600px;*/
/*    overflow: auto;*/
/*}*/
</style>

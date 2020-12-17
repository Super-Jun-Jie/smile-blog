<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>文章管理</el-breadcrumb-item>
            <el-breadcrumb-item>分类列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-card>

            <el-row :gutter="20">
                <el-col :span="4">
                    <el-button type="primary" @click="addCategoryDialogVisible = true">添加分类</el-button>
                </el-col>
            </el-row>
            <!--表格-->
            <el-table border stripe
                      :data="categoryList"
                      style="width: 100%">
                <el-table-column
                        fixed
                        prop="id"
                        label="编号">
                </el-table-column>
                <el-table-column
                        prop="cateName"
                        label="分类名称">
                </el-table-column>
                <el-table-column
                        prop="modifyDate"
                        label="最近编辑时间">
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
                                @click="removeCategoryById(scope.row.id)">删除
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



            <!--:visible.sync 控制对话框显示-->
            <el-dialog title="添加分类" :visible.sync="addCategoryDialogVisible" width="50%" @close="addCategoryDialogClosed"
                       :close-on-click-modal="false">
                <!-- 内容主体 -->
                <el-form
                        :model="addCategoryForm"
                        ref="addCategoryFormRef"
                        :rules="addCategoryFormRules"
                        label-width="100px"
                >
                    <el-form-item label="分类名称" prop="cateName">
                        <el-input v-model="addCategoryForm.cateName"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="addCategoryDialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="insertCategory">确 定</el-button>
                </span>
            </el-dialog>
        </el-card>
    </div>
</template>

<script>

    export default {

        data() {

            return {
                queryParam: {
                    pageNum: 1,
                    pageSize: 10
                },
                addCategoryForm:{
                    cateName:''
                },
                total: 0,
                categoryList: [],
                addCategoryDialogVisible: false,
                categoryForm: {
                    cateName: '',
                },

                addCategoryFormRules: {
                    username: [
                        {required: true, message: '请输入分类名称', trigger: 'blur'},
                        {
                            min: 2,
                            max: 6,
                            message: '用户名的长度在2～6个字',
                            trigger: 'blur'
                        }
                    ]
                }
            }
        },
        created() {
            this.getCategoryList()
        },
        methods: {

            //新增分类
            insertCategory() {
                this.$refs.addCategoryFormRef.validate(async valid => {
                    if (!valid) return;
                    const {data: res} = await this.$http.post('category', this.addCategoryForm)
                    console.log(res)
                    this.$message.success('添加分类成功！')
                    // 隐藏添加用户对话框
                    this.addCategoryDialogVisible = false
                    this.getCategoryList()
                });
            },
            //关闭新增对话框
            addCategoryDialogClosed() {
                this.$refs.addCategoryFormRef.resetFields()
            },
            async getCategoryList() {
                const {data: res} = await this.$http.get('category', {params: this.queryParam})
                console.log(res)
                this.categoryList = res.data
                this.total = res.count

            },
            // 监听 pagesize改变的事件
            handleSizeChange(newSize) {
                // console.log(newSize)
                this.queryParam.pageSize = newSize
                this.getCategoryList()
            },
            // 监听 页码值 改变事件
            handleCurrentChange(newSize) {
                // console.log(newSize)
                this.queryParam.pageNum = newSize
                this.getCategoryList()
            },
            //删除
            async removeCategoryById(id) {
                console.log(id)
                const confirmResult = await this.$confirm(
                    '此操作将永久删除该分类, 是否继续?',
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
                await this.$http.delete('category/' + id)
                this.$message.success('删除分类成功！')
                this.getCategoryList()
            },
        }

    }
</script>

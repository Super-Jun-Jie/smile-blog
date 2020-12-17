<template>
  <el-container class="boke-container">
    <el-header>
      <!--面包屑-->
      <el-menu mode="horizontal" text-color="#000000" active-text-color="#409FFF">
        <el-menu-item index="1">首页</el-menu-item>
        <el-menu-item index="2">文字</el-menu-item>
        <el-menu-item index="3">归档</el-menu-item>
        <el-menu-item index="4">历程</el-menu-item>
        <el-menu-item index="5">留言</el-menu-item>
        <el-menu-item index="6"><a href="https://www.ele.me" target="_blank">github</a></el-menu-item>
      </el-menu>

      <el-button type="primary" icon="el-icon-s-cooperation" circle @click="$router.push('home')"></el-button>
    </el-header>


    <el-main>
      <div></div>
      <div class="article-container">


        <div class="article-card" v-for="article in articleList" :key="article.id">
            <span class="article-pic">
                <a style="text-decoration: none;color: #555;">
                    <img v-bind:src="article.imgUrl" alt="">
                </a>
            </span>
          <h3 class="article-title">{{ article.title }}</h3>
          <div class="article-content">
            <p>{{ article.content | ellipsis }}</p>
          </div>
          <div class="article-autor">
                <span class="article-category">
                    <a style="text-decoration: none;" @click="search(article.category.cateName)">{{ article.category.cateName }}</a>
                </span>
            <span class="article-time">{{ article.createDate }}</span>
            <span class="article-view">60</span>
            <span class="article-read">
                    <a style="text-decoration: none;">阅读原文</a>
                </span>
          </div>
        </div>
      </div>
      <div>
        <el-card>
          <el-input placeholder="随便搜" v-model="queryParam.keyWord" class="input-with-select" @keyup.enter.native="getArticleList">
            <el-button slot="append" icon="el-icon-search" @click="getArticleList"></el-button>
          </el-input>
        </el-card>
        <el-card>
          <Tags @setKeyWord="setKeyWord"/>
        </el-card>
      </div>
      <div></div>
    </el-main>
  </el-container>
</template>

<script>

import Tags from '../components/Tags.vue'

export default {
  name: "BoKe",
  components: {
    Tags
  },
  data() {
    return {
      articleList: [],

      queryParam: {
        keyWord: '',
        pageNum: 1,
        pageSize: 10
      }
    }
  },
  created() {
    this.getArticleList()
  },
  methods: {
    setKeyWord(tagName){
      this.search(tagName)
    },


    search(keyWord){
      this.queryParam.keyWord = keyWord
      this.getArticleList()
    },

    async getArticleList() {
      const {data: res} = await this.$http.get('getArticleList', {params: this.queryParam})
      console.log(res)
      this.articleList = res.data
    },
  },
  filters: {
    // 当标题字数超出时，超出部分显示’......‘。此处限制超出300位即触发隐藏效果
    ellipsis(value) {
      if (!value) return ''
      if (value.length > 300) {
        return value.slice(0, 300) + '......'
      }
      return value
    }
  }
}
</script>

<style lang="less" scoped>
@import '../assets/css/article-card.less';
a{
  cursor: pointer;
}


.el-card{
  margin: 0 10px 10px 10px
}
.el-main {
  display: flex;
  background-color: #F7F7F7;

}

.el-main div:nth-child(1) {
  flex: 1;
}

.el-main div:nth-child(2) {
  flex: 3;
}

.el-main div:nth-child(3) {
  flex: 1;
}

.el-main div:nth-child(4) {
  flex: 1;
}

.el-menu {
  background-color: #EDEDED;
  display: flex;
  justify-content: space-around;
}

.boke-container {
  height: 100%;
}

.el-header {
  background-color: #EDEDED;
  padding: 0;
  display: flex;
  justify-content: space-evenly;
  align-items: center;

}

.bg-purple-light {
  background: #e5e9f2;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
</style>

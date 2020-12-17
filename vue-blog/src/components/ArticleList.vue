<template>
  <div class="article-container">


    <div class="article-card" v-for="article in articleList" :key="article.id">
            <span class="article-pic">
                <a style="text-decoration: none;color: #555;">
                    <img v-bind:src="article.imgUrl" alt="">
                </a>
            </span>
      <h3 class="article-title"><a @click="articleDetail(article.id)">{{ article.title }}</a></h3>
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
                    <a style="text-decoration: none;" @click="articleDetail(article.id)">阅读原文</a>
                </span>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  data(){
    return{
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

<style scoped>

</style>

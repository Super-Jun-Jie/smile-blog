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
        <el-card>

          <el-collapse v-model="activeName" accordion v-for="(item,index) in timeline" :key="index" >
            <el-collapse-item  :title="item.year" :name="index">
              <div style="display: flex;justify-content: space-between" v-for="(article,index) in item.articles" :key="index">
                <div><a>{{article.title}}</a></div>
                <div>2020-12-09 9:15</div>
              </div>
            </el-collapse-item>
          </el-collapse>


        </el-card>






      </div>
      <div>
        <el-card>
          <el-input placeholder="随便搜" v-model="queryParam.keyWord" class="input-with-select"
                    @keyup.enter.native="getArticleList">
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
      timeline:[],
      activeName: '1',
      queryParam: {
        keyWord: '',
        pageNum: 1,
        pageSize: 10
      }
    }
  },
  created() {
    this.getTimeline()
  },
  methods: {
    handleChange(val) {
      console.log(val);
    },
    setKeyWord(tagName) {
      this.search(tagName)
    },
    getArticleList(){},
    async getTimeline() {
      const {data: res} = await this.$http.get('getTimeline')
      this.timeline = res.data
    },



  }
}
</script>

<style lang="less" scoped>


.el-collapse-item__header{
  font-size: 25px!important;
}
a {
  cursor: pointer;
}

@import '../assets/css/article-card.less';

.el-card {
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

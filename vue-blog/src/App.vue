<template>
  <div id="app">
<!--    <ul v-for="(book,index) in books" :key="index">-->
<!--      <li>{{book}}</li>-->
<!--    </ul>-->
    <!--路由占位符 路由匹配到的组件都会渲染到这个标签里面-->
    <router-view></router-view>
  </div>
</template>

<script>


export default {
  name: 'App',
  data(){
    return {
      books:["a","b","c"]
    }
  }
}
</script>

<style>

</style>

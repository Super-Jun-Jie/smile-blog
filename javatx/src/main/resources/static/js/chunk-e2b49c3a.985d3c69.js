(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-e2b49c3a"],{"890a":function(t,e,a){"use strict";a("b503")},b503:function(t,e,a){},db9e:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-container",{staticClass:"boke-container"},[a("el-header",[a("el-menu",{attrs:{mode:"horizontal","text-color":"#000000","active-text-color":"#409FFF"}},[a("el-menu-item",{attrs:{index:"1"}},[t._v("首页")]),a("el-menu-item",{attrs:{index:"2"}},[t._v("文字")]),a("el-menu-item",{attrs:{index:"3"}},[t._v("归档")]),a("el-menu-item",{attrs:{index:"4"}},[t._v("历程")]),a("el-menu-item",{attrs:{index:"5"}},[t._v("留言")]),a("el-menu-item",{attrs:{index:"6"}},[a("a",{attrs:{href:"https://www.ele.me",target:"_blank"}},[t._v("github")])])],1),a("el-button",{attrs:{type:"primary",icon:"el-icon-s-cooperation",circle:""},on:{click:function(e){return t.$router.push("home")}}})],1),a("el-main",[a("div"),a("div",{staticClass:"article-container"},t._l(t.articleList,(function(e){return a("div",{key:e.id,staticClass:"article-card"},[a("span",{staticClass:"article-pic"},[a("a",{staticStyle:{"text-decoration":"none",color:"#555"}},[a("img",{attrs:{src:e.imgUrl,alt:""}})])]),a("h3",{staticClass:"article-title"},[t._v(t._s(e.title))]),a("div",{staticClass:"article-content"},[a("p",[t._v(t._s(t._f("ellipsis")(e.content)))])]),a("div",{staticClass:"article-autor"},[a("span",{staticClass:"article-category"},[a("a",{staticStyle:{"text-decoration":"none"}},[t._v(t._s(e.category.cateName))])]),a("span",{staticClass:"article-time"},[t._v(t._s(e.createDate))]),a("span",{staticClass:"article-view"},[t._v("60")]),a("span",{staticClass:"article-read"},[a("a",{staticStyle:{"text-decoration":"none"}},[t._v("阅读原文")])])])])})),0),a("div"),a("div")])],1)},s=[],c={name:"BoKe",data(){return{wodrs:"",articleList:[]}},created(){this.getArticleList()},methods:{async getArticleList(){const{data:t}=await this.$http.get("getArticleList",{wodrs:this.wodrs});console.log(t),this.articleList=t.data}},filters:{ellipsis(t){return t?t.length>300?t.slice(0,300)+"......":t:""}}},n=c,r=(a("890a"),a("2877")),l=Object(r["a"])(n,i,s,!1,null,"0047467f",null);e["default"]=l.exports}}]);
//# sourceMappingURL=chunk-e2b49c3a.985d3c69.js.map
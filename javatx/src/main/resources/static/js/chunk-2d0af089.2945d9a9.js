(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0af089"],{"0d32":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[a("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),a("el-breadcrumb-item",[e._v("文章管理")]),a("el-breadcrumb-item",[e._v("分类列表")])],1),a("el-card",[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:4}},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.addCategoryDialogVisible=!0}}},[e._v("添加分类")])],1)],1),a("el-table",{staticStyle:{width:"100%"},attrs:{border:"",stripe:"",data:e.categoryList}},[a("el-table-column",{attrs:{fixed:"",prop:"id",label:"编号"}}),a("el-table-column",{attrs:{prop:"cateName",label:"分类名称"}}),a("el-table-column",{attrs:{prop:"modifyDate",label:"最近编辑时间"}}),a("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return e.handleEdit(t.$index,t.row)}}},[e._v("编辑 ")]),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return e.removeCategoryById(t.row.id)}}},[e._v("删除 ")])]}}])})],1),a("el-pagination",{attrs:{"current-page":e.queryParam.pageNum,"page-sizes":[2,5,10,15],"page-size":e.queryParam.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}}),a("el-dialog",{attrs:{title:"添加分类",visible:e.addCategoryDialogVisible,width:"50%","close-on-click-modal":!1},on:{"update:visible":function(t){e.addCategoryDialogVisible=t},close:e.addCategoryDialogClosed}},[a("el-form",{ref:"addCategoryFormRef",attrs:{model:e.addCategoryForm,rules:e.addCategoryFormRules,"label-width":"100px"}},[a("el-form-item",{attrs:{label:"分类名称",prop:"cateName"}},[a("el-input",{model:{value:e.addCategoryForm.cateName,callback:function(t){e.$set(e.addCategoryForm,"cateName",t)},expression:"addCategoryForm.cateName"}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.addCategoryDialogVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.insertCategory}},[e._v("确 定")])],1)],1)],1)],1)},o=[],i={data(){return{queryParam:{pageNum:1,pageSize:10},addCategoryForm:{cateName:""},total:0,categoryList:[],addCategoryDialogVisible:!1,categoryForm:{cateName:""},addCategoryFormRules:{username:[{required:!0,message:"请输入分类名称",trigger:"blur"},{min:2,max:6,message:"用户名的长度在2～6个字",trigger:"blur"}]}}},created(){this.getCategoryList()},methods:{insertCategory(){this.$refs.addCategoryFormRef.validate(async e=>{if(!e)return;const{data:t}=await this.$http.post("category",this.addCategoryForm);console.log(t),this.$message.success("添加分类成功！"),this.addCategoryDialogVisible=!1,this.getCategoryList()})},addCategoryDialogClosed(){this.$refs.addCategoryFormRef.resetFields()},async getCategoryList(){const{data:e}=await this.$http.get("category",{params:this.queryParam});console.log(e),this.categoryList=e.data,this.total=e.count},handleSizeChange(e){this.queryParam.pageSize=e,this.getCategoryList()},handleCurrentChange(e){this.queryParam.pageNum=e,this.getCategoryList()},async removeCategoryById(e){console.log(e);const t=await this.$confirm("此操作将永久删除该分类, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).catch(e=>e);if("confirm"!==t)return this.$message.info("已取消删除");await this.$http.delete("category/"+e),this.$message.success("删除分类成功！"),this.getCategoryList()}}},s=i,l=a("2877"),n=Object(l["a"])(s,r,o,!1,null,null,null);t["default"]=n.exports}}]);
//# sourceMappingURL=chunk-2d0af089.2945d9a9.js.map
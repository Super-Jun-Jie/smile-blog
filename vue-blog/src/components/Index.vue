<template>
    <div  >
        <el-container style="height:100vh">
            <el-header></el-header>
            <el-container>
                <el-aside width="200px">
                    <el-row class="tac" style="width: 100%">
                        <el-col :span="12" style="width: 100%">
                            <el-menu
                                    default-active="1"
                                    class="el-menu-vertical-demo">
                                <router-link to="/index/article">
                                    <el-menu-item index="2">
                                        <i class="el-icon-menu"></i>
                                        <span slot="title">文章管理</span>
                                    </el-menu-item>
                                </router-link>
                                <router-link to="/index/file">
                                <el-menu-item index="3">
                                    <i class="el-icon-menu"></i>
                                    <span slot="title">文件管理</span>
                                </el-menu-item>
                                </router-link>
                                    <router-link to="/index/system">
                                <el-menu-item index="4">
                                    <i class="el-icon-menu"></i>
                                    <span slot="title">系统设置</span>
                                </el-menu-item>
                                    </router-link>
                            </el-menu>
                        </el-col>
                    </el-row>
                </el-aside>
                <el-container>
                    <el-main>
                        <router-view></router-view>
                    </el-main>
                    <el-footer></el-footer>
                </el-container>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "Index",
        data(){

        },
        methods:{
            handleOpen :{

            },
            handleClose :{

            }
        },
        // beforeCreate(){
        //     console.log('开始前的方法')
        //     this.$router.push('article')
        // }
    }
</script>

<style scoped>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
    }
</style>

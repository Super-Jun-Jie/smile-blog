<template>
    <el-container class="home-container">
        <el-header>
            <div>
                <img src="../assets/logo.png" style="width: 60px;height: 60px" alt="">
                <span>后台管理</span>
            </div>
            <el-button type="info">退出</el-button>
        </el-header>
        <el-container>
            <el-aside :width="isCollapse ?'64px':'200px'">
                <div class="toggle-button" @click="toggleCollapse">|||</div>
                <!--菜单-->
                <el-menu :default-active="activePath" unique-opened :collapse="isCollapse" :collapse-transition="false" router  background-color="#333744" text-color="#fff" active-text-color="#409FFF">
                    <!-- :unique-opened="true"->只允许展开一个菜单 -->
                    <!-- :collapse-transition="false" -> 关闭动画 -->
                    <!-- router -> 导航开启路由模式 -->
                    <!-- :default-active="activePath"  -->
                    <!-- 一级菜单  -->
                    <el-submenu :index="item.id+''" v-for="item in menuList" :key="item.id" >
                        <!-- 一级菜单的模板区域 -->
                        <template slot="title">
                            <i :class="iconObj[item.id]"></i>
                            <span>{{ item.menuName}}</span>
                        </template>
                        <!-- 二级菜单 -->
                        <el-menu-item :index="subItem.path" v-for="subItem in item.children" :key="subItem.id" @click="saveNavState(subItem.path)">
                            <!-- 导航开启路由模式：
                              将index值作为导航路由 -->
                            <!-- 二级菜单的模板区域 -->
                            <template slot="title">
                                <i class="el-icon-menu"></i>
                                <span>{{ subItem.menuName}}</span>
                            </template>
                        </el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        name: "Home",
        data(){
            return {
                menuList: [],
                iconObj: {
                    '125': 'iconfont icon-user',
                    '103': 'iconfont icon-tijikongjian',
                    '101': 'iconfont icon-shangpin',
                    '102': 'iconfont icon-danju',
                    '145': 'iconfont icon-baobiao'
                },
                // 默认不折叠
                isCollapse: false,
                // 被激活导航地址
                activePath: ''
            }
        },
        created () {

            this.getMenuList()
            this.activePath = window.sessionStorage.getItem('activePath')
        },
        methods :{
            // 获取请求菜单
            async getMenuList () {
                const { data: res } = await this.$http.get('menu/userMenu')

                this.menuList = res.data
                // console.log(res)
            },
            toggleCollapse (){
                this.isCollapse = !this.isCollapse
            },
            saveNavState (active){
                window.sessionStorage.setItem('activePath',active)
            }
        }
    }
</script>

<style lang="less" scoped>
    .el-menu-item{
        >span{
            margin-left: 15px;
        }
    }
    .el-header{
        background-color: #23262E;
        /*开启flex布局*/
        display: flex;
        /*元素靠两边展示*/
        justify-content: space-between;
        padding-left: 0;
        align-items: center;
        color: white;
        font-size: 20px;
        >div{
            display: flex;
            align-items: center;
            span{
                margin-left: 15px;
            }
        }
    }
    .el-aside{
        background-color: #23262E;
        .el-menu{
            border-right: 0;
        }
    }
    .el-main{
        background-color: #F2F2F2;
    }
    .home-container{
        height
           : 100%;
    }
    .toggle-button{
        background-color: #23262E;
        font-size: 10px;
        line-height: 24px;
        color: white;
        text-align: center;
        letter-spacing: 0.2em;
        cursor: pointer;
    }

</style>

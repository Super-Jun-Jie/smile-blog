import Vue from 'vue'
import Router from 'vue-router'
//导入element-ui
import './plugins/element-ui'


Vue.use(Router)

const router = new Router({
    //去掉默认请求中携带的#
    mode: 'history',
    routes: [
        //重定向
        {path: '/', redirect: '/timeline'},
        {
            path: '/home', component: resolve => require(['@/components/Home'], resolve),
            redirect: 'home/article',
            children: [
                {
                    path: 'article',
                    component: resolve => require(['@/components/Article'], resolve),
                },
                {
                    path: 'category',
                    component: resolve => require(['@/components/Category'], resolve),
                },
                {
                    path: 'file',
                    component: resolve => require(['@/components/File'], resolve),
                },
                {
                    path: 'tools',
                    component: resolve => require(['@/components/Tools'], resolve),
                },
                {
                    path: 'system',
                    component: resolve => require(['@/components/System'], resolve),
                },
            ]
        },
        {
            path: '/boke',
            component: resolve => require(['@/components/BoKe'], resolve),
        },
        {
            path: '/timeline',
            component: resolve => require(['@/components/Timeline'], resolve),
        }


    ]
})

// router.beforeEach((to,from,next)=>{
//     if (to.path === '/login') return next()
//     if (!window.sessionStorage.getItem("token"))return next("/login")
//     next()
// })

export default router

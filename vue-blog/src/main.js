import Vue from 'vue'
import App from './App'
import router from "@/router";
import './assets/css/global.css'

import './utils/utils'
import {mavonEditor} from 'mavon-editor'
// 可以通过 mavonEditor.markdownIt 获取解析器markdown-it对象
import 'mavon-editor/dist/css/index.css'



import axios from 'axios'
// 引入icon
import './assets/icon/iconfont.css'

Vue.prototype.$http = axios

/*请求*/
axios.interceptors.request.use(config => {
    console.log(config)
    config.url = 'http://127.0.0.1:8082/' + config.url

    console.log(config)
    return config
})
Vue.config.productionTip = false

/*响应*/
axios.interceptors.response.use(response => {
        if (response.data.info.code !== 200) {
            Vue.prototype.$message({
                type: "error",
                message: response.data.info.message
            });
        }else {
            return response
        }
    },
    error => {
        return Promise.reject(error)
    }
)
Vue.component("mavon-editor", mavonEditor);
Vue.use(router)
new Vue({
    router,
    render: h => h(App)
}).$mount('#app')

// // 定时刷新access-token
// if (!response.data.value && response.data.data.message === 'token invalid') {
//     // 刷新token
//     store.dispatch('refresh').then(response => {
//         sessionStorage.setItem('access_token', response.data)
//     }).catch(error => {
//         throw new Error('token刷新' + error)
//     })
// }

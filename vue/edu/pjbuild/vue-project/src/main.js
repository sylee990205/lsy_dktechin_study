import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"
import store from "./store_vuex/store";
// 객체를 보관하여 공유하는 store 객체를 직접 생성
// store라는 이름으로 생성한 것

createApp(App).use(router).use(store).use(createPinia()).mount('#app')

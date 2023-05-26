import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import StudyView1 from '../views/StudyView1.vue'
import WorkView from "@/views/WorkView.vue";
import StudyView2 from "../views/StudyView2.vue";
import StudyView3 from "../views/StudyView3.vue";

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/study1',
    name: 'study1',
    component: StudyView1
  },
  {
    path: '/work',
    name: 'work',
    component: WorkView
  },
  {
    path: '/study2',
    name: 'study2',
    component: StudyView2
  },
  {
    path: '/study3',
    name: 'study3',
    component: StudyView3
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

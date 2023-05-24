// 라우트 컴포넌트
import Comp1 from './components/Comp1.js';
import Comp2 from './components/Comp2.js';
import Comp3 from './components/Comp3.js';
import Comp4 from './components/Comp4.js';
import Comp5 from './components/Comp5.js';

    const router = VueRouter.createRouter({
      history: VueRouter.createWebHashHistory(),
      routes: [
        {
          path: "/one",
          component: Comp1,
        },
        {
          path: "/two",
          component: Comp2,
        },
        {
          path: "/three",
          component: Comp3,
        },
        {
          path: "/four",
          component: Comp4,
        },
        {
          path: "/five",
          component: Comp5,
        },
      ],
    });

    Vue.createApp({
      data() {
        return {
          abc: "라우트 학습-2"
        }
      }
    }).use(router).mount('#app');

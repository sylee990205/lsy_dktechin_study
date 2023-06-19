// store/index.js
import { createStore } from "vuex";

export default createStore({
  state: {
    counter: 10
  },
  getters: {
    time2(state) {
      // counter 변경은 불가
      // 읽어온 데이터를 가공하여 사용 가능
      return state.counter * 2;
    }
  },
  mutations: {
    setCounter(state, value) {
      state.counter = value; // counter 값 변경 가능
    }
  },
  actions: {
    setLayzCounter(context) {
      setTimeout(() =>context.commit('setCounter', 1000), 5000)
      // argument로 context 객체 전달
      // context 객체 = Vuex 가 관리하는 store 객체의 관리 객체
      // commit에 메세지를 지정하여 setCounter 라는 method 호출을 통해 mutations 수행하겠다
    }
  }
  
});

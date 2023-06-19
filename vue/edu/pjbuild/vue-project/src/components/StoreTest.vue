<template>
        <div>
                <h2>Vuex의 store 를 사용하여 출력하는 내용</h2>
                <h3>{{ counter }}</h3>
                <h3>getter 호출 : {{ test }}</h3>
                <button @click="inc">mutation 호출결과</button>
                <button @click="asyncinc">action 호출결과</button>
        </div>
</template>
<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
        setup() {
                const store = useStore();
                console.log(store)
                const counter = computed(() => store.state.counter);
                const test = computed(() => store.getters);
                const inc = () => store.commit("setCounter", counter.value + 1);
                const asyncinc = () => store.dispatch("setLayzCounter");

                return { counter, inc, test, asyncinc };
        }
};
</script>
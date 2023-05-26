<template>
  <div>
    <h3>Calculator2-computed 사용</h3>
    <div>
      <input type="text" v-model="state.num1" />
      <span> + </span>
      <input type="text" v-model="state.num2" />
      <span> = </span>
      <span>{{ state.result }}</span>
    </div>
  </div>
</template>
<script>
import { reactive, computed } from 'vue';
export default {
  setup() {
    let state = reactive({
      num1: 0,
      num2: 0,
      // computed를 이용해서 num1, num2가 변경이 일어나면 즉시 result로 더한 값을 반환
      result: computed(() => parseInt(state.num1) + parseInt(state.num2))
    });
    return {
      state
    }
  }
}
</script>
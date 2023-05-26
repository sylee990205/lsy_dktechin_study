<template>
  <div>
    <h3>Calculator_s-이벤트처리</h3>
    <div>
      <input type="text" v-model="state.num1" @keyup="plusNumbers" />
      <span> + </span>
      <input type="text" v-model="state.num2" @keyup="plusNumbers" />
      <span> = </span>
      <span>{{ state.result }}</span>
    </div>
  </div>
</template>
<script setup>
import { reactive } from 'vue';
let state = reactive({
  num1: 0,
  num2: 0,
  result: 0
});
function plusNumbers() {
  state.result = parseInt(state.num1) + parseInt(state.num2);
}
</script>
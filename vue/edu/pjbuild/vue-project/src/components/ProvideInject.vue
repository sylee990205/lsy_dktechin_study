<template>
  <div>
    <h2>provide와 inject</h2>
    <ProvideInjectChild />
  </div>
</template>
<script setup>
import ProvideInjectChild from './ProvideInjectChild';
import { provide, ref, reactive } from 'vue'

provide('pmess', '안녕?');
const count = ref(10);
provide('pnum', count);
const obj = reactive({
  name: "유니코",
  age: 20
});
provide('pobj', obj);
</script>
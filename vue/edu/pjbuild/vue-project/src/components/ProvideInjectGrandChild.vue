<template>
  <h4>자손도 받았어요.. {{ message }}</h4>
  <h4>자손도받았어요.. {{ number }}</h4>
  <h4>자손도 받았어요.. {{ obj.name }}</h4>
  <h4>자손도 받았어요.. {{ obj.age }}</h4>
</template>
<script setup>
import { inject } from 'vue'

const message = inject('pmess'); // ProvideInject 로부터 받음
const number = inject('pnum'); // ProvideInject 로부터 받음
const obj = inject('pobj'); // ProvideInjectChild 로부터 받음
</script>
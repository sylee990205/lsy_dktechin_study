<template>
  <div class="study">
    <h1>유니코의 Vue 학습 페이지-33</h1>
  </div>
  <hr />
  <ParentComponent></ParentComponent>
  <hr />
  <ParentComponent2></ParentComponent2>
  <hr />
  <ParentComponent3></ParentComponent3>
  <hr />
  <ParentComponent4></ParentComponent4>
  <hr />
</template>

<script setup>
// @ is an alias to /src
import ParentComponent from '@/components/ParentComponent.vue'
import ParentComponent2 from '@/components/ParentComponent2.vue'
import ParentComponent3 from '@/components/ParentComponent3.vue'
import ParentComponent4 from '@/components/ParentComponent4.vue'
</script>

<style>
.study {
  color: blue;
}

.redline {
  height: 3px;
  background-color: brown;
}
</style>

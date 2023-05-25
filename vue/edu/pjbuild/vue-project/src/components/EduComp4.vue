<template>
  <div>
    <div class="name">{{ name }}</div>
    <div class="name">{{ name.lastName }}</div>
    <div class="name">{{ name.firstName }}</div>
    <button @click="updateName">Click</button>
  </div>
</template>

<script>
import { reactive } from "vue";

export default {
  setup() {
    const name = reactive({
      firstName:"길동", lastName:"고"
    });

    const updateName = () => {
      name.firstName = "둘리";
      name.lastName = "김"
    };
    return {
      name,
      updateName,
    };
  },
};
</script>

<style>
    .name {
      color : magenta;
    }
</style>
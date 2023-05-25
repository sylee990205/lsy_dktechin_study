<template>
  <h2>{{title}}</h2>
</template>
<script>
export default {
  props: {
    title: {
      type: String,
      default: "페이지 제목입니다."
    }
  }
}
</script>
<style scoped>
/* scoped를 적용시키면 해당 component 에만 적용됨 */
  h2 {
    color:blueviolet;
  }
</style>
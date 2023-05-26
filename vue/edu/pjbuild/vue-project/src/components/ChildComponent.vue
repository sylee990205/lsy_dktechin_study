<template>
  <button type="button" @click="childFunc" ref="btn">자식버튼</button>
</template>
<script setup>
const childFunc = function () {
  window.alert('부모 컴포넌트(ParentComponent)에서 자식의 태크에 발생시킨 클릭이벤트!!');
}
</script>
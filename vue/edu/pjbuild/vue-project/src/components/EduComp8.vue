<template>
  메인보드의 가격: <input type="text" v-on:input="price = $event.target.value" v-bind:value="price">
</template> 

<script>
import { ref, watch } from 'vue'

export default {
  setup() {
    const price = ref(112053)

    watch(price, (cur, prev) => {
        console.log('price의 변경된 값 :', cur) // 현재값
        console.log('price의 변경되기 전의 값 :', prev) // 이전값
      },
      {
        immediate: true, //즉시 -> 처음에 만들어졌을때도 수행하도록 함
      }
    )

    return {
      price,
    }
  },
}
</script>

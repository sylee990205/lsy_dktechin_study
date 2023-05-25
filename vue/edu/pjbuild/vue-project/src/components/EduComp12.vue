<template>
<div>
  {{ groceryList }}
  <ol>
    <!--   각 구성 요소에 "키"를 제공해야 한다.  -->    
    <TodoItem   v-for="item in groceryList"     :todo="item"    :key="item.id"></TodoItem>
  </ol>
</div>
</template>

<script>
import { reactive } from 'vue'
import TodoItem from './TodoItem.js'

export default {
  components: {
      TodoItem
  },
  setup() {
    const groceryList = reactive([
      { id: 0, text: '뷰 공부' },
      { id: 1, text: '스프링 공부' },
      { id: 2, text: '자바 공부' }
    ])   
    return {
      groceryList,
    }
  }
}
</script>

<style>
  li {
    list-style-position: inside;
  }
</style>

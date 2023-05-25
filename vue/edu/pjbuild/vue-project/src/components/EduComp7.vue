<template>
    <ul>
      <li v-for="item in items" v-bind:key="item.name"> <!-- v-for 는 v-bind:key를 반드시 지정해야함 -->
        {{ item.name }}의 가격: <input type="text" v-on:input="item.price = $event.target.value" v-bind:value="item.price">
      </li> 
    </ul> 
    <hr>
    <div>
      <ul>
        <li v-for="item in items" v-bind:key="item.name">
        {{ item.name }}: {{ item.price }} x {{ item.quantity }} = {{ item.price * item.quantity }} 원
        </li>
      </ul>
      <p>합계: {{ totalPrice() }} 원</p>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue'
  
  export default {
    setup() {
      const items = ref([
        {
          name: 'CPU', price: 462984, quantity: 1
        }, 
        {
          name: '메인보드', price: 112053, quantity: 1
        }, 
        {
          name: '메모리', price: 79608, quantity: 2
        }
      ])
  
      const totalPrice = () => {
        return items.value.reduce(function (sum, item) {
          return sum + (item.price * item.quantity)
        }, 0)
      }
  
      return {
        items,
        totalPrice,
      }
    },
  }
  </script>
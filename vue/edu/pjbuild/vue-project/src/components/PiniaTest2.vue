<template>
        <h3>Option API 스타일의 스토아</h3>
        <div>num1: {{ num1 }}</div>
        <div>num2: {{ num2 }}</div>
        <div>num2: {{ store1.count }}</div>
        <button @click="store1.count++">1 증가(연산식)</button>
        <button @click="store1.increment">1 증가(action 호출)</button>
        <div>현재 값: {{ store1.count }}</div>
        <hr />
        <h3>Composition API 스타일의 스토아</h3>
        <div>친구 이름: {{ name }}</div>
        <div>친구 나이 : {{ age }}</div>
        <button @click="store2.updateAge(5)">친구나이변경</button>
        <button @click="age++">+</button>
</template>

<script setup>
import { useCounterStore } from '@/stores/counter'
import { useFriendStore } from '@/stores/friendstore'
// 반응성을 유지하면서 구조분해할당 할 수 있는 storeToRefs
import { storeToRefs } from 'pinia'

const store1 = useCounterStore();
let num1 = store1.count;
// 값을 꺼내 일반 변수에 담았음 -> 반응성을 없앤것
store1.increment();
let num2 = store1.count;

const store2 = useFriendStore()
// 반응형을 유지하면서 값을 꺼냄
const { name, age } = storeToRefs(store2)

// 이렇게 값을 꺼내면 반응형이 사라지는 것
let name1 = store2.name;
let age1 = store2.age;
let i = 0;
while(i < 10){
  setTimeout(() => {
    console.log(name1);
    console.log(age1);
  }, 5000);
  i++;
}

</script>


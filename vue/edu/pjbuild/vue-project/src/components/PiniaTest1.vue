<template>
        <!-- Access the state directly from the store -->
        <div>현재 값: {{ counter.count }}</div>
</template>

<script setup>
import { useCounterStore } from '@/stores/counter'

const counter = useCounterStore()
console.log(counter);
counter.count++
// with autocompletion ✨
counter.$patch({ count: counter.count + 1 })
// store에 들어있는 데이터의 일부분을 변경할 수 있게하는 것
// count 라는 애만 현재 count 값에서 +1을 하여 변경한것
// or using an action instead
counter.increment()
</script>


import { defineStore } from 'pinia'
import { ref } from 'vue'

// Composition API
export const useFriendStore = defineStore('friend', () => {
  const age = ref(10)
  const name = ref('둘리')
  function updateAge(n) {
    age.value+=n;
  }
  return { age, name, updateAge }
})
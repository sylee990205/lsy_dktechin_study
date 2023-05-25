<template>
  <div>
    {{ date1 }}
  </div>
  <div>
    {{ date2 }}
  </div>
  </template>

<script>
export default {
  // Composition API
  setup() {
    const date1 = Date().toString()
    return {
      date1,
    }
  },

  // Option API
  data() {
    return {
      date2: Date().toString(),
    }
  },
}
</script>


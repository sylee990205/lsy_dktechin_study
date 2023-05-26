<template>
  <div>저는 Composition API를 사용한 자식 컴포넌트입니당.. 콘솔창에서 결과 보세요..</div>
</template>
<script setup>
import { onMounted, defineEmits } from 'vue';
const emit = defineEmits(["send-message"]);
const msg = 'Composition Setup API를 사용한 자식 컴포넌트로부터 보내는 메시지';
onMounted(() => {
  emit('send-message', msg)
})
</script>
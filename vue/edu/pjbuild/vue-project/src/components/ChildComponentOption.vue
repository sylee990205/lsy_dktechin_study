<template>
  <div>저는 Option API를 사용한 자식 컴포넌트입니당.. 콘솔창에서 결과 보세요..</div>
</template>
<script>
export default {
  data() {
    return {
      msg: 'Option API를 사용한 자식 컴포넌트로부터 보내는 메시지'
    };
  },
  mounted() {
    this.$emit('send-message', this.msg)
  }
}
</script>
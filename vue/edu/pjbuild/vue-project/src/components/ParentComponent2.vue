<template>
  <child-component2 @send-message="sendMessage" ref="child2">
    이건 slot 기능 테스트용 컨텐트~~ <!-- child의 slot 영역으로 보내짐 -->
  </child-component2>
</template>
<script>
import ChildComponent2 from './ChildComponent2';
export default {
  components: { ChildComponent2 },
  mounted() {
    this.$refs.child2.callFromParent();
  }
}
</script>
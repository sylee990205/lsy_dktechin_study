<template>
  <child-component3 @send-message="sendMessage" ref="child3" />
  <button type="button" @click="changeChildData">자식 컴포넌트 반응형 변수의 값을 변경해 보자</button>
</template>
<script>
import ChildComponent3 from './ChildComponent3';

export default {
  components: { ChildComponent3 },
  methods: {
    changeChildData: function () {
      this.$refs.child3.msg = "부모 컴포넌트(ParentComponent3)가 변경한 데이터";
    }
  }
}
</script>

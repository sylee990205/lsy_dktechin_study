<template>
  <button @mouseover="sendMessage">부모버튼</button>
  <child-component ref="child1" />
</template>
<script>
import ChildComponent from './ChildComponent';
export default {
  components: { ChildComponent },
  methods: {
    sendMessage: function () {
      this.$refs.child1.$refs.btn.click();  // 자식 DOM 객체에 이벤트 발생      
    }
  }
};

</script>   
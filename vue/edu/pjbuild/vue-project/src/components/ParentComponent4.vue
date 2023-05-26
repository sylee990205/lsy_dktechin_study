<template>
  <child-component-option @send-message="sendMessage" />
  <child-component-compo @send-message="sendMessage" />
  <child-component-setup @send-message="sendMessage" />
</template>
<script>
import ChildComponentOption from './ChildComponentOption';
import ChildComponentCompo from './ChildComponentCompo';
import ChildComponentSetup from './ChildComponentSetup';
export default {
  components: { ChildComponentOption, ChildComponentCompo, ChildComponentSetup },

  methods: {
    sendMessage(data) {
      console.log("@@ : " + data);
    }
  }
}
</script>
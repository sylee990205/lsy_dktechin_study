<template>
	<div>
		<button @click="increment()">Counter: {{ counter }}</button>
	</div>
</template>

<script>
import { onMounted, ref } from 'vue';

export default {
	setup() {
		const counter = ref(0); // reactive() 보관, 객체형만 가능
    // ref는 구별하지않음
		const increment = () => counter.value++;
		onMounted(() => {
      // 마운트되면
			console.log('애플리케이션이 마운트 되었습니다!');
		});
		return { // 객체로 만들어서 return 해야만 template 영역에서 사용 가능
			counter,
			increment,
		};
	},
};
</script>
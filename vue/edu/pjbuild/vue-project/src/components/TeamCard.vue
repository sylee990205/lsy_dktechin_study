<template>
    <div class="card" style="width: 18rem;margin: auto;">
        <img v-bind:src="srcUrl" class="card-img-top" width="70" height="200" alt="...">
        <div class="card-body">
            <h5 class="card-title">{{ name }}</h5>
            <p class="card-text">{{ food }}</p>
            <button class="btn btn-primary" @click="handleClick">OK</button>
        </div>
    </div>
</template>
<script setup>
    import { defineProps } from 'vue'; 
    const p = defineProps( {
        name : String,
        food : {
            type: String,
            default: "떡볶이"            
        },
        srcUrl: String,
        teamNum : Number   
    });
    function handleClick() {
        alert(`${p.teamNum}팀 입니다~~~!!`);
    }
</script>


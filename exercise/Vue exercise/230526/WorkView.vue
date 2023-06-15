<template>
  <div class="work">
    <h1>소영이의 Vue 실습 페이지</h1>
    <div id="cards">
      <TeamCard v-for="(item, index) in members" :name="item.name" :food="item.food" :src-url="item.srcUrl" :team-num="3" :index="index" :key="index" @delete-member="deleteMember"></TeamCard>
    </div>
  </div>
</template>
<script setup>
import TeamCard from "@/components/TeamCard.vue";
import { reactive } from "vue";

const members = reactive([
    { name :'철진', food :'김치찌개', srcUrl :'https://avatars.githubusercontent.com/u/52393564?v=4'},
    { name :'소영', food :'고기만두', srcUrl :'https://item.kakaocdn.net/do/9667fc490a33d591d57a6f69ee9c137df43ad912ad8dd55b04db6a64cddaf76d'},
    { name :'인영', food :'떡볶이', srcUrl :'https://avatars.githubusercontent.com/u/111550787?v=4'},
    { name :'승현', food :'김치만두', srcUrl :'https://avatars.githubusercontent.com/u/113760476?v=4'},

  ])

function deleteMember(data) {
  console.log(data);
  members.splice(data, 1);
}

</script>
<style scoped>
  #cards {
    display: flex;
    max-width: 80%;
    margin: 1px auto;
  }
</style>
<template>
  <div class="work">
    <h1>소영이의 Vue 실습 페이지</h1>
    <div id="cards">
      <TeamCard name="철진" food="김치찌개" team-num="3" src-url="https://avatars.githubusercontent.com/u/52393564?v=4"></TeamCard>
      <TeamCard name="인영" food="떡볶이" team-num="3" src-url="https://avatars.githubusercontent.com/u/111550787?v=4"></TeamCard>
      <TeamCard name="소영" food="고기만두" team-num="3" src-url="https://item.kakaocdn.net/do/9667fc490a33d591d57a6f69ee9c137df43ad912ad8dd55b04db6a64cddaf76d"></TeamCard>
      <TeamCard name="승현" food="김치만두" team-num="3" src-url="https://avatars.githubusercontent.com/u/113760476?v=4"></TeamCard>
    </div>
  </div>
</template>
<script>
import TeamCard from "@/components/TeamCard.vue";

  export default {
    name: 'WorkView',
    components: {
      TeamCard
    }
  }
</script>
<style scoped>
  #cards {
    display: flex;
    max-width: 80%;
    margin: 1px auto;
  }
</style>
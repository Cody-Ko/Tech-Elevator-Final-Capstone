<template>
  <div class ='searchforum'>
    Here is what we found!
    <div>
        <ForumsCard v-for="forum in forums" v-bind:forum="forum" v-bind:key="forum.forum_name"/>
    </div>

  </div>
</template>

<script>

import ForumService from '../services/ForumService';
import ForumsCard from '../components/ForumsCard.vue';
// import SearchCard from '../components/SearchCard.vue';

export default {
    components: {
        ForumsCard
    },

    data() {
        return {
            keyword: this.$route.params.keyword,
            foundForums:[],
        }
    },
    methods: {
        getForumsByKeyword(keyword){
            ForumService.getForum(keyword).then((response)=>{
                this.foundForums = response.data;
            })
            /*
            .catch((error) =>{
                this.handleErrorResponse(error);
            });
            */
        },
    },
    created(){
        this.getForumsByKeyword(this.keyword);
    }
}
</script>

<style>

</style>
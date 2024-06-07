<template>
  Here is what we found!
  <div class ='searchforum'>

  </div>
</template>

<script>

import ForumService from '../services/ForumService';
import ForumsCard from '../components/ForumsCard.vue';
import SearchCard from '../components/SearchCard.vue';

export default {
    components: {

    },

    data() {
        return {
            forumkeyword: this.$route.params.forumkeyword,
        }
    },
    methods: {
        getForumsByKeyword(forumkeyword){
            ForumService.getForum(forumkeyword).then((response)=>{
                this.forum = response.data;
            })
            /*
            .catch((error) =>{
                this.handleErrorResponse(error);
            });
            */
        },
    },
    created(){
        this.getForumsByKeyword;
    }
}
</script>

<style>

</style>
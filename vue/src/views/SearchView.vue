<template>
    <h1 class="classmeup">Here is what we found!</h1>
  <div class ='searchforum'>
    <SearchCard v-for="forum in foundForums" v-bind:forum="forum" v-bind:key="forum.forum_id"/>

  </div>
</template>

<script>

import ForumService from '../services/ForumService';
// import ForumsCard from '../components/ForumsCard.vue';
import SearchCard from '../components/SearchCard.vue';

export default {
    components: {
        // ForumsCard,
        SearchCard
    },

    data() {
        return {
            keyword: this.$route.params.keyword,
            foundForums:[],
        }
    },
    methods: {
        getForumsByKeyword(keyword){
            ForumService.getForumsByKeyword(keyword).then((response)=>{
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

<style scoped>

/* .searchforum .forumName .forum-section{
    font-size: 2.5rem;
    color: white;
    text-decoration: none;
    text-align: center;
    margin-top: 1px;

}

.searchforum{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    border: 8px solid rgb(250, 129, 240);
    border-radius: 25px;
    min-width: 450px;
    height: 250px;
    max-width: 650px;
    margin-bottom: 10px;
}

.classmeup{
    font-size: 2.5rem;
    color: white;
    text-decoration: none;
    text-align: center;
    margin-top: 1px;

}

.card .timeStamp{
    font-size: 1rem;
    color: white;
    align-self: flex-end;
    margin-right: 10px;
}

.ForumViewLink {
    text-decoration: none;
    color: white;
}

.white-star{
    color: white;
    font-size: 35px;
    margin-top: 5px;
    margin-left: 85%;
    margin-right: 10px;
}

.yellow-star{
    color: white;
    font-size: 35px;
    margin-top: 5px;
    margin-left: 85%;
    margin-right: 10px;
}

.forumName{
    margin: 5%;
}

.timeStamp{
    margin-bottom: 2%;
} */

.classmeup{
    font-size: 2.5rem;
    color: white;
    text-decoration: none;
    text-align: center;
    margin-top: 1px;

}

</style>
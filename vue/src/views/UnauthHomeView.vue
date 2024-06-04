<template>
    <div class="home">
      <h1 class="pageHeader">Forums</h1>
      <!-- Header for Trending Forums (up-votes) and Active Forums (comments) within 24hr window
        Pull in a component that uses the ForumsCard to display the content -->
    </div>
    <div>
      <ForumsCard v-for="forum in forums" v-bind:forum="forum" v-bind:key="forum.forumId"/>
    </div>

  </template>
  
  <script>

import ForumService from '../services/ForumService'
import ForumsCard from '../components/ForumsCard.vue'

  export default {
    components: {
      ForumsCard

    },
    data(){
        return {
             forums: [
              {
                forumId: 1,
                userId: 1,
                forumName: "Testing Out Forums",
                timeStamp: new Date("2024-06-04T08:00:00"),
                favoritedForum: true
              },
              {
                forumId: 2,
                userId: 3,
                forumName: "Testing Out Forums Again",
                timeStamp: new Date("2024-06-04T08:30:00"),
                favoritedForum: true
              },
              {
                forumId: 3,
                userId: 2,
                forumName: "Testing Out Forums: Return of the Forums",
                timeStamp: new Date("2024-06-04T09:00:00"),
                favoritedForum: false
              }
             ]
        };
    },
    methods: {
        getForums(){
            ForumService.getAllForums().then((response) =>{
                this.forums = response.data;
            })
            // .catch(error =>{
                
            // })
        }
    },
    created(){
        //this.getForums();
    }
  };
  </script>

<style>
.pageHeader{
  text-align: center;
}

</style>
  
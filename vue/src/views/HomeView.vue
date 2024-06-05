<template>
  <div class="home">
    <h1>Home</h1>
    <p>You are authenticated if you see this.</p>
  </div>
  <h2 class="forums-description">Today's Exciting Forums</h2>
  <div class="forum-section">
    <ForumsCard class = "active-forums" v-for="forum in forums" v-bind:forum="forum" v-bind:key="forum.forumId"/>

  </div>
  <h2 class="posts-description">Today's Trending Posts</h2>
  <div class="post-section">
    <PostCard class="trending-posts" v-for="post in posts" v-bind:post="post" v-bind:key="post.postId"/>
  </div>
</template>

<script>

import ForumService from '../services/ForumService'
import ForumsCard from '../components/ForumsCard.vue'
import PostCard from '../components/PostCard.vue'

  export default {
    components: {
      ForumsCard,
      PostCard

    },
    data(){
        return {
             forums: [
              // REMOVE BELOW OBJECTS ONCE DATABASE HAS FORUMS TO USE
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
             ],
             posts: [
              
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
        // ONCE DATABASE HAS FORUMS TO USE ---> this.getForums();
    }
  };
  </script>

<style>
.pageHeader{
  text-align: center;
}

/* Test */

.forum-section{
  display: flex;
  /* flex-direction: column; */
  
}




</style>

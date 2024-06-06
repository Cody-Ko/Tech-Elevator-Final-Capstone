<template>
    <div class="GuestHome">
      <h1 class="pageHeader">Forums</h1>
      <input class="searchforums" type="text" id="searcher" v-model="filter.forumName"/>
      <!-- Header for Trending Forums (up-votes) and Active Forums (comments) within 24hr window
        Pull in a component that uses the ForumsCard to display the content -->
      <h1>
      <router-link class="register" v-bind:to="{ name: 'register' }">Join the conversation!</router-link></h1>
    </div>
    
    <div class="mainSection">
      <GuestsForumsCard class = "trendingCard" v-for="forum in forums" v-bind:forum="forum" v-bind:key="forum.forumId"/>
    </div>
    <h2 class="posts-description">Today's Trending Posts</h2>
  <div class="post-section">
    <PostCard class="trending-posts" v-for="post in posts" v-bind:post="post" v-bind:key="post.postId"/>
  </div>
  <h3>
      <router-link class="register" v-bind:to="{ name: 'register' }">Create an account!</router-link></h3>

    

  </template>
  
  <script>

import ForumService from '../services/ForumService'
import GuestsForumsCard from '../components/GuestsForumsCard.vue'
import PostCard from '../components/PostCard.vue';

  export default {
    components: {
      GuestsForumsCard,
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
              {
                postId: 1,
                userId: 2,
                forumId: 3,
                title: "Here's a post about Return of the Forums",
                message: "I like this",
                upVotes: 100,
                downVotes: 5,
                timeStamp: new Date("2024-06-04T09:30:00"),
                location: "America"

              },
              {
                postId: 2,
                userId: 3,
                forumId: 2,
                title: "Here's a post about Testing Out Forums Again",
                message: "This isn't too bad",
                upVotes: 50,
                downVotes: 10,
                timeStamp: new Date("2024-06-04T08:35:00"),
                location: "Ghana"
              },
              {
                postId: 3,
                userId: 1,
                forumId: 1,
                title: "Here's a post about Testing Out Forums",
                message: "Forums is cool",
                upVotes: 100,
                downVotes: 1,
                timeStamp: new Date("2024-06-04T08:01:00"),
                location: "England"
              },
             ],
             filter: 0,
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

.mainSection{
  display: flex;
  flex-direction: column;
  
}

.searchforums {
  display: flex;
  justify-content: flex-end;
}


</style>
  
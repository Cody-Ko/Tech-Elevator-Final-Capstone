<template>
  <div class="home">
    <h1>Home</h1>

    <h1 class="linksandsearches">
      <router-link class="register" v-bind:to="{ name: 'register' }">Join the conversation!</router-link>

      <form @submit.prevent="searchForums(keyword)">
          <div class="searchbar">
            <input type="text" v-model="keyword" placeholder="Search here for your criteria!"/>
            <button type="submit">Search</button>
          </div>
        </form>
      </h1>

  </div>

   <!-- <div class="mainSection">
      <GuestsForumsCard class = "trendingCard" v-for="forum in forums" v-bind:forum="forum" v-bind:key="forum.forumId"/>
    </div> -->

  <h2 class="forums-description">Today's Exciting Forums</h2>
  <div class="forum-section">
    <ForumsCard class = "active-forums" v-for="forum in forums" v-bind:forum="forum" v-bind:key="forum.forum_id"/>

  </div>
  <h2 class="posts-description">Today's Trending Posts</h2>
  <div class="post-section">
    <PostCard class="trending-posts" v-for="post in posts" v-bind:post="post" v-bind:key="post.post_id"/>
  </div>
</template>

<script>

import ForumService from '../services/ForumService'
import ForumsCard from '../components/ForumsCard.vue'
import PostCard from '../components/PostCard.vue'
import PostService from '../services/PostService';

  export default {
    props: {
      // keyword: Object,
    },

    components: {
      ForumsCard,
      PostCard

    },
    data(){
        return {
             forums: [
             ],
             posts: [
             ],
             keyword: "",
        };
    },
    methods: {
        getForums(){
            ForumService.getAllForums().then((response) =>{
                this.forums = response.data;
            })
            .catch(error =>{
                
            })
        },
        getPosts(){
          PostService.getAllPosts().then((response) => {
            this.posts = response.data;
          })
          .catch (error => {

          })
        },
        getForumsByKeyword(keyword){
          ForumService.getForumsByKeyword(keyword).then(
            (response) => {
              this.forums = response.data;
              this.$router.push({name: 'searchview', params: {keyword: keyword}})
            }
          )            
        },

        searchForums(keyword) {
          this.getForumsByKeyword(keyword)
        }
    },
    created(){
            this.getForums();
            this.getPosts();
        }
        
    };
  </script>

<style scoped>

.pageHeader{
  text-align: center;
}

/* Test */

.forum-section{
  display: flex;
  justify-content: center;
  /* flex-direction: column; */
  flex-wrap: wrap;  
  justify-content: space-around;
}

.post-section{
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
}

.posts-description{
  text-align: center;
  margin-bottom: 15px;
  color: white;
}

.home{
  margin-left: .85%;
  margin-bottom: 2%;
  color: white;
}

.forums-description{
  margin-left: .85%;
  color: white;
}

.searchbar {
  justify-content: right;
  grid-area: searchforums;
  top: 300px;
  width: 250px;
  margin-left: 300px;
}

.register {
  display: flex;
  grid-area: register;
  margin-left: 150px;
}


.linksandsearches {
  display: grid;
  grid-template-columns: 3fr, 3fr, 1fr;
  grid: 0%;
  grid-template-areas:
  "welcome . searchforums"
  ;
}


</style>

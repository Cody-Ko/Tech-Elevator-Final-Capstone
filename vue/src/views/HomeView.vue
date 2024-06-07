<template>
  <div class="home">
    <h1>Home</h1>

    <h1 class="linksandsearches">
      <h5 class="welcome">Welcome back!</h5>

      <form @submit.prevent="searchForums(keyword)">
          <div class="searchbar">
            <input type="text" v-model="keyword" placeholder="Search here for your criteria!"/>
            <button type="submit">Search</button>
          </div>
        </form>
      </h1>

  </div>
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
    components: {
      ForumsCard,
      PostCard

    },
    data(){
        return {
             forums: [

              // REMOVE HARD CODED OBJECTS ONCE DATABASE HAS FORUMS TO USE
              // {
              //   forumId: 1,
              //   userId: 1,
              //   forumName: "Testing Out Forums",
              //   timeStamp: new Date("2024-06-04T08:00:00"),
              //   favoritedForum: true
              // },
              // {
              //   forumId: 2,
              //   userId: 3,
              //   forumName: "Testing Out Forums Again",
              //   timeStamp: new Date("2024-06-04T08:30:00"),
              //   favoritedForum: true
              // },
              // {
              //   forumId: 3,
              //   userId: 2,
              //   forumName: "Testing Out Forums: Return of the Forums",
              //   timeStamp: new Date("2024-06-04T09:00:00"),
              //   favoritedForum: false
              // }
             ],
             posts: [
              // {
              //   postId: 1,
              //   userId: 2,
              //   forumId: 3,
              //   title: "Here's a post about Return of the Forums",
              //   message: "I like this",
              //   upVotes: 100,
              //   downVotes: 5,
              //   timeStamp: new Date("2024-06-04T09:30:00"),
              //   location: "America"

              // },
              // {
              //   postId: 2,
              //   userId: 3,
              //   forumId: 2,
              //   title: "Here's a post about Testing Out Forums Again",
              //   message: "This isn't too bad",
              //   upVotes: 50,
              //   downVotes: 10,
              //   timeStamp: new Date("2024-06-04T08:35:00"),
              //   location: "Ghana"
              // },
              // {
              //   postId: 3,
              //   userId: 1,
              //   forumId: 1,
              //   title: "Here's a post about Testing Out Forums",
              //   message: "Forums is cool",
              //   upVotes: 100,
              //   downVotes: 1,
              //   timeStamp: new Date("2024-06-04T08:01:00"),
              //   location: "England"
              // },
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

.welcome {
  display: flex;
  grid-area: welcome;
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

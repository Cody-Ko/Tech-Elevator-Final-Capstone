<template>
  <section class="whole-page">

    <section class="left-panel">

      <h1 class="home-text">Home</h1>

      <router-link class="ResourcesViewLink" 
      v-bind:to="{name: 'resources'}">
        <h1 class="resources-link"> Resources</h1>
      </router-link>

      <!-- <router-link class="CreatePostViewLink" v-bind:to="{name: 'createpost'}">
        <h1 class="create-post">Create A Post</h1>
      </router-link> -->
    </section>

    <section class="main-section">
      <section class ="top-section">
      
          <h1 class="welcome">Welcome back!</h1>
    <form @submit.prevent="searchForums(keyword)">
        <div class="searchbar">
          <input type="text" v-model="keyword" 
          placeholder="Search here for your criteria!"/>
          <button type="submit">Search</button>
        </div>
      </form>

      <h1 class="linksandsearches">
      <router-link class="register" v-bind:to="{ name: 'register' }">Join the conversation!</router-link>
      </h1>  
    
    </section>
    
    <section class="main-content">
      <h2 class="forums-description">Today's Exciting Forums</h2>

  <div class="forum-section">
    <ForumsCard class = "active-forums" v-for="forum in forums" 
    v-bind:forum="forum" v-bind:key="forum.forum_id"/>

  </div>
  <h2 class="posts-description">Today's Trending Posts</h2>
  <div class="post-section">
    <PostCard class="trending-posts" v-for="post in posts" 
    v-bind:post="post" 
    v-bind:key="post.post_id"/>
  </div>
    </section>
    </section>
  </section>
  
  <div class="home">
    

    

  </div>
 
</template>

<script>

import ForumService from '../services/ForumService';
import ForumsCard from '../components/ForumsCard.vue';
import PostCard from '../components/PostCard.vue';
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

.whole-page{
  display: flex;
  /* height: 100%; */
  overflow-y: auto;
}

.home-text{
  padding-top: 20%;
  border-bottom: 5px solid rgb(250, 129, 240);
  margin-right: 10px;
  padding-bottom: 10%;

}

.ResourcesViewLink{
  text-decoration: none;
  color: white;
}

.CreateForumViewLink{
  text-decoration: none;
  color: white;
}



.resources-link{
  border-bottom: 5px solid rgb(250, 129, 240);
  margin-right: 10px;
  padding-bottom: 10%;
}

.left-panel{
  position: fixed;
  display:flex;
  flex-direction: column;
  width: 5%;
  border-right: 5px solid rgb(250, 129, 240);
  height: 100vh;
  /* padding-top: 2px; */
  padding-left: 3px;
  color: white;
  font-size: 1rem;
  z-index: 0;
}


.top-section{
  display: flex;
  flex-direction: column;
  align-items: center;
}

.main-section{
  flex-grow: 1;
  height: auto;
  overflow-y: auto;
}

.main-content{
  padding-top: 2%;
}

/* Test */

.forum-section{
  display: flex;
  justify-content: center;
  /* flex-direction: column; */
  flex-wrap: wrap;  
  justify-content: space-evenly;
  
}

.post-section{
  display: flex;
  flex-direction: column;
  /* flex-wrap: wrap; */
}

.posts-description{
  text-align: center;
  margin-bottom: 15px;
  color: white;
  font-size: 2rem;
}

/* .home{
  margin-left: .85%;
  margin-bottom: 2%;
  color: white;
} */

.forums-description{
  /* margin-left: .85%; */
  color: white;
  font-size: 2rem;
  text-align: center;
}

.searchbar {
  /* justify-content: right; */
  grid-area: searchforums;
  /* top: 300px; */
  width: 250px;
  /* margin-left: 300px; */

}

.welcome {
  font-size: 3rem;
  color: white;
}

.register {
  display: flex;
  justify-content: center;
  grid-area: register;

  font-size: 35px;
}


.linksandsearches {
  display: grid;
  grid-template-columns: 3fr, 3fr, 1fr;
  grid: 0%;
  grid-template-areas:
  "welcome . searchforums"
  ;
}

/* .linksandsearches {
  display: grid;
  grid-template-columns: 3fr, 3fr, 1fr;
  grid: 0%;
  grid-template-areas:
  ". welcome ."
  ". searchforums ."

  ;
} */



/* Test 1 */
/* Test 2 */
</style>

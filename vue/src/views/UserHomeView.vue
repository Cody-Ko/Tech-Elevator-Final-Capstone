<template>
    <section class="user-whole-page">
    <section class="left-panel">

      <select v-model="Selection" @change="changeView" class="dropdown">
        <option value="">Select</option>

          <option value="Create-Forum">Create Forum</option>
          <option value="Resources">Community Guidelines</option>
          <option value="UserHomeView">User Home</option>

      </select>

    </section>
    <section class="main-section">
      <section class ="top-section">

          <h1 class="welcome">Your Stellar Discussions</h1>
    <form class = "ForumSearch" @submit.prevent="searchForums(keyword)">
        <div class="searchbar">
          <input type="text" v-model="keyword"
          placeholder="Search here for your criteria!"/>
          <button type="submit">Search</button>
        </div>
      </form>
    <!-- </h1> -->
    </section>
    <section class="main-content">
      <h2 class="forums-description">Your Favorite Forums</h2>
  <div class="forum-section">
    <ForumsCard class = "active-forums" v-for="forum in forums"
    v-bind:forum="forum" v-bind:key="forum.forum_id"/>
  </div>
  <h2 class="posts-description">Your Posts</h2>
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
             ],
             posts: [
             ],
             keyword: "",
             Selection: "",
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
        },

        changeView(){
          if(this.Selection === 'Resources'){
            this.$router.push({name:'resources'});
          } else if (this.Selection === 'Create-Forum'){
            this.$router.push({name:'createforum'});
          } else if (this.Selection === "UserHomeView") {
            this.$router.push({name:'userhome'})
          }
        }
       
    },
    created(){
            this.getForums();
            this.getTodaysPopularPosts();
        }
    };
  </script>
<style scoped>


.user-whole-page{
  display: flex;
  overflow-y: auto;
}
.home-text{
  padding-top: 20%;
  border-bottom: 5px solid rgb(250, 129, 240);
  margin-right: 10px;
  padding-bottom: 10%;
}

.dropdown{
  margin-top: 20%;
  margin-right: 10px;
  size: 30px;
  font-size: 23px;

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
.create-forum{
  border-bottom: 5px solid rgb(250, 129, 240);
  margin-right: 10px;
  padding-bottom: 10%;
}
.left-panel{
  position: fixed;
  display:flex;
  flex-direction: column;
  width: 6%;
  height: 100vh;
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
.forum-section{
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  justify-content: space-evenly;
}
.post-section{
  display: flex;
  flex-direction: column;
}
.posts-description{
  text-align: center;
  margin-bottom: 15px;
  color: white;
  font-size: 2rem;
}

.forums-description{
  color: white;
  font-size: 2rem;
  text-align: center;
}
.searchbar {
  grid-area: searchforums;
  width: 250px;
}

.searchbar {
  width: 100%;
  display: flex;
  justify-content: center;
}
.searchbar input, .searchbar button {
  font-size: 20px;
}

.searchbar input {
  width: 400px;
}

.welcome {
  font-size: 3rem;
  color: white;
}
input {
  size: 100px;
}

</style>











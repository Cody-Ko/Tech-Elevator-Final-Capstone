<template>
    <!-- View for a Forum that's been opened 
    Different layout from the ForumsCard
    Should feature more details like posts and comments,
    -->
    <div class="forum-section">
    <!-- Need: ADD POST AND LIKE POST FUNCTIONALITY (IF SIGNED IN - otherwise disable) -->
    <ForumsCard class = "forum-card" v-bind:forum="forum" v-bind:key="forum.forum_id"/>
    </div>

    <CreatePostCard class = 'create-post-card'/>

    

    
    <PostCard v-for="post in posts" v-bind:post="post" v-bind:key="post.post_id"/>

    
  </template>
  
  <script>

import ForumService from '../services/ForumService';
import PostService from '../services/PostService';
import ForumsCard from '../components/ForumsCard.vue';
import PostCard from '../components/PostCard.vue';
import CreatePostCard from '../components/CreatePostCard.vue';


  export default {
    components: {
        ForumsCard,
        PostCard,
        CreatePostCard
    },
    data(){
        return {
            forumId: parseInt(this.$route.params.forumId),
            forumkeyword: "",
            forum: {},
            posts:[]
        };
    },
    methods: {
        getForum(forumId){
            ForumService.getForum(this.forumId).then((response) => {
                this.forum = response.data;
            });
            /*
            .catch((error) =>{
                this.handleErrorResponse(error);
            });
            */
        },
        getAllPostsForForum() {
            PostService.getPostsbyForumId(this.forumId).then(
                (response) => {
                    this.posts = response.data;
                    // if(response.status === 200) {
                    //     this.$router.push('posts');
                    // }
                }
            ).catch(
                // (error) => {
                //     if(error.response) {
                //         this.errorNeedingAddressed(this.error.response, "Post not found");
                //     } else if (error.request) {
                //         this.errorNeedingAddressed(this.error.request, "Post not found");
                //     }
                // }
            )
        },

        
        /*
        handleErrorResponse(error) {
            if (error.response.status == 404) {
                this.$router.push({name: 'NotFoundView'});
            } else {
                this.$store.commit('SET_NOTIFICATION', `Could not get forum data from server.`);
            }
        },
            */
       
    },
    created(){
        this.getForum();
        this.getAllPostsForForum();

    }
  };
  </script>
  
<style scoped>
.forum-section{
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
padding-top: 3%;
}

.create-post-card{
      display: flex;
      align-content: center;
      margin-bottom: 1%;
      border: 8px solid rgb(250, 129, 240);
      color: white;
      margin-top: .5%;
      text-align: center;
      padding: 10px;
}

</style>
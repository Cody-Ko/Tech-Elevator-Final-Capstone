<template>
    <!-- View for a Forum that's been opened 
    Different layout from the ForumsCard
    Should feature more details like posts and comments,
    and incorporate a way to add post, comments, or likes (IF SIGNED IN - otherwise hide)-->
    <div class="forum">
    
    </div>
  </template>
  
  <script>

import ForumService from '../services/ForumService';
import PostService from '../services/PostService';


  export default {
    components: {
        
    },
    data(){
        return {
            forumId: this.$route.params.forumId,
            forumkeyword: "",
            forum: {}
        };
    },
    methods: {
        getForum(forumId){
            ForumService.getForum(forumId).then((response)=>{
                this.forum = response.data;
            })
            /*
            .catch((error) =>{
                this.handleErrorResponse(error);
            });
            */
        },
        getAllPostsForForum(forumId) {
            PostService.getPostsbyForumId(this.posts.forumId).then(
                (response) => {
                    if(response.status === 200) {
                        this.$router.push('posts');
                    }
                }
            ).catch(
                (error) => {
                    if(error.response) {
                        this.errorNeedingAddressed(this.error.response, "Post not found");
                    } else if (error.request) {
                        this.errorNeedingAddressed(this.error.request, "Post not found");
                    }
                }
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

    }
  };
  </script>
  
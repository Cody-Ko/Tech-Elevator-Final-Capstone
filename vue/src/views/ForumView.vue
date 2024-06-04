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


  export default {
    components: {
        
    },
    data(){
        return {
            forumId: this.$route.params.forumId,
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
  
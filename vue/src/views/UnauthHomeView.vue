<template>
    <div class="home">
      <h1 class="pageHeader">Home</h1>
      <!-- Header for Trending Forums (up-votes) and Active Forums (comments) within 24hr window
        Pull in a component that uses the ForumsCard to display the content -->
      <p></p>
    </div>
  </template>
  
  <script>

import ForumService from '../services/ForumService'

  export default {
    components: {

    },
    data(){
        return {
             forums: []
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
        this.getForums();
    }
  };
  </script>

<style>
.pageHeader{
  text-align: center;
}

</style>
  
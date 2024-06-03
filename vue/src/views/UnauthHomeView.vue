<template>
    <div class="home">
      <h1>Home</h1>
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
             forum: []
        };
    },
    methods: {
        getForums(){
            ForumService.getAllForums().then((response) =>{
                this.forum = response.data;
            })
            .catch(error =>{
                
            })
        }
    },
    created(){
        this.getForums();
    }
  };
  </script>
  
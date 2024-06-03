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
  
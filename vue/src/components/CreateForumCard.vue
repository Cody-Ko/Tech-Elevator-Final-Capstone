<template>

<div class="create-forum-home"> Create A Forum</div>
    <form v-on:submit.prevent="addForum">
      
      <label for="forum_name">Name of Forum</label>
      <input type="text" id="forum_name" name="forum_name" v-model="changeForum.forum_name"/>
      
      <div class="submissions">
        <button class="submitBtn" type="submit">Submit</button>
        <button class="cancelBtn" type="button" v-on:click="cancelButton">Cancel</button>
      </div>
    </form>

</template>
  
<script>

import ForumService from '../services/ForumService';

  
export default {
    props: {
      forum: {
        type: Object,
        required: true,
      }
    },
    data() {
      return {
        changeForum: {
          id: 0,
          forum_name: '',
        }

      }
    },
    methods: {
      addForum() {
        ForumService.addForum(this.forum).then (
          (response) => {
            if(response.status === 201) {
              this.$router.push('forumview')
            }
          }
        )
      },
      cancelButton() {
        this.$router.push({name: 'home'});
      }
    },
  
  };
  </script>
  
  <style scoped>
  .PostCard {
      display: grid;
      grid-template-columns: auto 1fr;
      grid-template-areas: 
      "vote-icons post-name"
      "message message"
      "time time";
      /* flex-direction: column;
      justify-content: space-between; */
      border-radius: 15px;
      width: 50%;
      /* max-width: 750px; */
      min-width: 600px;
      /* height: 250px; */
      min-height: 500px;  
      /* margin: 20px; */
      margin: 0 auto;   /* this keeps the card in the middle of the page */
      margin-bottom: 1%;
      border: 8px solid rgb(250, 129, 240);
      /* font-size: 2.5rem; */
      color: white;
      margin-top: .5%;
      text-align: center;
      padding: 10px;
      /* background-image: ; */
  }

  
  /* Test 1 */
  </style>
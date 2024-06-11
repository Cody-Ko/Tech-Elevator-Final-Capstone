<template>

<div class="create-post-home"> Create A Post</div>
    <form v-on:submit.prevent="addPost">
      
      <label for="post_name">Name of Post</label>
      <input type="text" id="post_name" name="post_name" v-model="changePost.title"/>

      <label for="post_message_details">Message of Post</label>
      <input type="text" id="post_message_details" name="post_message_details" v-model="changePost.message"/>
      
      <div class="submissions">
        <button class="submitBtn" type="submit">Submit</button>
        <button class="cancelBtn" type="button" v-on:click="cancelButton">Cancel</button>
      </div>

    </form>

</template>
  
<script>
import PostService from '../services/PostService';
  
export default {
      components: {

      },
      props: {
        post: {
        type: Object,
        required: true,
      }
      },

      data() {
      return {
        changePost: {
        //   id: 0,
        //   forum_user_id: 0,
          title: '',
          message: '',
        //   time_stamp: Date,
          
        },
        forumId: this.$route.forumId,

      }
    },
  
    methods: {
      addPost() {
        PostService.addPost(this.forumId, this.changePost).then(
          (response) => {
            if(response.status === 201) {
              this.$router.push('home')
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
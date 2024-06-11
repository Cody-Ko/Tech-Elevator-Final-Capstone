<template>

<div class="create-post-home"> Create A Post</div>
    <form class ="build-a-post" v-on:submit.prevent="addPost">
      
      <label for="post_name">Name of Post</label>
      <input type="text" id="post_name" name="post_name" v-model="postDto.title"/>

      <label for="post_message_details">Message of Post</label>
      <input type="text" id="post_message_details" name="post_message_details" v-model="postDto.message"/>

      <label for="post_location">Location of Post</label>
      <input type="text" id="post_location" name="post_location" v-model="postDto.location"/>
      
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
        postDto: {
        //   id: 0,
        //   forum_user_id: 0,
          title: '',
          message: '',
          location: '',
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
  .create-post-home {
      display: grid;
      align-content: center;
      /* flex-direction: column;
      justify-content: space-between; */
      border-radius: 15px;
      /* max-width: 750px; */
      /* height: 250px; */ 
      /* margin: 20px; */
      margin: 0 auto;   /* this keeps the card in the middle of the page */
      margin-bottom: 1%;
      font-size: 2.5rem;
      font-weight: bold;
      color: white;
      margin-top: .25%;
      text-align: center;
  }

  .build-a-post {
      display: grid;
      align-content: center;
      /* flex-direction: column;
      justify-content: space-between; */
      border-radius: 15px;
      justify-content: space-around;
      /* width: 50%; */
      /* max-width: 750px; */
      /* min-width: 600px; */
      /* height: 250px; */
      /* min-height: 500px;   */
      /* margin: 20px; */
      margin: 0 auto;   /* this keeps the card in the middle of the page */
      margin-bottom: 1%;
      /* font-size: 2.5rem; */
      color: white;
      margin-top: .25%;
      text-align: center;
      padding: 10px;
      /* background-image: ; */
  }

  
  /* Test 1 */
  </style>
<template>

<div class="create-forum-home"> Create A Forum</div>
    <form class="build-a-forum" v-on:submit.prevent="addForum">
      
      <label for="forum_name">Name of Forum</label>
      <input type="text" id="forum_name" name="forum_name" v-model="changeForum"/>
      
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
        //   id: 0,
        //   forum_user_id: 0,
          forum_name: '',
        //   time_stamp: Date,
          
        }

      }
    },

    methods: {
      addForum() {
        ForumService.addForum(this.changeForum).then(
          (response) => {
            if(response.status === 201) {
              this.$router.push('/')
            }
          }
        )
      },
      cancelButton() {
        this.$router.push("/");
      }
    },
  
  };

  </script>
  
  <style scoped>
  .create-forum-home {
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

  .build-a-forum {
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
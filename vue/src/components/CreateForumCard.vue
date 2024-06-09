<template>

    <div class="."></div>
</template>
  
<script>
  
export default {
      components: {

      },
      props: {
          
          posts: [],
      },
  
      methods: {
          
      }
  
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
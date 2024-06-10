<template>
    <div class="create-forum-home"> Create A Forum</div>
    <CreateForumCard v-bind:forum="forum"/>
</template>
  
<script>

import CreateForumCard from '../components/CreateForumCard.vue';


  export default {
    components: {
      CreateForumCard
    },
    data() {
      return {
        forum: {
          editForum: {
          id: 0,
          forum_name: '',
        }
        }
      }
    }

    
    
  };
</script>
  
<style scoped>

</style>
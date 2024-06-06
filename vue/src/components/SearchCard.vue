<template>
  <div class="searchResults">Search Results</div>

  <div class="forum-section">
    <forumsearch class = "searched-forums" v-for="forum in forums" v-bind:forum="forum" v-bind:key="forum.keyword"/>
    <h1 class="forumname">{{ forum.forum_name }}</h1>

  </div>
</template>

<script>

import ForumService from '../services/ForumService';
import ForumsCard from '../components/ForumsCard.vue';

export default {
    components: {
        
    },

    props: {
        forum: {
            type: Object,
            required: false
        },
        
    },

    data() {
        return {
            
        };
    },

    methods: {
    }
};
</script>

<style>

.searchResults{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    border: 5px solid rgb(250, 129, 240);
    border-radius: 25px;
    min-width: 450px;
    height: 250px;
    /* margin: 20px; */
    /* margin: 0 auto; */
    margin-bottom: 10px;
}

.searchResults .forumName .forum-section{
    font-size: 2.5rem;
    color: white;
    text-decoration: none;
    text-align: center;
    margin-top: 1px;

}

</style>
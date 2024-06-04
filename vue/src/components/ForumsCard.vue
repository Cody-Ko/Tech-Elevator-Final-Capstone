<template>
    <header>
        <h1>{{ forum.name }}</h1>
    </header>
   
    <div class="card">

         <!-- what should the layout look like in the HomeView(s)? 
        (i.e. forum name in the middle, 
        timestamp at the bottom, 
        ability to like a forum (IF SIGNED IN - otherwise hide)-->
        
    </div>
</template>

<script>

import ForumService from '../services/ForumService';
// import PostsComponent from '../components/PostsComponent'

export default{
    components: {
        // PostsComponent
    },
    props: {
        forum: {
            type: Object,
            required: true
        }
        
        /* 
        What is this for/is it needed?
        , 
        enableAdd: {
            type: Boolean,
            default: false
        }
        */
        
    },
    computed: {

    },
    methods: {

    }

};
</script>

<style scoped>

</style>
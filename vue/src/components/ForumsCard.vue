<template>
    <div class="card">
    <header>
        <h1 class="forumName">{{ forum.name }}</h1>
    </header>

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
.card{
    border: 2px solid #34aae1;
    border-radius: 10px;
    width: 550px;
    height: 250px;
    margin: 20px;
}

.card .forumName{
    font-size: 1.5rem
    
}


</style>
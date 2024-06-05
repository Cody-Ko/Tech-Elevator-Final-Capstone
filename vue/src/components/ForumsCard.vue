<template>
 <div class="card">
    <!-- icon for liking a forum -->
    <router-link class="ForumViewLink" v-bind:to="{ name: 'forumview', params:{forumId: forum.forumId} }">
    <header>
        <h1 class="forumName">{{ forum.forumName }}</h1>
    </header>
    </router-link>
    <div class="timeStamp">{{ forum.timeStamp }}</div>

         <!-- what should the layout look like in the HomeView(s)? 
        (i.e. forum name in the middle, 
        timestamp at the bottom, 
        ability to like a forum (IF SIGNED IN - otherwise hide)-->
    
    </div>
</template>

<script>

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
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    border: 5px solid rgb(250, 129, 240);
    border-radius: 10px;
    width: 650px;
    height: 250px;
    margin: 20px;
    /* text-align: center;
    align-content: center; */
    margin: 0 auto;
    margin-bottom: 10px;
}

.card .forumName{
    font-size: 2.5rem;
    color: white;
    text-decoration: none;
    text-align: center;
    margin-top: 95px;

}

.card .timeStamp{
    font-size: 1rem;
    color: white;
    align-self: flex-end;
    margin-right: 10px;
}

.ForumViewLink{
    text-decoration: none;
}

/* Test */
</style>
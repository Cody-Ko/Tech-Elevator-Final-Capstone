<template>
 <div class="card">
    <!-- icon to mark a forum as favorite 
    Aiming to have the color change to yellow when the icon is clicked
    first commented-out code doesn't successfully change the color once clicked
    (ONLY LOGGED IN USERS CAN FAVORITE - add pop up asking you to log in when clicked?)

     -->
     <!-- <button v-on:click="favorite" class="favorite-star"> -->
     <!-- <button v-bind:class="{'fas fa-star yellow-star': iconClick, 'fas fa-star white-star': !iconClick}" v-on:click="favorite"></button> -->
     
        <span v-if="iconClick" @click="favorite">
            <i class="fas fa-star yellow-star"></i>
        </span>
        <span v-else @click="favorite">
            <i class="fas fa-star white-star"></i>
        </span>

     <!-- </button> -->
    <!-- <i class = "fas fa-star white-star"></i> -->
    <router-link class="ForumViewLink" v-bind:to="{ name: 'forumview', params:{forumId: forum.forum_id} }">
    <header>
        <h1 class="forumName">{{ forum.forum_name }}</h1>
    </header>
    </router-link>
    
    <div class="timeStamp">{{ forum.time_stamp }}</div>
    
    </div>
</template>

<script>

// import PostsComponent from '../components/PostsComponent'

export default{
    data(){
        return{
            iconClick: false
        }
    },
    components: {

    },
    props: {
        forum: {
            type: Object,
            required: true
        },
        post: {}
        
    },
    computed: {

    },
    methods: {
        favorite(){
            this.iconClick = !this.iconClick;
            console.log(this.iconClick);
        }

    }

};
</script>

<style scoped>
.card{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    border: 8px solid rgb(250, 129, 240);
    border-radius: 25px;
    min-width: 20%;
    height: 250px;
    max-width: 30%;
    /* margin: 20px; */
    /* margin: 0 auto; */
    margin-bottom: 10px;
}

.card .forumName{
    font-size: 2.5rem;
    color: white;
    text-decoration: none;
    text-align: center;
    margin-top: 1px;

}

.card .timeStamp{
    font-size: 1rem;
    color: white;
    align-self: flex-end;
    margin-right: 10px;
}

.ForumViewLink {
    text-decoration: none;
    color: white;
}

.favorite-star{
    /* cursor: pointer; */
}

.white-star{
    color: white;
    font-size: 35px;
    margin-top: 5px;
    margin-left: 85%;
    margin-right: 10px;
}

.yellow-star{
    color: gold;
    font-size: 35px;
    margin-top: 5px;
    margin-left: 85%;
    margin-right: 10px;
}

.forumName{
    margin: 5%;
}

.timeStamp{
    margin-bottom: 2%;
}


/* Test 2.75 */
</style>
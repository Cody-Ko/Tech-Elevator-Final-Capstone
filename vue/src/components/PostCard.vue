<template>

  <div class="PostCard">
    <div class="top-row">
    <i class="fa-solid fa-meteor vote-up"></i>
    
    <i class="fa-solid fa-meteor vote-down" style=""></i>
    </div>
    
    <router-link class="PostViewLink" v-bind:to="{ name: 'postview', params:{postId: post.post_id} }">
        <header>
        <h1 class="postName">{{ post.title }}</h1>
        
        </header>
    </router-link>
        <h3 class="messageDetails">{{ post.message }}</h3>
    
    <p class="timeStamp">{{ post.time_stamp }}</p>

  </div>
</template>

<script>

import PostService from '../services/PostService.js'

export default {
    components: {
        //Comment components
    },
    props: {
        post: {
            // Cycle through all comments for posts
        },
        posts: [],
    },

    methods: {
        getPost(postId) {
            PostService.getPost(this.postId).then(
                (response) => {
                    if(response.status === 200) {
                        this.$router.push('posts');
                    }
                }
            ).catch(
                (error) => {
                    if(error.response) {
                        this.errorNeedingAddressed(this.error.response, "Post not found");
                    } else if (error.request) {
                        this.errorNeedingAddressed(this.error.request, "Post not found");
                    }
                }
            )
        },
        getAllPostsForForum(forumId) {
            PostService.getPostsbyForumId(this.posts.forumId).then(
                (response) => {
                    if(response.status === 200) {
                        this.$router.push('posts');
                    }
                }
            ).catch(
                (error) => {
                    if(error.response) {
                        this.errorNeedingAddressed(this.error.response, "Post not found");
                    } else if (error.request) {
                        this.errorNeedingAddressed(this.error.request, "Post not found");
                    }
                }
            )
        },
        errorNeedingAddressed(error, toBeDone) {
            if(error.response) {
                if(error.response.status == 404) {
                    this.$router.push({name: 'home'})
                    //Need a Something went wrong view
                } else {
                    `This ${toBeDone} has not occurred.  Server could not be reached.`
                }
            } else if (error.request) {
                `This ${toBeDone} has not occurred.  Server could not be reached.`
            }
        },
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
    margin: 0 auto;
    margin-bottom: 1%;
    border: 8px solid rgb(250, 129, 240);
    /* font-size: 2.5rem; */
    color: white;
    margin-top: .5%;
    text-align: center;
    padding: 10px;
    /* background-image: ; */
}

.messageDetails {
    grid-area: message;
    font-size: 1.5rem;
    color: white;
    align-self: center;
    margin-right: 10px;
}

.timeStamp {
    grid-area: time;
    font-size: 1rem;
    color: white;
    align-self: flex-end;
    justify-self: flex-end;
    margin-bottom: 2%;
    margin-right: 2%
}

.postName{
    grid-area: post-name;
    font-size: 1.5rem;
    margin-top: 20px;
    margin-right: 12%;
}

.PostViewLink {
    text-decoration: none;
    color: white;
}

.vote-up{
color: gold;
font-size: 35px;
align-self: flex-start;
margin-right: 10px;
margin-left: 20px;
margin-top: 20px;
rotate: 140deg;
}

.vote-down{
color: red;
font-size: 35px;
align-self: flex-start;
margin-left: 10px;
margin-top: 20px;
rotate: -40deg;
}

.top-row{
    grid-area: vote-icons;

}


/* Test 2.8 */
</style>
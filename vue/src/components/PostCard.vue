<template>
  <div class="PostCard">
    <p></p>
        <h1 class="postName"> {{ post.title }}</h1>
        <p class="messageDetails">{{ post.message }}</p>
        <p class="timeStamp">{{ post.timeStamp }}</p>
        <!-- <router-link class="backtoforum" v-bind:to="{name: 'home'}">Return Home</router-link> -->
    <!-- Cycle through all comments for posts -->

  </div>
</template>

<script>

import PostService from '../services/PostService.js'

export default {
    components: {
        //Post Components
        //Comment components
    },
    props: {
        post: {
            // Cycle through all comments for posts
        },
        posts: [],
    },

    methods: {
        getPost() {
            PostService.getAllPosts(this.postId).then(
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
        getAllPosts() {
            PostService.getAllPosts(this.posts).then(
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
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    width: 650px;
    height: 250px;
    /* margin: 20px; */
    margin: 0 auto;
    margin-bottom: 10px;
    border: 5px solid rgb(250, 129, 240);
    /* font-size: 2.5rem; */
    color: white;
    margin-top: 1px;
    text-align: center;
}

.messageDetails {
    font-size: 1.5rem;
    color: white;
    align-self: center;
    margin-right: 10px;
}

.timeStamp {
    font-size: 1rem;
    color: white;
    align-self: flex-end;
    margin-right: 10px;
}

/* .backtofourm {
    text-decoration: none;
    color: rgb(250, 129, 240);
} */



</style>
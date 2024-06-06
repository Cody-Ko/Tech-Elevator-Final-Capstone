<template>

  <div class="PostCard">

    <router-link class="PostViewLink" v-bind:to="{ name: 'postview', params:{postId: post.post_id} }">
        <header>
        <h1 class="postName">{{ post.title }}</h1>
        
        </header>
    </router-link>
        <p class="messageDetails">{{ post.message }}</p>
    
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
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    border-radius: 25px;
    width: 50%;
    /* max-width: 750px; */
    min-width: 600px;
    /* height: 250px; */
    min-height: 500px;  
    /* margin: 20px; */
    margin: 0 auto;
    margin-bottom: 1%;
    border: 5px solid rgb(250, 129, 240);
    /* font-size: 2.5rem; */
    color: white;
    margin-top: .5%;
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
    margin-bottom: 2%;
    margin-right: 2%
}

.postName{
    font-size: 1.5rem
}

.PostViewLink {
    text-decoration: none;
    color: white;
}


/* Test 2.5 */
</style>
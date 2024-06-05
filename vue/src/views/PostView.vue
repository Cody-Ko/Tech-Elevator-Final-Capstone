<template>
  <div class="post">
    Welcome to Posts
  </div>
</template>

<script>
import PostService from '../services/PostService';

export default {
    data() {
        return {
            post: {},
            postId: this.$route.params.postId,
            forumId: this.$route.params.forumId,
        };
    },
    methods: {
        getPosts() {
            PostService.getAllPosts(this.forumId).then(
                (response) => {
                    this.post = response.data;
                }
            )
        },
        getPost() {
            PostService.getPost(this.postId).then(
                (response) => {
                    this.post.response.data;
                }
            )
        },
    }

}
</script>

<style>

.post {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    width: 650px;
    height: 250px;
    margin: 20px;
    margin: 0 auto;
    margin-bottom: 10px;
    border: 5px solid rgb(250, 129, 240);
    font-size: 2.5rem;
    color: white;
    margin-top: 1px;
    text-align: center;
}


</style>
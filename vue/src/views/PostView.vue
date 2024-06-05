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
        };
    },
    methods: {
        getPosts() {
            PostService.getAllPosts().then(
                (response) => {
                    this.post = response.data;
                }
            )
        },
        getPost() {
            PostService.getPost().then(
                (response) => {
                    this.post.response.data;
                }
            )
        },
    }

}
</script>

<style>

</style>
<template>
  <div class="post">
    PostView
  </div>
</template>

<script>
import PostService from '../services/PostService';

export default {
    data() {
        return {
            post: {},
            postId: this.$route.params.postId,
            // forumId: this.$route.params.forumId,
        };
    },
    methods: {
        // getPosts() {
        //     PostService.getAllPosts(this.forumId).then(
        //         (response) => {
        //             this.post = response.data;
        //         }
        //     )
        // },
        getPost() {
            PostService.getPost(this.post.post_id).then(
                (response) => {
                    this.post = response.data;
                }
            )
        },
    },
    created(){
            this.getPost();
        }

}
</script>

<style>

.post {
    margin-bottom: 2%;
    font-size: 2.5rem;
    color: white;
    margin-top: 2%;
    text-align: center;
}


</style>
<template>
    <div class="post-section">
        <PostCard class="trending-posts" v-bind:post="post" v-bind:key="post.post_id"/>
    </div>
    <div class="comments-section">
        <CommentCard class="comments" v-for="comment in comments" v-bind:comment="comment" v-bind:key="comment.comment_id"/>
    </div>
</template>

<script>
import PostService from '../services/PostService';
import PostCard from '../components/PostCard.vue';
import CommentCard from '../components/CommentCard.vue';
import CommentService from '../services/CommentService';

export default {
    data() {
        return {
            post: {},
            postId: parseInt(this.$route.params.postId),
            // forumId: this.$route.params.forumId,
            comments:[]
        };
    },
    components: {
        PostCard,
        CommentCard
        
    },
    methods: {
        getPost(postId) {
            PostService.getPost(this.postId).then(
                (response) => {
                    this.post = response.data;
                }
            )
        },
        getComments(){
            CommentService.getCommentsbyPostId(this.postId).then((response) =>{
                this.comments = response.data;
            })
        }
    },
    created(){
            this.getPost();
            this.getComments();
        }

}
</script>

<style>
.comments-section{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
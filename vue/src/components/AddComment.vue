<template>
  <h1>Comments</h1>
</template>

<script>
import CommentService from '../services/CommentService.js';

export default {
    data() {
        return {
            newComment: ''
        }
    },

    methods: {
        addComment() {
            CommentService.addComment(this.newComment).then(
                (response) => {
                    if(response.status === 201) {
                        window.alert('Comment added!')
                        this.newComment = '';
                        this.$router.push({name: 'post'})
                    }
                },
            )
        }
    },

}
</script>

<style>

</style>
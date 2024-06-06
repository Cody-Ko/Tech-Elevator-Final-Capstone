<template>
  <div class="CommentCard">

    <router-link class="CommentViewLink" v-bind:to="{name: 'commentview', params:{commentId: comment.post_id} }">
    
    </router-link>
    <p class="messageDetails"> {{ comment.message_details }}</p>
    <p class="timeStamp">{{ comment.time_stamps }}</p>
  </div>
</template>

<script>
import CommentService from '../services/CommentService.js'

export default {
    props: {
        comments: [],
        comment: {},
    },

    methods: {
        getComment(comment_id) {
            CommentService.getComment(this.comment_id).then(
                (response) => {
                    if(response.status === 200) {
                        this.$router.push('comments');
                    }
                }
            ).catch(
                (error) => {
                    if(error.response) {
                        this.errorNeedingAddressed(this.error.response, "Comment not found");
                    } else if (error.request) {
                        this.errorNeedingAddressed(this.error.request, "Comment not found");
                    }
                }
            )
        },
        getAllCommentsForPost(post_id) {
            CommentService.getCommentsbyPostId(this.comments.post_id).then(
                (response) => {
                    if(response.status === 200) {
                        this.$router.push('comments');
                    }
                }
            ).catch(
                (error) => {
                    if(error.response) {
                        this.errorNeedingAddressed(this.error.response, "Comment not found");
                    } else if (error.request) {
                        this.errorNeedingAddressed(this.error.request, "Comment not found");
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



}
</script>

<style>

.CommentCard {
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

.CommentViewLink {
    text-decoration: none;
    color: white;
}


</style>
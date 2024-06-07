import axios from 'axios';
const http = axios.create ({
    baseURL: "http://localhost:9000"
});

export default {

  getAllComments() {
    return axios.get('/comments')
  },

  getComment(commentId) {
    return axios.get(`/comment/${commentId}`)
  },

  getCommentsbyPostId(postId) {
    return axios.get(`/posts/${postId}/comments/`)
  },

  updateComment(commentId) {
    return axios.put(`/update-comment`, commentId);
  },

  addComment(comment) {
    return http.post('/add-comment', comment)
  },
  
  deleteComment(commentId) {
    return http.delete(`/comments/${commentId}`)
  }

}
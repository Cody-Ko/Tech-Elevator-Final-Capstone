import axios from 'axios';
const http = axios.create ({
    baseURL: "http://localhost:9000"
});

export default {

  getAllComments() {
    return axios.get('/comments')
  },

  getPost(commentId) {
    return axios.get(`/comment/${commentId}`)
  },

  updatePost(commentId) {
    return axios.put(`/update-comment`, commentId);
  },

  addPost(comment) {
    return http.post('add-comment', comment)
  }

}
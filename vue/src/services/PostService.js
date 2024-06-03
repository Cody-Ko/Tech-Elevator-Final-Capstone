import axios from 'axios';
const http = axios.create ({
    baseURL: "http://localhost:9000"
});

export default {

  getAllPosts() {
    return axios.get('/posts')
  },

  getPost(postId) {
    return axios.get(`/post/${postId}`)
  },

  updatePost(postID) {
    return axios.put(`/update-post`, postID);
  },

  addPost(post) {
    return http.post('add-post', post)
  },

  deletePost(postId) {
    return http.delete(`/posts/${postId}`)
  }

}
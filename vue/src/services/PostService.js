import axios from 'axios';
const http = axios.create ({
    baseURL: "http://localhost:9000"
});

export default {

  getPostsbyForumId(forumId) {
    return axios.get(`/forums/${forumId}/posts/`)
  },

  getPost(postId) {
    return axios.get(`/posts/${postId}`)
  },

  updatePost(postID) {
    return axios.put(`/update-post`, postID);
  },

  addPost(post) {
    return http.post('/add-post', post)
  },

  deletePost(postId) {
    return http.delete(`/posts/${postId}`)
  }

}
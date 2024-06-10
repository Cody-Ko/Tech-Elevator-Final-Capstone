import axios from 'axios';
const http = axios.create ({
    baseURL: "http://localhost:9000"
});

export default {

  getAllPosts(){
    return axios.get('/posts')
  },

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
  },

  getPostScore(postId){
    return http.get(`/posts/${postId}/getscore`)
  },

  upVotePost(postId){
    return http.put(`/posts/${postId}/upvote`)
  },

  downVotePost(postId){
    return http.put(`/posts/${postId}/downvote`)
  }

}
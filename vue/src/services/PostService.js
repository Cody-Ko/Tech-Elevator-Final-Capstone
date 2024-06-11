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
    return axios.post('/add-post', post)
  },

  deletePost(postId) {
    return axios.delete(`/posts/${postId}`)
  },

  getPostScore(postId){
    return axios.get(`/posts/${postId}/getscore`)
  },

  upVotePost(postId){
    return axios.put(`/posts/${postId}/upvote`)
  },

  downVotePost(postId){
    return axios.put(`/posts/${postId}/downvote`)
  },

  get10MostPopularPosts(){
    return axios.get('/posts/topvoted')
  }
}
import axios from 'axios';

const http = axios.create ({
    baseURL: "http://localhost:9000"
});

export default {

  getUsernameByForumId(forumId){
    return axios.get(`/forums/${forumId}/createdBy`)
  },

//   getUsernameByPostId(postId){
//     return axios.get(`/posts/${postId}/createdBy`)
//   }
}
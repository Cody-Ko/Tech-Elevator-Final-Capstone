import axios from 'axios';

const http = axios.create ({
    baseURL: "http://localhost:9000"
});

export default {

  getAllForums() {
    return axios.get('/forums')
  },

  getForum(forumId) {
    return axios.get(`/forums/${forumId}`)
  },

  updateForum(forumId) {
    return axios.put(`/update-forum`, forumId);
  },

  addForum(forum) {
    return http.post('add-forum', forum)
  },

  deleteForum(forumId) {
    return http.delete(`/forums/${forumId}`)
  }

  //Why is this happening?


}
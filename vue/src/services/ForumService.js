import axios from 'axios';

const http = axios.create ({
    baseURL: "http://localhost:9000"
});

export default {

  getAllForums() {
    return axios.get('/forums')
  },

  getForum(forumId) {
    return axios.get(`/forum/${forumId}`)
  },

  updateForum(forumId) {
    return axios.put(`/update-forum`, forumId);
  },

  addForum(forum) {
    return http.post('add-fourm', forum)
  },

  deleteForum(forumId) {
    return http.delete(`/forums/${forumId}`)
  }


}
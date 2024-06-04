<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
export default{

};

</script>

<style scoped>

body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: rgba(rgb(250, 228, 248),);
  text-decoration-color: rgba(rgb(250, 129, 240),);
};

.btn {
  display: inline-block;
  font-weight: 200;
  background-color: rgba(52,170,225,255)
};


</style>

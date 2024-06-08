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

<style>

#nav {
  font-family: Arial, Helvetica, sans-serif;
  background-color: rgb(250, 228, 248);
  text-decoration-color: rgb(250, 129, 240);
}

div {
  font-weight: 200;
  background-color: #34aae1;
  text-decoration-color: rgb(250, 129, 240);
}

#capstone-app {
  font-weight: 200;
  background-color: #34aae1;
  text-decoration-color: rgb(250, 129, 240);
}

.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}

div {
  font-family: Helvetica, Arial, sans-serif;
  background-color: rgba(rgb(250, 228, 248),);
  text-decoration-color: rgb(250, 129, 240);
}

button {
  display: inline-block;
  font-family: Helvetica, Arial, sans-serif;
  font-weight: 200;
  background-color: rgb(250, 129, 240);;
  color:white;
  border-radius: .25rem;
  border-color: rgb(250, 129, 240);
}

.login {
  display: inline-block;
  font-weight: 200;
  background-color: #34aae1;
  color: rgb(250, 129, 240);
}

label {
  color: white;
}

html, body, content {
  width: auto;
  height: 100vh;
  margin: 0;
  background-attachment: fixed;
  background-color: #34aae1;
}


</style>

<template>
  <div class="rootDiv">
    <form @submit.prevent="submit">
      <label>Name: </label>
      <input type="text" required v-model="$store.state.name" />

      <label>Email: </label>
      <input type="email" required v-model="$store.state.email" />
      <!--v-model binds the input to the variable within data()-->

      <label>Message: </label>
      <textarea required v-bind="$store.state.message"></textarea>

      <div class="submit">
        <button
          @click="$store.commit('submitFeedback')"
          :disabled="$store.state.message"
        >
          Submit feedback
        </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  mounted() {
    this.$store.commit("loadData");
  },
};
</script>

<style scoped>
form {
  max-width: 420px;
  margin: 30px auto;
  background: white;
  text-align: left;
  padding: 40px;
  border-radius: 10px;
}

label {
  color: #aaa;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.6em;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-weight: bold;
}

input,
select {
  display: block;
  padding: 10px 6px;
  width: 100%;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid #ddd;
  color: #555;
}

button {
  background: #0b6dff;
  border: 0;
  padding: 10px 20px;
  margin-top: 20px;
  color: white;
  border-radius: 20px;
  cursor: pointer;
  text-align: center;
}

textarea {
  resize: none;
  display: block;
  padding: 10px 6px;
  min-width: 100%;
  max-width: 100%;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid #ddd;
  color: #555;
  min-height: 150px;
}

.rootDiv {
  background-color: rgb(221, 221, 221);
  min-height: 100vh;
}

button:disabled,
button[disabled] {
  background-color: #cccccc;
  color: #666666;
}
</style>

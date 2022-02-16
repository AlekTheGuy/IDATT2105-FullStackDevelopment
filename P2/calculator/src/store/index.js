import { createStore } from "vuex";

export default createStore({
  state: {
    name: "",
    email: "",
    message: "",
    status: "",
  },
  mutations: {
    submitFeedback(state) {
      localStorage.setItem("name", state.name);
      localStorage.setItem("email", state.email);
      state.message = "";
    },
    loadData(state) {
      console.log("Loaded from local storage!");
      state.name = localStorage.getItem("name");
      state.email = localStorage.getItem("email");
    },
  },
  actions: {},
  modules: {},
});

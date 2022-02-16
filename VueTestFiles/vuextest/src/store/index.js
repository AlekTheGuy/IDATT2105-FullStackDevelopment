import { createStore } from "vuex";

export default createStore({
  state: {
    //Data som er tilgjengelig for alle vue komponenter.
    counter: 0,
  },
  mutations: {
    //Metoder som har tilgang til dataene i state. Denne kan ikke lese fra API.
    increaseCounter(state) {
      state.counter++;
    },
    decreaseCounter(state) {
      state.counter--;
    },
  },
  actions: {
    //Metoder som ikke kan endre dataene i state, de kan lese de. Denne kan lese fra API.
  },
  getters: {
    //Getters kan gi ut data fra state. Komponenter kan lese fra state uten getters så den er mer brukt til å endre data før det sendes ut.
  },
  modules: {
    //Kan separere ut en store til flere moduler.
  },
});

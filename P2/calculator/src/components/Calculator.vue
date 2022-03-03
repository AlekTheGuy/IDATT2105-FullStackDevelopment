<template>
  <div class="calculator">
    <h1 class="inputfield">{{ currentCalculation }}</h1>
    <div class="history">
      <h3>{{ history[0] }}</h3>
      <h3>{{ history[1] }}</h3>
      <h3>{{ history[2] }}</h3>
    </div>

    <div class="buttons">
      <button
        class="button"
        v-for="n in buttonArray"
        :key="n"
        @click="processInput(n)"
      >
        {{ n }}
      </button>
    </div>
    <div class="history"></div>
  </div>
</template>

<script>
import calculator from "@/services/calculator";
export default {
  data: function () {
    return {
      buttonArray: [
        "7",
        "8",
        "9",
        "/",
        "4",
        "5",
        "6",
        "*",
        "1",
        "2",
        "3",
        "-",
        "0",
        ".",
        "=",
        "+",
      ],
      currentCalculation: "ready",
      toClear: true,
      history: ["", "", ""],
    };
  },
  methods: {
    async processInput(n) {
      if (this.toClear === true) {
        this.currentCalculation = "";
        this.toClear = false;
      }
      if (n === "=") {
        let numbers = this.splitNumbers(this.currentCalculation);
        await calculator.postCalculation(numbers[0], numbers[1], numbers[2]);
        //For some reason getPreviousAnswer returns the old answer the first time i use it.
        //By using it to give the previous calculation to history it is a feature, not a bug.
        this.history[2] = this.history[1];
        this.history[1] = this.history[0];
        this.history[0] = await calculator.getPreviousAnswer();
        this.currentCalculation = await calculator.getPreviousAnswer();
        this.toClear = true;
      } else {
        this.currentCalculation += n;
      }
    },
    splitNumbers(inputString) {
      let test = inputString.split("+");
      test.push("+");
      if (inputString.includes("+")) {
        let calculation = inputString.split("+");
        calculation.push("+");
        return calculation;
      } else if (inputString.includes("-")) {
        let calculation = inputString.split("-");
        calculation.push("-");
        return calculation;
      } else if (inputString.includes("*")) {
        let calculation = inputString.split("*");
        calculation.push("*");
        return calculation;
      } else if (inputString.includes("/")) {
        let calculation = inputString.split("/");
        calculation.push("/");
        return calculation;
      }
    },
  },
};
</script>

<style scoped>
.calculator {
  display: grid;
  grid-template-areas:
    "inputfield"
    "history"
    "buttons";
  width: 270px;
  max-width: 270px;
  height: auto;
  padding-top: 10px;
  padding-bottom: 10px;
  background-color: rgb(112, 112, 112);
}

.buttons {
  display: grid;
  grid-template-areas:
    "button button button button"
    "button button button button"
    "button button button button"
    "button button button button";
  grid-gap: 5px;
  margin: auto;
  margin-bottom: 0;
  padding-top: 10px;
}

.button {
  height: 60px;
  max-height: 60px;
  max-width: 60px;
  width: 60px;
  font-size: 20px;
  font-weight: bold;
}

.inputfield {
  background-color: rgb(192, 190, 190);
  max-width: 250px;
  width: 250px;
  margin: auto;
}

.history {
  background-color: rgb(192, 190, 190);
  max-width: 250px;
  width: 250px;
  margin: auto;
}

</style>
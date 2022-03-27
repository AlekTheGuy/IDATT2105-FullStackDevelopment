import axios from "axios";

export default {
  // postCalculation(num1, num2, operator) {
  //   axios.post("http://localhost:8081/calculate", {
  //     num1: num1,
  //     num2: num2,
  //     operator: operator,
  //   });
  // },
  getHistory() {
    return axios.get("http://localhost:8081/equations").then((result) => {
      return result.data;
    });
  },
  addCalculation(num1, num2, operator, answer) {
    axios.post("http://localhost:8081/calculate", {
      num1: num1,
      num2: num2,
      operator: operator,
      answer: answer
    })
  }
};

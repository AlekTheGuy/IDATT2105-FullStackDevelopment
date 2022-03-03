import axios from "axios";

export default {
  postCalculation(num1, num2, operator) {
    axios.post("http://localhost:8081/calculate", {
      num1: num1,
      num2: num2,
      operator: operator,
    });
  },
  getPreviousAnswer() {
    return axios.get("http://localhost:8081/calculate").then((result) => {
      return result.data;
    });
  },
  getHistory() {
    return axios.get("http://localhost:8081/calculate/all").then((result) => {
      return result.data;
    });
  },
};

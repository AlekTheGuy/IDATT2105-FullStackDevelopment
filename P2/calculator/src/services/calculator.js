import axios from "axios";

export default {
  getHistory(amount) {
    return axios
      .get("http://localhost:8081/api/equations?amount=" + amount)
      .then((result) => {
        return result.data;
      });
  },
  postCalculation(num1, num2, operator) {
    axios.post("http://localhost:8081/api/equations", {
      num1: num1,
      num2: num2,
      operator: operator,
    });
  },
};

import axios from "axios";

const url = "http://localhost:4000/transaction";

export const GetTransactionHistory = () => {
  return axios.get(url).then((response) => {
    console.log(response.data);
  });
};

import axios from "axios";

const API_BASE_URL_QUERY = "http://localhost:8082/customers/query";
const API_BASE_URL_COMMANDS = "http://localhost:8080/customers/commands";

class CustomersService {
    getCustomers() {
        return axios.get(API_BASE_URL_QUERY + "/all");
    }

    addCustomer(data) {
        return axios.post(API_BASE_URL_COMMANDS + "/create", data);
    }
    getCustomerById(id) {
        return axios.get(API_BASE_URL_QUERY + "/" + id);
    }
}
export default new CustomersService();

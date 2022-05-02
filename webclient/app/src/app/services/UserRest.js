import CrudRest from "./CrudRest";
import axios from "axios";

class UserRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/user");
    }

    findAllWithoutAddress() {
        return axios.get(this.baseUrl + "/find-without-address/");
    }
}
export default UserRest;

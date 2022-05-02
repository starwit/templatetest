import CrudRest from "./CrudRest";
import axios from "axios";

class AddressRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/address");
    }

    findAllWithoutOrganisation() {
        return axios.get(this.baseUrl + "/find-without-organisation/");
    }

    findAllWithoutUser() {
        return axios.get(this.baseUrl + "/find-without-user/");
    }
}
export default AddressRest;

import CrudRest from "./CrudRest";
import axios from "axios";

class OrganisationRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/organisation");
    }

    findAllWithoutAddress() {
        return axios.put(this.baseUrl + "/find-without-address/");
    }
}
export default OrganisationRest;

import CrudRest from "./CrudRest";

class AddressRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/address");
    }
}

export default AddressRest;

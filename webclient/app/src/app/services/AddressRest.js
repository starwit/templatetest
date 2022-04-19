import CrudRest from "./CrudRest";

class AddressRest extends CrudRest {

    constructor() {
        super(window.location.pathname + "api/addresss");
    }

}

export default AddressRest;

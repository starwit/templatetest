import CrudRest from "./CrudRest";

class OrganisationRest extends CrudRest {

    constructor() {
        super(window.location.pathname + "api/organisation");
    }

}

export default OrganisationRest;

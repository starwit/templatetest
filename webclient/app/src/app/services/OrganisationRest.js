import CrudRest from "./CrudRest";

class OrganisationRest extends CrudRest {

    constructor() {
        super(window.location.pathname + "api/organisations");
    }

}

export default OrganisationRest;

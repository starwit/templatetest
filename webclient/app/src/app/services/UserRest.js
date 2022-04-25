import CrudRest from "./CrudRest";

class UserRest extends CrudRest {

    constructor() {
        super(window.location.pathname + "api/user");
    }

}

export default UserRest;

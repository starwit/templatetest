import CrudRest from "./CrudRest";

class UserRest extends CrudRest {

    constructor() {
        super(window.location.pathname + "api/users");
    }

}

export default UserRest;

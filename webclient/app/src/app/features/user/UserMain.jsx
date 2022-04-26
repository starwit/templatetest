import React from "react";
import {Route} from "react-router-dom";
import UserOverview from "./UserOverview";
import UserDetail from "./UserDetail";

function UserMain() {
    return (
        <>
            <React.Fragment>
                <Route exact path="/user" component={UserOverview}/>
                <Route exact path="/user/create" component={UserDetail}/>
                <Route exact path="/user/update/:id" component={UserDetail}/>
            </React.Fragment>
        </>
    );
}

export default UserMain;

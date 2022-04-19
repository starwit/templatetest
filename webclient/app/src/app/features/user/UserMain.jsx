import React from "react";
import {Route} from "react-router-dom";
import UserOverview from "./UserOverview";
import UserDetail from "./UserDetail";

function UserMain() {
    return (
        <>
          <React.Fragment>
            <Route exact path="/users" component={UserOverview}/>
            <Route exact path="/users/create" component={UserDetail}/>
            <Route exact path="/users/update/:id" component={UserDetail}/>
          </React.Fragment>
        </>
    );
}

export default UserMain;

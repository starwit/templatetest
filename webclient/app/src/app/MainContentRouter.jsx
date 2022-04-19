import React from "react";
import {Route, Switch} from "react-router-dom";
import AddressOverview from "./features/address/AddressOverview";
import AddressDetail from "./features/address/AddressDetail";
import UserOverview from "./features/user/UserOverview";
import UserDetail from "./features/user/UserDetail";
import OrganisationOverview from "./features/organisation/OrganisationOverview";
import OrganisationDetail from "./features/organisation/OrganisationDetail";
import Home from "./features/home/Home";

function MainContentRouter() {
    return (
        <>
            <Switch>
                <Route path={"/address"} component={AddressMain}/>
                <Route path={"/user"} component={UserMain}/>
                <Route path={"/organisation"} component={OrganisationMain}/>
            </Switch>
            <Route exact path={"/"} component={Home}/>
            <Route path="/logout" component={() => {
                window.location.href = window.location.pathname + "api/user/logout";
                return null;
            }}/>
        </>
    );
}

export default MainContentRouter;

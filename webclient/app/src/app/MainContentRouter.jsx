import React from "react";
import {Route, Switch} from "react-router-dom";
import UserMain from "./features/user/UserMain";
import AddressMain from "./features/address/AddressMain";
import OrganisationMain from "./features/organisation/OrganisationMain";
import Home from "./features/home/Home";

function MainContentRouter() {
    return (
        <>
            <Switch>
                <Route path={"/user"} component={UserMain}/>
                <Route path={"/address"} component={AddressMain}/>
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

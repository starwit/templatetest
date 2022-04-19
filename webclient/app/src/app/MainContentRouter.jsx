import React from "react";
import {Route} from "react-router-dom";
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
            <Route exact path={"/addresss/:id"} component={AddressDetail}/>
            <Route exact path={"/addresss/"} component={AddressOverview}/>
            <Route exact path={"/users/:id"} component={UserDetail}/>
            <Route exact path={"/users/"} component={UserOverview}/>
            <Route exact path={"/organisations/:id"} component={OrganisationDetail}/>
            <Route exact path={"/organisations/"} component={OrganisationOverview}/>
            <Route exact path={"/"} component={Home}/>
            <Route path="/logout" component={() => {
                window.location.href = window.location.pathname + "api/user/logout";
                return null;
            }}/>
        </>
    );
}

export default MainContentRouter;

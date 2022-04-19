import React from "react";
import {Route} from "react-router-dom";
import OrganisationOverview from "./OrganisationOverview";
import OrganisationDetail from "./OrganisationDetail";

function OrganisationMain() {
    return (
        <>
            <React.Fragment>
                <Route exact path="/organisation" component={OrganisationOverview}/>
                <Route exact path="/organisation/create" component={OrganisationDetail}/>
                <Route exact path="/organisation/update/:id" component={OrganisationDetail}/>
            </React.Fragment>
        </>
    );
}

export default OrganisationMain;

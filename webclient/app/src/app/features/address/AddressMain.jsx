import React from "react";
import {Route} from "react-router-dom";
import AddressOverview from "./AddressOverview";
import AddressDetail from "./AddressDetail";

function AddressMain() {
    return (
        <>
            <React.Fragment>
                <Route exact path="/address" component={AddressOverview}/>
                <Route exact path="/address/create" component={AddressDetail}/>
                <Route exact path="/address/update/:id" component={AddressDetail}/>
            </React.Fragment>
        </>
    );
}

export default AddressMain;

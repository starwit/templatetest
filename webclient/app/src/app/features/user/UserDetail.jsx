import React, {useMemo, useEffect} from "react";
import {useParams} from "react-router";
import {useImmer} from "use-immer";
import UserRest from "../../services/UserRest";
import OrganisationRest from "../../services/OrganisationRest";
import AddressRest from "../../services/AddressRest";
import {
    entityDefault,
    entityFields
} from "../../modifiers/UserModifier";
import EntityDetail from "../../commons/form/EntityDetail";
import {addSelectLists} from "../../modifiers/DefaultModifier";

function UserDetail() {
    const [entity, setEntity] = useImmer(entityDefault);
    const [fields, setFields] = useImmer(entityFields);
    const entityRest = useMemo(() => new UserRest(), []);
    const organisationRest = useMemo(() => new OrganisationRest(), []);
    const addressRest = useMemo(() => new AddressRest(), []);
    const {id} = useParams();

    useEffect(() => {
        reloadSelectLists();
    }, [id]);

    function reloadSelectLists() {
        const selectLists = [];
        const functions = [
            organisationRest.findAll(),
            addressRest.findAllWithoutUser()
        ];
        Promise.all(functions).then(values => {
            selectLists.push({name: "organisation", data: values[0].data});
            selectLists.push({name: "address", data: values[1].data});
            if (id) {
                entityRest.findById(id).then(response => {
                    setEntity(response.data);
                    addSelectLists(response.data, fields, setFields, selectLists);
                });
            } else {
                addSelectLists(entity, fields, setFields, selectLists);
            }
        });
    }

    return (
        <>
            <EntityDetail
                id={id}
                entity={entity}
                setEntity={setEntity}
                fields={fields}
                setFields={setFields}
                entityRest={entityRest}
                prefix="user"
            />
        </>

    );
}

export default UserDetail;

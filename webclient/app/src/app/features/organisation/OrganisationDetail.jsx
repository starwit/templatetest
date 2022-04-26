import {Container, Typography} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useImmer} from "use-immer";
import {useTranslation} from "react-i18next";
import UpdateForm from "./../../commons/form/UpdateForm";
import {useParams, useHistory} from "react-router";
import OrganisationRest from "../../services/OrganisationRest";
import {handleChange} from "../../modifiers/DefaultModifier";
import {organisationFields, organisationDefault} from "../../modifiers/OrganisationModifier";

function OrganisationDetail() {
    const {t} = useTranslation();
    const history = useHistory();
    const organisationRest = useMemo(() => new OrganisationRest(), []);

    const [organisation, setOrganisation] = useImmer(organisationDefault);
    const [titleKey, setTitleKey] = useState(null);
    const {id} = useParams();

    useEffect(() => {
        onIdChange();
    }, [id]);

    function onIdChange() {
        if (!id) {
            setTitleKey("organisation.create.title");
        } else {
            setTitleKey("organisation.update.title");
            organisationRest.findById(id).then(response => {
                setOrganisation(response.data);
            });
        }
    }

    function handleSubmit(event) {
    // turn off page reload
        event.preventDefault();

        if (!id) {
            organisationRest.create(organisation).then(goBack);
        } else {
            organisationRest.update(organisation).then(goBack);
        }
    }

    const goBack = () => {
        history.push("/organisation");
    };

    return (
        <Container>
            <Typography variant="h1" color="primary">{t(titleKey)}</Typography>
            <UpdateForm
                entity={organisation}
                fields={organisationFields}
                prefix='organisation'
                handleSubmit={handleSubmit}
                handleChange={e => handleChange(e, setOrganisation)}
            />
        </Container>
    );
}

export default OrganisationDetail;

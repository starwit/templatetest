import {Container, Typography, FormControl, InputLabel, Select, MenuItem, Button} from "@mui/material";
import React, {useEffect, useMemo, useState} from "react";
import {useTranslation} from "react-i18next";
import {useHistory, useParams} from "react-router";
import {useImmer} from "use-immer";
import {handleChange, handleSelect, isValid} from "../../modifiers/DefaultModifier";
import {organisationDefault, organisationFields} from "../../modifiers/OrganisationModifier";
import OrganisationRest from "../../services/OrganisationRest";
import AddressRest from "../../services/AddressRest";
import UpdateField from "../../commons/form/UpdateField";

function SimpleOrganisationDetail() {
    const {t} = useTranslation();
    const history = useHistory();
    const organisationRest = useMemo(() => new OrganisationRest(), []);
    const addressRest = useMemo(() => new AddressRest(), []);

    const [organisation, setOrganisation] = useImmer(organisationDefault);
    const [addressAll, setAddressAll] = useState([]);
    const [titleKey, setTitleKey] = useState(null);
    const {id} = useParams();
    const [hasFormError, setHasFormError] = React.useState(false);

    useEffect(() => {
        onIdChange();
    }, [id]);

    useEffect(() => {
        onEntityChange();
    }, [organisation]);

    function onEntityChange() {
        setHasFormError(!isValid(organisationFields, organisation));
    }

    function onIdChange() {
        if (!id) {
            setTitleKey("organisation.create.title");
        } else {
            setTitleKey("organisation.update.title");
            organisationRest.findById(id).then(response => {
                setOrganisation(response.data);
            });
            addressRest.findAll().then(response => {
                setAddressAll(response.data);
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
            <form autoComplete="off" onSubmit={handleSubmit}>
                <UpdateField
                    entity={organisation}
                    field={organisationFields.find(field => field.name === "name")}
                    prefix='organisation'
                    handleChange={e => handleChange(e, setOrganisation)}
                    fullWidth
                />
                <FormControl fullWidth>
                    <InputLabel id="select-label-address">{t("organisation.address")}</InputLabel>
                    <Select
                        labelId="select-address"
                        id="select-id-address"
                        name="address"
                        value={organisation.address ? organisation.address.id : -1}
                        label={t("organisation.address")}
                        onChange={e => handleSelect(e, setOrganisation)}
                    >
                        <MenuItem value={-1} key={-1}>undefined</MenuItem>
                        {addressAll?.map(address =>
                            <MenuItem value={address.id} key={address.id}>
                                {address.street + " " + address.streetNr + " " + address.city}
                            </MenuItem>
                        )}
                    </Select>
                </FormControl>
                <Button type="submit" variant="contained" color="primary" disabled={hasFormError} >
                    {t("button.submit")}
                </Button>
            </form>
        </Container>
    );
}
export default SimpleOrganisationDetail;

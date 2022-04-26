import {Container, Typography} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useImmer} from "use-immer";
import {useTranslation} from "react-i18next";
import UpdateForm from "./../../commons/form/UpdateForm";
import {useParams, useHistory} from "react-router";
import AddressRest from "../../services/AddressRest";
import {handleChange} from "../../modifiers/DefaultModifier";
import {addressFields, addressDefault} from "../../modifiers/AddressModifier";

function AddressDetail() {
    const {t} = useTranslation();
    const history = useHistory();
    const addressRest = useMemo(() => new AddressRest(), []);

    const [address, setAddress] = useImmer(addressDefault);
    const [titleKey, setTitleKey] = useState(null);
    const {id} = useParams();

    useEffect(() => {
        onIdChange();
    }, [id]);

    function onIdChange() {
        if (!id) {
            setTitleKey("address.create.title");
        } else {
            setTitleKey("address.update.title");
            addressRest.findById(id).then(response => {
                setAddress(response.data);
            });
        }
    }

    function handleSubmit(event) {
    // turn off page reload
        event.preventDefault();

        if (!id) {
            addressRest.create(address).then(goBack);
        } else {
            addressRest.update(address).then(goBack);
        }
    }

    const goBack = () => {
        history.push("/address");
    };

    return (
        <Container>
            <Typography variant="h1" color="primary">{t(titleKey)}</Typography>
            <UpdateForm
                entity={address}
                fields={addressFields}
                prefix='address'
                handleSubmit={handleSubmit}
                handleChange={e => handleChange(e, setAddress)}
            />
        </Container>
    );
}

export default AddressDetail;

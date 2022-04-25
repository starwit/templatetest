import {Container, Typography, Button} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import OverviewTable from "../../commons/table/OverviewTable";
import AddressRest from "../../services/AddressRest";
import {useHistory} from "react-router";
import {addressFields} from "../../modifiers/AddressModifier";

function UserOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const addressRest = useMemo(() => new AddressRest(), []);
    const history = useHistory();
    const [addressAll, setAddressAll] = useState();

    useEffect(() => {
        reload();
    }, []);

    function reload() {
        addressRest.findAll().then(response => {
            setAddressAll(response.data);
        });
    }

    function goToCreate() {
        history.push("/address/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/address/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            addressRest.delete(selected.id).then(reload);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("address.title")}</Typography>
            <Button onClick={goToCreate} variant="contained" color="primary">{t("button.create")}</Button>
            <Button onClick={goToUpdate} variant="contained" color="primary" disabled={!selected?.id} >
                {t("button.update")}
            </Button>
            <Button onClick={handleDelete} variant="contained" color="primary" disabled={!selected?.id}>
                {t("button.delete")}
            </Button>
            <OverviewTable
                entities={addressAll}
                prefix={"address"}
                selected={selected}
                onSelect={setSelected}
                fields={addressFields}/>
        </Container>
    );
}

export default UserOverview;

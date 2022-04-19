import {Container, Typography, Button} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import OverviewTable from "../../commons/table/OverviewTable";
import UserRest from "../../services/UserRest";
import {useHistory} from "react-router";

function UserOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const userRest = useMemo(() => new UserRest(), []);
    const history = useHistory();
    const [users, setUsers] = useState();

    function reload() {
        userRest.findAll().then(response => {
            setUsers(response.data);
        });
    }

    useEffect(() => {
        reload();
    }, []);

    const userAll = [
        {
            "firstName": "Anett",
            "lastName": "Huebner"
        },
        {
            "firstName": "Anett",
            "lastName": "Huebner"
        },
        {
            "firstName": "Anett",
            "lastName": "Huebner"
        }
    ];

    const columns = [
        {title: t("user.firstName"), field: "firstName"},
        {title: t("user.lastName"), field: "lastName"}
    ];

    function goToCreate() {
        history.push("/users/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/users/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            addressRest.delete(selected.id).then(fetchAll);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("user.title")}</Typography>
            <Button onClick={goToCreate} variant="contained" color="primary">{t("button.create")}</Button>
            <Button onClick={goToUpdate} variant="contained" color="primary">{t("button.update")}</Button>
            <Button onClick={handleDelete} variant="contained" color="primary">{t("button.delete")}</Button>
            <OverviewTable
                entities={userAll}
                selected={selected}
                onRowClick={setSelected}
                columns={columns}/>
        </Container>
    );
}

export default UserOverview;

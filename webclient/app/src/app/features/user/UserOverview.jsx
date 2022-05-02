import {Container, Typography, Button} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import OverviewTable from "../../commons/table/OverviewTable";
import UserRest from "../../services/UserRest";
import {useHistory} from "react-router";
import {userOverviewFields} from "../../modifiers/UserModifier";

function UserOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const userRest = useMemo(() => new UserRest(), []);
    const history = useHistory();
    const [userAll, setUserAll] = useState();

    useEffect(() => {
        reload();
    }, []);

    function reload() {
        userRest.findAll().then(response => {
            setUserAll(response.data);
        });
    }

    function goToCreate() {
        history.push("/user/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/user/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            userRest.delete(selected.id).then(reload);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("user.title")}</Typography>
            <Button onClick={goToCreate} variant="contained" color="primary">{t("button.create")}</Button>
            <Button onClick={goToUpdate} variant="contained" color="primary" disabled={!selected?.id} >
                {t("button.update")}
            </Button>
            <Button onClick={handleDelete} variant="contained" color="primary" disabled={!selected?.id}>
                {t("button.delete")}
            </Button>
            <OverviewTable
                entities={userAll}
                prefix={"user"}
                selected={selected}
                onSelect={setSelected}
                fields={userOverviewFields}/>
        </Container>
    );
}

export default UserOverview;

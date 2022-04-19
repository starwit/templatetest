import {Container, Typography} from "@mui/material";
import React from "react";
import {useTranslation} from "react-i18next";

function UserOverview() {
    const {t} = useTranslation();
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
    ]

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>
                {t("user.title")}
            </Typography>
            <AllTable
                entities={userAll}
                selected={selected}
                onRowClick={() => {}}
                columns={columns}/>
        </Container>
    );
}

export default UserOverview;

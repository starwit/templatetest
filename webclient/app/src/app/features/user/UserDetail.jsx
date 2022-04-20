import {Container, Typography} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useImmer} from "use-immer";
import {useTranslation} from "react-i18next";
import UpdateForm from "./../../commons/form/UpdateForm";
import {useParams, useHistory} from "react-router";
import UserRest from "../../services/UserRest";

function UserDetail() {
    const {t} = useTranslation();
    const history = useHistory();
    const userRest = useMemo(() => new UserRest(), []);
    const attributes = [
        {name: "firstName", type: "string"},
        {name: "lastName", type: "string"}
    ];

    const [user, setUser] = useImmer({firstName: "", lastName: "", id: undefined});
    const [titleKey, setTitleKey] = useState(null);
    const {id} = useParams();

    useEffect(() => {
        onIdChange();
    }, [id]);

    function onIdChange() {
        if (!id) {
            setTitleKey("user.create.title");
        } else {
            setTitleKey("user.update.title");
            userRest.findById(id).then(response => {
                setUser(response.data);
            });
        }
    }

    const handleChange = event => {
        const target = event.target;
        const value = target.type === "checkbox" ? target.checked : target.value;
        const name = target.name;
        setUser(draft => {draft[name] = value;});
    };

    const handleSubmit = event => {
        // turn off page reload
        event.preventDefault();
        if (!id) {
            userRest.create(user).then(goBack);
        } else {
            userRest.update(user).then(goBack);
        }
    };

    const goBack = () => {
        history.push("/user");
    };

    return (
        <Container>
            <Typography variant="h1" color="primary">{t(titleKey)}</Typography>
            <UpdateForm
                entity={user}
                attributes={attributes}
                prefix='user'
                handleSubmit={handleSubmit}
                handleChange={handleChange}
            />
        </Container>
    );
}

export default UserDetail;

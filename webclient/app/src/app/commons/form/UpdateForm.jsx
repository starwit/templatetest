import React from "react";
import {TextField, Button} from "@mui/material";
import {useTranslation} from "react-i18next";
import UpdateFormStyles from "./UpdateFormStyles";

function UpdateForm(props) {
    const {entity, attributes, prefix, handleSubmit, handleChange} = props;
    const {t} = useTranslation();
    const updateFormStyles = UpdateFormStyles();

    return (
        <form
            className={updateFormStyles.container}
            autoComplete="off"
            onSubmit={handleSubmit}>

            {attributes.map(attribute =>
                <React.Fragment key={attribute.name}>
                    <TextField
                        inputProps={attribute.inputProps}
                        key={attribute.name}
                        id={"input-" + attribute.name}
                        label={t(prefix + "." + attribute.name)}
                        name={attribute.name}
                        type={attribute.type}
                        value={entity[attribute.name] !== null ? entity[attribute.name] : ""}
                        className={updateFormStyles.textField}
                        onChange={handleChange}
                        margin="normal"
                    />
                    <br/>
                </React.Fragment>
            )}
            <br/>
            <Button type="submit" variant="contained" color="primary">
                {t("button.submit")}
            </Button>
        </form>
    );
}

export default UpdateForm;

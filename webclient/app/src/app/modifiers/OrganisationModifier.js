const entityDefault = {
    name: "",
    id: undefined
};

const entityFields = [
    {name: "name", type: "string", regex: null},
    {
        name: "address",
        type: "OneToOne",
        regex: null,
        selectList: [],
        display: [
            "city",
            "street",
            "streetNr",
            "cityCode"
        ],
        selectedIds: []
    },
];

const organisationOverviewFields = [
    {name: "name", type: "string", regex: null}
];

export {
    entityDefault,
    entityFields,
    organisationOverviewFields
};

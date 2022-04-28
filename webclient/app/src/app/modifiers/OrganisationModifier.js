const entityDefault = {
    name: "",
    id: undefined,
    address: {id: 0}
};

const entityFields = [
    {name: "name", type: "string", regex: null},
    {
        name: "address",
        type: "OneToOne",
        regex: null,
        selectList: [],
        display: ["street"]
    },
    {
        name: "user",
        type: "ManyToMany",
        regex: null,
        selectList: [],
        display: ["name"]
    }
];

const organisationOverviewFields = [
    {name: "name", type: "string", regex: null}
];

export {
    entityDefault,
    entityFields,
    organisationOverviewFields
};

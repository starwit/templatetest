const entityDefault = {
    firstName: "",
    lastName: "",
    id: undefined
};

const entityFields = [
    {name: "firstName", type: "string", regex: null},
    {name: "lastName", type: "string", regex: null},
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
    {
        name: "organisation",
        type: "ManyToMany",
        regex: null,
        selectList: [],
        display: [
            "name"
        ],
        selectedIds: []
    }
];

const userOverviewFields = [
    {name: "firstName", type: "string", regex: null},
    {name: "lastName", type: "string", regex: null}
];

export {
    entityDefault,
    entityFields,
    userOverviewFields
};

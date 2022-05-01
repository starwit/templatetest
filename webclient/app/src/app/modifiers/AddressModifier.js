const entityDefault = {
    city: "",
    street: "",
    streetNr: "",
    cityCode: "",
    id: undefined
};

const entityFields = [
    {name: "city", type: "string", regex: null},
    {name: "street", type: "string", regex: null},
    {name: "streetNr", type: "string", regex: null},
    {name: "cityCode", type: "string", regex: null},
];

const addressOverviewFields = [
    {name: "city", type: "string", regex: null},
    {name: "street", type: "string", regex: null},
    {name: "streetNr", type: "string", regex: null},
    {name: "cityCode", type: "string", regex: null}
];

export {
    entityDefault,
    entityFields,
    addressOverviewFields
};

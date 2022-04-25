const addressDefault = {
    city: "",
    street: "",
    streetNr: "",
    cityCode: "",
    id: undefined
};

const addressFields = [
    {name: "city", type: "string", regex: null},
    {name: "street", type: "string", regex: null},
    {name: "streetNr", type: "string", regex: null},
    {name: "cityCode", type: "string", regex: null},
];

export {addressDefault, addressFields};

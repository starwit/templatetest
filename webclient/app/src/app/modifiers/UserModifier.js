const userDefault = {
    firstName: "",
    lastName: "",
    id: undefined
};

const userFields = [
    {name: "firstName", type: "string", regex: /^[A-Z][a-zA-Z0-9]{1,100}$/},
    {name: "lastName", type: "string", regex: /^[A-Z][a-zA-Z0-9]{1,100}$/}
];

export {userDefault, userFields};

import {produce} from "immer";

function handleChange(event, setData) {
    const target = event.target;
    const value = target.type === "checkbox" ? target.checked : target.value;
    const name = target.name;
    setData(draft => {draft[name] = value;});
}

function handleSelect(event, setData) {
    const target = event.target;
    const name = target.name;
    const value = target.value;
    setData(draft => {draft[name] = {id: value};});
}

function handleMultiSelect(event, setData) {
    const target = event.target;
    const name = target.name;
    const value = target.value;
    setData(draft => {draft[name] = {id: value};});
}

function isValid(fields, data) {
    if (!fields) {
        return true;
    }
    for (const element of fields) {
        if (!!element.regex && !element.regex.test(data[element.name])) {
            return false;
        }
    }
    return true;
}

function isSelect(fieldType) {
    return fieldType === "OneToOne" || fieldType == "ManyToOne";
}

function isMultiSelect(fieldType) {
    return fieldType === "ManyToMany";
}

function isInput(fieldType) {
    return fieldType === "string" || fieldType == "int";
}

function addSelectLists(fields, setFields, selects) {
    const toSave = produce(fields, draft => {
        draft?.map(field => {
            if (isSelect(field.type)) {
                field.selectList = selects.find(list => list.name === field.name).data;
            }
        });
    });
    setFields(toSave);
}

function prepareForSave(entity, fields) {
    return produce(entity, draft => {
        fields?.map(field => {
            if (isSelect(field.type)) {
                if (draft[field.name]?.id == -1) {
                    draft[field.name] = null;
                }
            }
        });
    });
}

export {handleChange, handleSelect, handleMultiSelect, prepareForSave, isValid, addSelectLists,
    isInput,
    isSelect,
    isMultiSelect};

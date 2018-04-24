// CRUD_Instance.js

function performCRUDInstance(){
    console.log(">>performCRUDInstance was called...");
    // create entity Defect
    var createdEntity = postNewDefect("name of new defect");
    printEntity("created entity", createdEntity);

    // read created entity
    var entity = getEntityById(createdEntity.type, createdEntity.id);
    printEntity("entity", entity);

    // update
    var updatedEntity = updateEntityNameById(entity.type, entity.id, "new name of " + entity.type + " "+ entity.id);
    printEntity("updated entity", updatedEntity);

    // delete
    var deletedEntity = deleteEntityById(entity.type, entity.id);
    printEntity("deleted entity", deletedEntity);
    console.log(">>performCRUDInstance end.");
}

//通过id获取实体
function getEntityById(type, id)
{
    var entity;
    console.log("getEntityById was called...");
    var req = new XMLHttpRequest();
    req.open("GET", alm_project_url + "/" + type + "s/" + id, false);
    req.setRequestHeader("Accept", "application/json");

    req.onreadystatechange = function(){
        // if state is "complete"
        if (req.readyState == 4) {
            // & response status is "OK"
            if (req.status == 200){
                entity = JSON.parse(req.responseText);
            } else {
                console.log("Failed. Response status:" + req.statusText);
            }
        }
    }

    req.send();
    console.log("getEntityById end.");
    return entity;
}

//添加新的case
function postNewDefect(name)
{
    var createdEntity;
    console.log("postNewDefect was called...");
    var req = new XMLHttpRequest();
    req.open("POST", alm_project_url + "/defects/", false);
    req.setRequestHeader("Accept", "application/json");
    req.setRequestHeader("Content-Type", "application/json");

    req.onreadystatechange = function(){
        // if state is "complete"
        if (req.readyState == 4) {
            // & response status is "OK"
            if (req.status == 201){
                createdEntity = JSON.parse(req.responseText);
            } else {
                console.log("Failed. Response status:" + req.statusText);
            }
        }
    }
    req.send(getNewDefect_json(name));
    console.log("postNewDefect end.");
    return createdEntity;
}

//根据id，name更新实体
function updateEntityNameById(type, id, name)
{
    var updatedEntity;
    console.log("updateDefect was called...");
    var req = new XMLHttpRequest();
    req.open("PUT", alm_project_url + "/" + type + "s/" + id, false);
    req.setRequestHeader("Accept", "application/json");
    req.setRequestHeader("Content-Type", "application/json");

    req.onreadystatechange = function(){
        // if state is "complete"
        if (req.readyState == 4) {
            // & response status is "OK"
            if (req.status == 200){
                updatedEntity = JSON.parse(req.responseText);
            } else {
                console.log("Failed. Response status:" + req.statusText);
            }
        }
    }
    req.send("{\"name\": \"" + name + "\"}");
    console.log("updateDefect end.");
    return updatedEntity;
}

function deleteEntityById(type, id)
{
    var deletedEntity;
    console.log("deleteEntityById was called...");
    var req = new XMLHttpRequest();
    req.open("DELETE", alm_project_url + "/" + type + "s/" + id, false);
    req.setRequestHeader("Accept", "application/json");
    req.setRequestHeader("Content-Type", "application/json");

    req.onreadystatechange = function(){
        // if state is "complete"
        if (req.readyState == 4) {
            // & response status is "OK"
            if (req.status == 200){
                deletedEntity = JSON.parse(req.responseText);
            } else {
                console.log("Failed. Response status:" + req.statusText);
            }
        }
    }
    req.send();
    console.log("deleteEntityById end.");
    return deletedEntity;
}

function getNewDefect_json(name){
    return "{  \"type\": \"defect\",\
            \"name\": \"" + name + "\",\
            \"severity\": \"1-Low\",\
            \"detected-by\" : \"sa\",\
            \"creation-time\" : \"2014-01-01\" \
        }";
}

function printEntity(title, entity){
    console.log(title + ": {id = " + entity.id + ", name = " + entity.name + ", type = " + entity.type + "}");
}
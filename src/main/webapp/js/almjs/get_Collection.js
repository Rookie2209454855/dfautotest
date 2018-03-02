// get_Collection.js

function performGetCollection(prepareCollection){
    console.log(">>performGetCollection was called...");
    // create 5 new defects
    if (prepareCollection == true){
        for (i=0; i < 5; i++){
            postNewDefect("defect - " + i); // see CRUD_Instance.js
        }
    }

    // get defect entities
    var collection = getEntities("defect");
    printCollection(collection);

    // get filtered defect entities
    collection = getEntitiesByQuery("defect", "name='defect - 1' || name='defect - 3' ");
    printCollection(collection);
    console.log(">>performGetDefects end.");
}

function performGetListItems() {
    console.log(">>performGetListItems was called...");

    // get list-item entities
    var collection = getEntities("list-item");
    printCollection(collection);

    // get filtered list-item entities
    collection = getEntitiesByQuery("list-item", "name='1*'%26id<1000");
    printCollection(collection);

    // get list-item entities with selected fields
    collection = getEntitiesWithSelectedFields("list-item", "id");
    printCollection(collection);

    // get list-item entities with selected fields
    collection = getOrderedEntities("list-item", "name,-id");
    printCollection(collection);
    console.log(">>performGetListItems end.");
}

function getEntities(type)
{
    var entities;
    console.log("getEntities was called...");
    var req = new XMLHttpRequest();
    req.open("GET", alm_project_url + "/" + type + "s/", false);
    req.setRequestHeader("Accept", "application/json");

    req.onreadystatechange = function(){
        // if state is "complete"
        if (req.readyState == 4) {
            // & response status is "OK"
            if (req.status == 200){
                entities = JSON.parse(req.responseText);
            } else {
                console.log("Failed. Response status:" + req.statusText);
            }
        }
    }

    req.send();
    console.log("getEntities end.");
    return entities;
}

function getEntitiesByQuery(type, query)
{
    var entities;
    console.log("getEntitiesByQuery was called...");
    var req = new XMLHttpRequest();
    req.open("GET", alm_project_url + "/" + type + "s/?query=\"" + query + "\"", false);
    req.setRequestHeader("Accept", "application/json");

    req.onreadystatechange = function(){
        // if state is "complete"
        if (req.readyState == 4) {
            // & response status is "OK"
            if (req.status == 200){
                entities = JSON.parse(req.responseText);
            } else {
                console.log("Failed. Response status:" + req.statusText);
            }
        }
    }

    req.send();
    console.log("getEntitiesByQuery end.");
    return entities;
}

function getEntitiesWithSelectedFields(type, selectedFields) {
    var entities;
    console.log("getEntitiesWithSelectedFields was called...");
    var req = new XMLHttpRequest();
    req.open("GET", alm_project_url + "/" + type + "s/?fields=" + selectedFields, false);
    req.setRequestHeader("Accept", "application/json");

    req.onreadystatechange = function(){
        // if state is "complete"
        if (req.readyState == 4) {
            // & response status is "OK"
            if (req.status == 200){
                entities = JSON.parse(req.responseText);
            } else {
                console.log("Failed. Response status:" + req.statusText);
            }
        }
    }

    req.send();
    console.log("getEntitiesWithSelectedFields end.");
    return entities;
}

function getOrderedEntities(type, ordering) {
    var entities;
    console.log("getOrderedEntities was called...");
    var req = new XMLHttpRequest();
    req.open("GET", alm_project_url + "/" + type + "s/?order-by=" + ordering, false);
    req.setRequestHeader("Accept", "application/json");

    req.onreadystatechange = function(){
        // if state is "complete"
        if (req.readyState == 4) {
            // & response status is "OK"
            if (req.status == 200){
                entities = JSON.parse(req.responseText);
            } else {
                console.log("Failed. Response status:" + req.statusText);
            }
        }
    }

    req.send();
    console.log("getOrderedEntities end.");
    return entities;
}

function printCollection(collection){
    console.log("entities:");
    console.log("    total-count:" + collection["total-count"]);
    console.log("    actual-count:" + collection["data"].length);
    for (i=0; i < collection["data"].length; i++){
        var entity = collection.data[i];
        console.log("entity : {id=" + entity.id + ", name=" + entity.name + ", type=" +entity.type + "}");
    }
}
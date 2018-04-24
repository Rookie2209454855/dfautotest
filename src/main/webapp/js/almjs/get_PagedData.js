// get_PagedData.js

function performGetPagedData(prepareCollection){
    console.log(">>performGetPagedData was called...");
    // create 5 new defects
    if (prepareCollection == true){
        for (i=0; i < 10; i++){
            postNewDefect("defect - " + i); // see CRUD_Instance.js
        }
    }

    // get paged data
    var pageSize = 3;
    var offset = 5;
    collection = getPagedData("defect", pageSize, offset);
    printPagedCollection(collection, pageSize);
    console.log(">>performGetPagedDefects end.");
}

function performGetPagedListItems(){
    console.log(">>performGetPagedListItems was called...");

    // get paged data
    var pageSize = 10;
    var offset = 5;
    collection = getPagedData("list-item", pageSize, offset);
    printPagedCollection(collection, pageSize);
    console.log(">>performGetPagedListItems end.");
}

function getPagedData(type, limit, offset)
{
    var entities;
    console.log("getPagedData was called...");
    var req = new XMLHttpRequest();
    req.open("GET", alm_project_url + "/" + type + "s/?limit=" + limit + "&offset=" + offset, false);
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
    console.log("getPagedData end.");
    return entities;
}

function printPagedCollection(collection, pageSize){
    console.log("entities:");
    console.log("    total-count:" + collection["total-count"]);
    console.log("    page size:", pageSize);
    for (i=0; i < pageSize; i++){
        var entity = collection.data[i];
        console.log("entity : {id=" + entity.id + ", name=" + entity.name + ", type=" +entity.type + "}");
    }
}
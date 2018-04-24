/**
 * get_MetaData.js
 */
function performGetFieldsMetadata() {
    console.log(">>performGetFieldsMetadata was called...");

    // get list-item entities
    var collection = getFieldsMetadata("defect");
    printCollection(collection);
    console.log(">>performGetFieldsMetadata end.");
}

function getFieldsMetadata(type) {
    var entities;
    console.log("getFieldsMetadata was called...");
    var req = new XMLHttpRequest();
    req.open("GET", alm_project_url + "/" + type + "s$metadata/fields", false);
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
    console.log("getFieldsMetadata end.");
    return entities;
}

function printCollection(collection){
    console.log("entities:");
    console.log("    total-count:" + collection["total-count"]);
    console.log("    actual-count:" + collection["data"].length);
    for (i=0; i < collection["data"].length; i++){
        var entity = collection.data[i];
        console.log("entity : {label=" + entity.label + ", name=" + entity.name + ", type=" +entity.type.name + "}");
    }
}

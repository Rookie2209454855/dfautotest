// post_delete_Lock.js

//执行删除锁定列
function performPostDeleteLock(){
    console.log(">>performPostDeleteLock was called...");
    // create entity Defect
    var createdEntity = postNewDefect("defect for locking"); // see CRUD_Instance.js
    printEntity("created entity:", createdEntity);

    // lock defect
    var lock = lockEntity("defect", createdEntity.id);
    printLock("created lock", lock);

    // delete lock
    var deletedLock = deleteLockEntity(lock);
    printLock("deleted lock", deletedLock);
    console.log(">>performPostDeleteLock end.");
}

//锁定实体
function lockEntity(type, id){
    var createdEntity;
    console.log("lockEntity was called...");
    var req = new XMLHttpRequest();
    req.open("POST", alm_project_url + "/locks/", false);
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
    req.send(getLockEntity_json(type, id));
    console.log("lockEntity end.");
    return createdEntity;
}

//删除锁定实体
function deleteLockEntity(lock){
    var createdEntity;
    console.log("deleteLockEntity was called...");
    var req = new XMLHttpRequest();
    req.open("DELETE", alm_project_url + "/locks/" + lock.id, false);
    req.setRequestHeader("Accept", "application/json");
    req.setRequestHeader("Content-Type", "application/json");

    req.onreadystatechange = function(){
        // if state is "complete"
        if (req.readyState == 4) {
            // & response status is "OK"
            if (req.status == 200){
                createdEntity = JSON.parse(req.responseText);
            } else {
                console.log("Failed. Response status:" + req.statusText);
            }
        }
    }
    req.send();
    console.log("deleteLockEntity end.");
    return createdEntity;
}

//获取锁定实体json
function getLockEntity_json(type, id){
    return "{\
                \"entity\": {\
                    \"id\": " + id + ",\
                    \"type\":\"" + type + "\"\
                }\
            }";
}

//打印选中实体
function printLock(title, lock){
    console.log(title + ":");
    console.log("    lock.id = " + lock.id);
    console.log("    lock.user = " + lock.user);
    console.log("    lock.lock-time = " + lock["lock-time"]);
    console.log("    lock.entity.type = " + lock.entity.type);
    console.log("    lock.entity.id = " + lock.entity.id);
}
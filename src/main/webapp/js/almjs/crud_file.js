// crud_File.js

function performCRUDFile(){
    console.log(">>performCRUDFile was called...");
    // create entity Defect
    var createdEntity = postNewDefect("defect for attachments"); // see CRUD_Instance.js
    printEntity("created entity:", createdEntity);

    //var formData = getFormWithFile_rest_version(createdEntity)
    var formData = getFormWithFile_api_version(createdEntity)
    var createdAttachment = addAttachment(formData);
    printEntity("created attachment", createdAttachment);

    console.log(">>performCRUDFile end.");
}

//添加附件
function addAttachment(formData){
    console.log("addAttachment was called...");
    var req = new XMLHttpRequest();
    req.open("POST", alm_project_url + "/attachments/", false);
    req.setRequestHeader("Accept", "application/json");

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
    req.send(formData);
    console.log("addAttachment end.");
    return createdEntity;
}

//获取表单附件api详细
function getFormWithFile_api_version(entity){
    var fileInputElement = document.getElementById("uploadfile");

    var formData = new FormData();
    formData.append("entity.type", entity.type);
    formData.append("entity.id", entity.id);
    formData.append("description", "attachment description");
    formData.append("filename", fileInputElement.files[0].name);
    formData.append("content", fileInputElement.files[0]);

    return formData;
}
$(function(){

    //自定义文件选择器
    $("#input-file").change(function () {
        $(".j-file-text").text($(this).val());
    })



    $("#devices").change(function () {
        $("#Modal-import").modal('show');
    })

    /**
     * 确认导入
     */
    $("#_agree").click(function () {
        var did= $("#devices").val();
        if(did==0){
            alert("请选择设备!");
        }else {
            importExcel(did);
        }
    });

    /**
     * 导入Excel
     * @param did
     */
    function importExcel(did) {
        $("#Modal-import").modal("hide");
        var Id=$("#pcid").val();
        var formData = new FormData();
        formData.append("file", $("#input-file").prop("files")[0]);
        formData.append("did", $("#devices").val());
        $.ajax({
            url: "/dfzq/uploadExcel",
            type: "POST",
            data: formData,
            processData: false,
            contentType: false,
            success: function(data){
                var content;
                if(data == "success"){
                    content = "导入成功";
                }else if(data == "error"){
                    content = "导入失败";
                }
                layer.confirm(content,function(){
                    $("#Modal-qualified-set").modal("hide");
                    layer.closeAll('dialog');
                    location.reload();
                });
            }
        });
    }

})

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
        /*$("#Modal-import").modal("hide");*/
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
                var content=data;
                console.log(content);
                var progress="<div class='progress'>"+
                    "<div class='progress-bar progress-bar-info' role='progressbar' aria-valuenow='60' aria-valuemin='0' aria-valuemax='100' style='width: 50%;'>"
                    +"<span class='sr-only'>50% 执行中（成功）</span>"
                    +"</div>"
                    +"</div>";
               /* $("#head").empty().append("执行中...");
                $("#smessage").empty().append(progress);*/
            }
        });
    }

})

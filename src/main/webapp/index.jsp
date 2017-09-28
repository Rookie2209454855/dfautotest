<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.tmpl.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-paginator.js"></script>
<head>
    <title>Hello Tester!</title>
</head>
<body>
    <div  class="container" >
        <h1  class="text-center">welcome</h1>
        <div class="input-group">
            <span class="input-group-btn">
                <button class="btn btn-default" type="button">
                    选择设备
                </button>
            </span>
            <select class="form-control" id="devices"></select>
            <span class="input-group-btn">
               <button class="btn btn-default" data-toggle="modal" data-target="#myModal">
                    添加设备
                </button>
            </span>
        </div>
    </div>

    <%--上传Excel插件--%>
    <form enctype="multipart/form-data" id="batchUpload"  action="dfzq/upload" method="post" class="form-horizontal">
        <button class="btn btn-success btn-xs" id="uploadEventBtn" style="height:26px;"  type="button" >选择文件</button>
        <input type="file" name="file"  style="width:0px;height:0px;" id="uploadEventFile">
        <input id="uploadEventPath"  disabled="disabled"  type="text" placeholder="请选择excel表" style="border: 1px solid #e6e6e6; height: 26px;width: 200px;" >
    </form>
    <button type="button" class="btn btn-success btn-sm"  onclick="userDevice.uploadBtn()" >上传</button>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        添加设备
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="input-group">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    app路径:
                                </button>
                            </span>
                        <input type="text" class="form-control" id="appPath">
                    </div>
                    <br>
                    <div class="input-group">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    设备名:
                                </button>
                            </span>
                        <input type="text" class="form-control" id="deviceName">
                    </div>
                    <br>
                    <div class="input-group">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    设备系统:
                                </button>
                            </span>
                        <select class="form-control" id="platformName">
                            <option value="Android">Android</option>
                            <option value="IOS">IOS</option>
                        </select>
                    </div>
                    <br>
                    <div class="input-group">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    系统版本:
                                </button>
                            </span>
                        <input type="text" class="form-control" id="platformVersion">
                    </div>
                    <br>
                    <div class="input-group">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    设备UDID:
                                </button>
                            </span>
                        <input type="text" class="form-control" id="udid">
                    </div>
                    <br>
                    <div class="input-group">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    appium服务(url):
                                </button>
                            </span>
                        <input type="text" class="form-control" id="serverUri">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary" id="addDevice">
                        提交更改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</body>
<%--加载模板--%>
<script id="devicesTemplate" type="text/x-jquery-tmpl">
<option value="0">请选择</option>
{{each(i,device) _devices}}
    <option value="{{= device.deviceid}}">{{= device.device_name}}</option>
{{/each}}
</script>

<script  charset="utf-8"  src="${pageContext.request.contextPath}/js/index.js"></script>
<script  charset="utf-8"  src="${pageContext.request.contextPath}/js/excel.js"></script>
</html>

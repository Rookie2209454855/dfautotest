<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
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
        <%--<button type="button" class="btn btn-info btn-xs j-import" id="daoru">导入案例</button>--%>
    </div>

    <div class="modal fade" id="Modal-import" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" id="head">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">导入需执行的案例</h4>
                </div>
                <div class="modal-body col-xs-12">
                    <div class="form-horizontal">
                        <div class="form-group" id="smessage">
                            <label for="input-file" class="col-sm-2 control-label">案例</label>
                            <div class="col-sm-10 input-group m-input-group j-input-group" form-prompt="false" form-prompt-text="文件选择错误">
                                <input type="file" class="form-control" id="input-file" value="" style="display: none" />
                                <div class="form-control j-file-text m-file-text" style="width: 389px"></div>
                                <span class="input-group-btn">
                                    <label for="input-file" class="btn btn-info j-file-click" type="button">选择执行案例</label>
                                </span>
                            </div>
                            <div class="form-group">
                                <a class="col-sm-3 control-label" href="${pageContext.request.contextPath}/template/测试案例模版.xlsx" download="测试案例模版.xlsx">下载案例模版</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary j-confirm-btn" id="_agree">确定</button>
                </div>
            </div>
        </div>
    </div>

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
                            <span class="input-group-btn">00
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
                        提交设备
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

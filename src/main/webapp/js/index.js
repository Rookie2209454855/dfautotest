var pageNo=1;
var pageSize=20;
$(document).ready(function(){
	showDevice();

	function showDevice() {
		$.ajax({
			type:'GET',
			dataType: "json",
			url:"/dfzq/showDevices",
			success:function(data){
				console.log(data);
				$("#devices").empty();
				$("#devicesTemplate").tmpl({_devices:data}).appendTo("#devices");
			},
			error:function(){
				alert("加载设备列表失败!");
			}
		})
	}
	
	$("#addDevice").click(function () {
		var appPath=$("#appPath").val();
		var deviceName=$("#deviceName").val();
		var platformName=$("#platformName").val();
		var platformVersion=$("#platformVersion").val();
		var udid=$("#udid").val();
		var serverUri=$("#serverUri").val();
		$.ajax({
			type:'GET',
			data:{
				"apppath":appPath,
				"device_name":deviceName,
				"platform_name":platformName,
				"platform_version":platformVersion,
				"udid":udid,
				"uri":serverUri
			},
			dataType: "json",
			url:"/dfzq/addDevice",
			success:function(data){
				alert("已添加"+data+"部设备!");
			},
			error:function(){
				alert("添加磁盘文件失败");
			}
		})
	});



})

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>>
<script src="${pageContext.request.contextPath}/js/Base.js"></script>>
<head>
    <title>Hello Tester!</title>
</head>
<body>
用户名:<input type="text" id="user"/>
密码:<input type="text" id="pass"/>
<button onclick="performSignin();">连接</button>
</body>
<script type="text/javascript">
    var alm_api="http://192.168.57.26:5174/qcbin/api";
    var sign_in = "/authentication/sign-in";

    function getHttpRequest()
    {
        req = null;
        if (window.XMLHttpRequest) {
            try {
                return new XMLHttpRequest();
            } catch (e){}
        } else if (window.ActiveXObject) {
            try {
                return new ActiveXObject('Msxml2.XMLHTTP');
            } catch (e){
                try {
                    return new ActiveXObject('Microsoft.XMLHTTP');
                } catch (e){}
            }
        }
        return null;
    }

    function performSignin()
    {
        try {
            var user=$('user').val();
            var pass=$('pass').val();
            console.log("performSignin was called...");
            var req =getHttpRequest(); //new XMLHttpRequest();

            req.open("POST", alm_api + sign_in, true);
            req.setRequestHeader("Content-Type", "application/json");
            req.setRequestHeader("Accept", "application/json");
            req.setRequestHeader("Authorization", "Basic " + Base64.encode(user + ":" + pass));

            req.onreadystatechange = function(){
                // if state is "complete"
                if (req.readyState == 4) {
                    // & response status is "OK"
                    if (req.status == 200){
                        console.log("performSignin end.");
                    } else {
                        console.log("Failed. Response status:" + req.statusText);
                    }
                }
            }

            req.send();
        }
        catch( e ) {
            console.log("performSignin failed: " + e.message);
        }
    }

</script>
</html>

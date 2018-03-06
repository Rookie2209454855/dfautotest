

import almTest.infrastructure.Response;
import com.google.gson.Gson;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

public class testAlm {

    String up="fengtiepeng:a123456";



    public void cCase(String lurl,String curl,Map<String,String> parameters)throws IOException{
        java.net.URL connURL = new java.net.URL(lurl);

        // 打开URL连接
        java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                .openConnection();
        // 设置通用属性
        httpConn.setRequestProperty("Content-Type", "application/json");
        httpConn.setRequestProperty("Accept", "application/json");

        httpConn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString(up.getBytes()));
        // 设置POST方式
        httpConn.setDoInput(true);
        httpConn.setDoOutput(true);
        //获取返回返回头信息
        Map<String,String> cookies=new HashMap<>();
        Iterable<String> newCookies =
                httpConn.getHeaderFields().get("Set-Cookie");
        if (newCookies != null) {

            for (String cookie : newCookies) {
                int equalIndex = cookie.indexOf('=');
                int semicolonIndex = cookie.indexOf(';');

                String cookieKey = cookie.substring(0, equalIndex);
                String cookieValue =
                        cookie.substring(equalIndex + 1, semicolonIndex);

                cookies.put(cookieKey, cookieValue);
            }
        }

        if(httpConn.getResponseCode()==200){
            System.out.println("登陆成功");
            sendPost(curl,parameters,httpConn,cookies);

        }
    }

    /**
     * 发送POST请求
     *
     * @param url
     *            目的地址
     * @param parameters
     *            请求参数，Map类型。
     * @return 远程响应结果
     */
    public  String sendPost(String url, Map<String, String> parameters, HttpURLConnection httpConn,Map<String,String> cookies) {
        String result = "";// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        PrintWriter out = null;
        StringBuffer sb = new StringBuffer();// 处理请求参数
        String params = "";// 编码之后的参数
        Gson gson=new Gson();
        try {
            // 编码请求参数
            //params=this.forEncode(parameters);
            params=gson.toJson(parameters).toString();
            System.out.println(params);
            // 创建URL对象
            httpConn=(java.net.HttpURLConnection) new URL(url)
                    .openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("Accept", "application/json");
            httpConn.setRequestProperty("Charsert", "UTF-8"); //设置请求编码


            StringBuilder sb1 = new StringBuilder();
            if (!cookies.isEmpty()) {

                Set<Map.Entry<String, String>> cookieEntries =
                        cookies.entrySet();
                for (Map.Entry<String, String> entry : cookieEntries) {
                    sb1.append(entry.getKey()).append("=").append(entry.getValue()).append(";");
                }
            }


            httpConn.setRequestProperty("Cookie",sb1.toString());
            //httpConn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString(up.getBytes()));
            // 设置POST方式
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);



            // 获取HttpURLConnection对象对应的输出流
            out = new PrintWriter(httpConn.getOutputStream());
            // 发送请求参数
            out.write(params);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn
                    .getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
            if(result.equals("")){
                result=String.valueOf(httpConn.getResponseCode());
            }
            System.out.println(httpConn.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 发送GET请求
     *
     * @param url
     *            目的地址
     * @param parameters
     *            请求参数，Map类型。
     * @return 远程响应结果
     */
    public  String sendGet(String url, Map<String, String> parameters) {
        String result = "";// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        StringBuffer sb = new StringBuffer();// 存储参数
        String params = "";// 编码之后的参数
        try {
            params=this.forEncode(parameters);
            String full_url = url + "?" + params;
            System.out.println(full_url);
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(full_url);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                    .openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 建立实际的连接
            httpConn.connect();
            // 响应头部获取
            Map<String, List<String>> headers = httpConn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : headers.keySet()) {
                System.out.println(key + "\t：\t" + headers.get(key));
            }
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn
                    .getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    /***
     * 编码请求参数
     * @param parameters
     * @return
     * @throws IOException
     */
    public String forEncode(Map<String,String> parameters)throws IOException{// 编码请求参数
        String params=null;
        StringBuffer sb=new StringBuffer();
        if (parameters.size() == 1) {
            for (String name : parameters.keySet()) {
                sb.append(name).append("=").append(
                        java.net.URLEncoder.encode(parameters.get(name),
                                "UTF-8"));
            }
           return params = sb.toString();
        } else {
            for (String name : parameters.keySet()) {
                sb.append(name).append("=").append(
                        java.net.URLEncoder.encode(parameters.get(name),
                                "UTF-8")).append("&");
            }
            String temp_params = sb.toString();
            return params = temp_params.substring(0, temp_params.length() - 1);
        }
    }


    //添加新的case
    /*function postNewDefect(name)
    {
        var createdEntity;
        console.log("postNewDefect was called...");
        var req = new XMLHttpRequest();
        req.open("POST", alm_project_url + "/defects/", false);
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
        req.send(getNewDefect_json(name));
        console.log("postNewDefect end.");
        return createdEntity;
    }


     return "{  \"type\": \"defect\",\
            \"name\": \"" + name + "\",\
            \"severity\": \"1-Low\",\
            \"detected-by\" : \"sa\",\
            \"creation-time\" : \"2014-01-01\" \
        }";
*/

    @Test
    public void test()throws IOException{
        String uri="http://192.168.57.26:5174/qcbin/api/authentication/sign-in";
        String curi="http://192.168.57.26:5174/qcbin/api/domains/"+ URLEncoder.encode("测试部")+"/projects";
        System.out.println(curi);

        Map<String,String> map=new HashMap<>();
        map.put("type","defect");
        map.put("name","test_feng");
        map.put("severity","1-Low");
        map.put("detected-by","sa");
        map.put("creation-time",new Date().toString());
        //String result=
        cCase(uri, curi,map);
        //System.out.println(result);
    }

}
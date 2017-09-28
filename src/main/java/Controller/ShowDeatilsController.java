package Controller;

import Entity.TDevice;
import IService.DeviceService;
import IService.ExcelUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fengtiepeng on 2017/9/26.
 */
@Controller
public class ShowDeatilsController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ExcelUploadService excelUploadService;


    /***
     * 跳转播放视频
     * @param model
     * @param id
     * @return
     * @throws UnknownHostException
     */
    @RequestMapping(value = "/showDevices",method = RequestMethod.GET)
    @ResponseBody
    public List<TDevice> showDevices(Model model, Long id)throws UnknownHostException{
        List<TDevice> deviceList=deviceService.showAllDevice(new TDevice());
        return deviceList;
    }

    @RequestMapping(value = "/addDevice",method = RequestMethod.GET)
    @ResponseBody
    public Integer addDevice(TDevice tDevice)throws UnknownHostException{
        return deviceService.addDevice(tDevice);
    }


    @RequestMapping(value = "/uploadExcel")
    @ResponseBody
    public String uploadExcel(@RequestParam(value="file",required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        return excelUploadService.readExcelFile(file);
    }

    /*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping("springUpload")
    public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException
    {
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="E:/springUpload"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }

            }

        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "/success";
    }
}

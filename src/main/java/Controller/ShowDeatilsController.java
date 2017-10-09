package Controller;

import Driver.CreatCase;
import Entity.Step;
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

    private CreatCase creatCase=new CreatCase();



    /***
     * 返回全部设备
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

    /***
     *添加设备
     * @param tDevice
     * @return
     * @throws UnknownHostException
     */
    @RequestMapping(value = "/addDevice",method = RequestMethod.GET)
    @ResponseBody
    public Integer addDevice(TDevice tDevice)throws UnknownHostException{
        return deviceService.addDevice(tDevice);
    }


    /***
     * 上传excel文档
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadExcel")
    @ResponseBody
    public String uploadExcel(@RequestParam(value="file",required = false)MultipartFile file,@RequestParam(value="did",required = false)Integer did)
            throws IOException{
        String path="F:\\异常图片\\"+file.getOriginalFilename().split("\\.")[0]+"\\";
        List<TDevice> tDevice=deviceService.showAllDevice(new TDevice(did));
        List<Step> steps= excelUploadService.readExcelFile(file);
        /*选中设备，执行list步骤*/
        creatCase.cases(tDevice.get(0),steps,path);
        return null;
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

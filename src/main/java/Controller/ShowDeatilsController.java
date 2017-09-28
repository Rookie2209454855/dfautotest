package Controller;

import Entity.TDevice;
import IService.DeviceService;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by fengtiepeng on 2017/9/26.
 */
@Controller
public class ShowDeatilsController {

    @Autowired
    private DeviceService deviceService;


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


    @RequestMapping(value = "/uploadExcel",method = RequestMethod.POST)
    public void uploadExcel(MultipartFile file, HttpRequest httpRequest, HttpResponse httpResponse){


    }
}

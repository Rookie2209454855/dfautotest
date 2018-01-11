package IService.IServiceImpl;

import Entity.TDevice;
import IDao.DeviceDao;
import IService.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengtiepeng on 2017/9/25.
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public List<TDevice> showAllDevice(TDevice tDevice) {
        return deviceDao.findAllDevice(tDevice);
    }

    @Override
    public Integer addDevice(TDevice tDevice) {
        return deviceDao.addDevices(tDevice);
    }
}

package IService;

import Entity.TDevice;

import java.util.List;

/**
 * Created by fengtiepeng on 2017/9/25.
 */
public interface DeviceService {

    List<TDevice> showAllDevice(TDevice tDevice);

    Integer addDevice(TDevice tDevice);

}

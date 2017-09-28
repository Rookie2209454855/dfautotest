package IDao;

import Entity.TDevice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fengtiepeng on 2017/9/26.
 */
public interface DeviceDao {

    /***
     * 显示所有设备信息
     * @param tDevice
     * @return
     */
    List<TDevice> findAllDevice(@Param("tDevice")TDevice tDevice);

    /***
     * 添加设备
     * @param tDevice
     * @return
     */
    Integer addDevices(@Param("tdevice")TDevice tDevice);

    /***
     * 删除设备
     * @param did
     * @return
     */
    Integer delDevice(@Param("did")Integer did);
}

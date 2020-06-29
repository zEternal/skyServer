package com.star.tcs.util;
/**
 * Title: KopenTCSUtil
 * 功能：openTCS内核服务工具类
 * author: star
 * Creation time: 2020-
 * Modification time：
 * version： V1.0
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opentcs.access.KernelServicePortal;
import org.opentcs.access.rmi.KernelServicePortalBuilder;
import org.opentcs.components.kernel.services.PlantModelService;

public class KopenTCSUtil {
    private static Logger logger = LogManager.getLogger(KopenTCSUtil.class);
    //Provides clients access to kernel services.提供客户端访问内核服务的权限。
    private static KernelServicePortal servicePortal = null;
    //private static RemoteKernelServicePortalProxy servicePortal = null;
    static {
        /*获取服务对象*/
        //servicePortal = new KernelServicePortalBuilder().build();
        servicePortal = new KernelServicePortalBuilder().build();
        //Connect and log in with a kernel somewhere.在某个地方连接并登录内核。
        servicePortal.login("localhost", 1099);
        //servicePortal.login("49.232.63.184", 1099);
        //Get a reference to the plant model service...获取对工厂模型服务的参考...
        PlantModelService plantModelService = servicePortal.getPlantModelService();
        String modelName = plantModelService.getModelName();

        logger.info("载入模型：" + modelName);

    }

    public static KernelServicePortal getKernelServicePortal() {
        return servicePortal;
    }

    public static String isNull(Object object){
        if (object == null){
            return "空的";
        }  else {
            return "不是空的";
        }
    }
}

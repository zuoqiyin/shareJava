package cn.zuoqy.classLoad;

import com.sun.org.apache.bcel.internal.generic.LoadClass;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载manager工厂
 * Created by zuoqy on 14:51 2017/11/22.
 */

public class ManagerFactory {

    //记录热加载类的加载信息
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<>();
    //要加载类的classpath
    private static final String CLASS_PATH = "E:\\GIT\\hello\\out\\production\\hello\\";
    //实现热加载的类的全名称(包名+类名)
    public static final String MY_MANAGER = "cn.zuoqy.classLoad.MyManager";

    public static BaseManager getManager(String className) {
        File loadFile = new File(CLASS_PATH+className.replaceAll("\\.","/")+".class");
        long lastModified = loadFile.lastModified();

        if (loadTimeMap.get(className) == null) {   //loadTimeMap不包含className为key的loadInfo信息。证明这个类没有被加载，那么需要加载这个类信息到JVM
            load(className, lastModified);
        } else if (loadTimeMap.get(className).getLoadTime()!=lastModified) { //加载类的时间戳变化了，我们同样要重新加载这个类到JVM
            load(className, lastModified);
        }
        return loadTimeMap.get(className).getManager();
    }

    private static void load(String className, long lastModified) {
        MyClassLoad myClassLoad = new MyClassLoad(CLASS_PATH);
        Class<?> loadClass = null;
        try {
            //loadClass = myClassLoad.loadClass(className);
            loadClass = myClassLoad.findClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BaseManager manager = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoad, lastModified);
        loadInfo.setManager(manager);
        loadTimeMap.put(className,loadInfo);
    }

    //以反射的方式创建BaseManager的子类对象
    private static BaseManager newInstance(Class<?> loadClass) {
        try {
            return (BaseManager)loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

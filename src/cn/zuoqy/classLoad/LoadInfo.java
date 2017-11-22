package cn.zuoqy.classLoad;

/**
 * 封装加载类的信息
 * Created by zuoqy on 14:45 2017/11/22.
 */

public class LoadInfo {
    // 自定义的类加载
    private MyClassLoad myLoad;
    // 记录要加载的类的时间戳-->加载的时间
    private Long loadTime;

    private BaseManager manager;

    public LoadInfo(MyClassLoad myLoad, Long loadTime) {
        this.myLoad = myLoad;
        this.loadTime = loadTime;
    }

    public MyClassLoad getMyLoad() {
        return myLoad;
    }

    public void setMyLoad(MyClassLoad myLoad) {
        this.myLoad = myLoad;
    }

    public Long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getManager() {
        return manager;
    }

    public void setManager(BaseManager manager) {
        this.manager = manager;
    }
}

package cn.zuoqy.classLoad;

/**
 * 后台启动一条线程不断重新加载实现了热加载的类
 * Created by zuoqy on 15:48 2017/11/22.
 */

public class MsgHandler implements Runnable {

    @Override
    public void run() {
        while (true) {
            BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.logic();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

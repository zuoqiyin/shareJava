package cn.zuoqy.classLoad;

/**
 * BaseManager的子类，此类需要实现java类的热加载功能
 * Created by zuoqy on 14:43 2017/11/22.
 */

public class MyManager implements BaseManager {

    @Override
    public void logic() {
        System.out.println("我在用IDEA编写代码...");
        System.out.println("我在编写热加载测试功能...");
    }
}

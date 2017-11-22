package cn.zuoqy.classLoad;

/**
 * 测试java的热加载
 * Created by zuoqy on 15:51 2017/11/22.
 */

public class ClassLoadTest {

    public static void main(String[] args) {
        new Thread(new MsgHandler()).start();
    }
}

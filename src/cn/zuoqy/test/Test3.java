package cn.zuoqy.test;

/**
 * Created by zuoqy on 16:38 2017/12/28.
 */

public class Test3 {

    public static void main(String[] args) {
        String s = "<Script></script>";
        s = s.replaceAll("[<]([a-zA-Z]{6})","&lt;$1");
        System.out.println(s);
    }
}

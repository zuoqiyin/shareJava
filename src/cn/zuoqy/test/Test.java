package cn.zuoqy.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuoqy on 8:21 2017/11/22.
 */
public class Test {

    public  static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add(new String("1"));
        list.add(new String("2"));
        list.add(new String("3"));
        list.add(new String("4"));
        list.add(new String("5"));
        list.add(new String("6"));
        list.add(new String("7"));
        list.add(new String("8"));
        list.add(new String("9"));

        for (int i=0; i<list.size(); i++) {
            if (list.get(i).equals("9")) {
                list.remove(i);
                i--;

            }else if (list.get(i).equals("1")) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
}

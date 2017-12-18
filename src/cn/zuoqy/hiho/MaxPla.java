package cn.zuoqy.hiho;

import java.util.Scanner;

/**
 * 最长回文子串-1032
 * Created by zuoqy on 9:21 2017/12/18.
 */

public class MaxPla {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要输入字符串的个数:");
        int count = scanner.nextInt();
        System.out.println("请输入字符串:");
        String[] str = new String[count];
        for (int i=0; i<count; i++) {
            str[i] = scanner.next();
        }
        System.out.println("结果:");
        for (String s: str) {
            System.out.println(new MaxPla().maxPla(s));
        }
    }

    /**
     * 求字符串最长回文子串长度
     * @param str 字符串
     * @return 最长回文子串长度
     */
    private int maxPla(String str) {
        int n = 1;
        for (int i=0; i<str.length(); i++) {
            for (int j=i; j<str.length(); j++) {
                String temp = str.substring(i, j+1);
                if (isPla(temp) && temp.length() > n) n = temp.length();
            }
        }
        return n;
    }

    /**
     * 是否是回文串
     * @param str 字符串
     * @return true/false
     */
    private boolean isPla(String str) {
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length/2; i++) {
            if(chars[i] != chars[chars.length-1-i]) {
                return false;
            }
        }
        return true;
    }
}

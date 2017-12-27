package cn.zuoqy.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuoqy on 8:21 2017/11/22.
 */
public class Test1 {

    public  static void main(String[] args) {
        int[][] arr = {{5,2,3},{4,5,6}};
        trs(arr,2,3);
    }

    public static void trs(int[][] arr, int m, int n) {
        int[][] trs = new int[n][m];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                trs[j][i] = arr[i][j];
            }
        }
        System.out.println("转置矩阵:");
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(trs[i][j]+"\t");
            }
            System.out.println();
        }
        int min = trs[0][0];
        int l = 0;//最小值列
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
               if (min>trs[i][j]) {
                   l = j;
               }
            }
        }
        System.out.println("最小值所在的列:"+l);

    }
}

package cn.zuoqy.classLoad;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义java类加载器来实现java类热加载
 * Created by zuoqy on 14:29 2017/11/22.
 */

public class MyClassLoad extends ClassLoader{

    // 要加载的java类classPath路径
    private String classPath;

    public MyClassLoad(String classPath) {
        super(ClassLoader.getSystemClassLoader());
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassDate(name);
        return this.defineClass(name, data, 0,  data.length);
    }

    /**
     * 加载class文件中的内容
     * @param name
     * @return
     */
    private byte[] loadClassDate(String name) {
        try{
            name = name.replaceAll("\\.","//");
            FileInputStream is = new FileInputStream(new File(classPath+name+".class"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b=is.read())!=-1) {
                baos.write(b);
            }
            is.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

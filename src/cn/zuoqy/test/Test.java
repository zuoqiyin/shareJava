package cn.zuoqy.test;

import javax.sound.midi.Soundbank;

/**
 * Created by zuoqy on 14:05 2017/12/27.
 */

public class Test {

    public static void main(String[] args) {
        MyRectangle myRectangle = new MyRectangle(20.0,10.0);
        System.out.println(myRectangle.toString());
    }
}

interface Shape{
     double getArea();

     double getPerimeter();
}

class MyRectangle implements Shape {

    private double width;
    private double height;

    public MyRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return this.width*this.height;
    }

    @Override
    public double getPerimeter() {
        return 2*(this.width+this.height);
    }

    @Override
    public String toString() {
        return "\"width="+this.width+",height="+height+",perimeter="+getPerimeter()+",area="+getArea()+"\"";
    }
}

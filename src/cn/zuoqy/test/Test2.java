package cn.zuoqy.test;

/**
 * Created by zuoqy on 14:16 2017/12/27.
 */

public class Test2 {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(3,1,5);
        try {
            System.out.println("三角形周长"+triangle.getPerimeter());
            System.out.println("三角形信息"+triangle.showInfo());
        } catch (NotTriangleException e) {
            e.printStackTrace();
        }
    }
}

class Triangle{

    private double x;
    private double y;
    private double z;

    public Triangle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getArea() throws NotTriangleException{
        if(x+y<z || x+z<y || y+z<x){
            throw new NotTriangleException("三辺不能构成三角形");
        }
        double p = (x+y+z)/2;
        return Math.sqrt(p*(p-x)*(p-y)*(p-z));
    }

    public double getPerimeter() throws NotTriangleException {
        if(x+y<z || x+z<y || y+z<x){
            throw new NotTriangleException("三辺不能构成三角形");
        }
        return x+y+z;
    }

    public String showInfo() throws NotTriangleException{
        if(x+y<z || x+z<y || y+z<x){
            throw new NotTriangleException("三辺不能构成三角形");
        }
        if(x==y || x==y || y==z)
        {
            if(x==y && y==z) return "等边三角形";
            else return "等腰三角形";
        }
        if(x*x+y*y==z*z || x*x+z*z==y*y || y*y+z*z==x*x)
        {
            return "直角三角形";

        }
        return "一般三角形";
    }
}

class NotTriangleException extends Exception{
     NotTriangleException(String message) {
        super(message);
     }
}

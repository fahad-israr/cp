import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//Creating an interface Shape
interface  Shape{ 
    int GetArea();
}

//===Implementing Shape: Rectangle===
class Rectangle implements Shape{
    
    int height,width;
    
    //Constructor to initialize hight and width
    Rectangle(int height,int width){
        this.height = height;
        this.width = width;
    }
    
    //Implementing GetArea() function
    public int GetArea(){
      return Math.round(this.height*this.width);   
     }
     
}

//===Implementing Shape: Triangle===
class Triangle implements Shape{
    
    int height,width;
    //Constructor to initialize hight and width
    Triangle(int height,int width){
        this.height = height;
        this.width = width;
    }
    
    //Implementing GetArea() function
    public int GetArea(){
      return (int)Math.round((1.0*this.height*this.width)/2);   
     }
     
 }

//===Implementing Shape: Circle===
class Circle implements Shape{
    
    int radius;
    //Constructor to initialize radius
    Circle(int radius){
        this.radius = radius;
    }
    
    //Implementing GetArea() function
    public int GetArea(){
      return (int)Math.round(3.14*this.radius*this.radius);   
    }
     
 }
 

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String rawInput;
        try {
            rawInput = in.nextLine();

            String[] parameters = rawInput.split(" ");

            int rectHeight = Integer.parseInt(parameters[0]);
            int rectWidth = Integer.parseInt(parameters[1]);

            int triHeight = Integer.parseInt(parameters[2]);
            int triWidth = Integer.parseInt(parameters[3]);

            int cirRadius = Integer.parseInt(parameters[4]);

            int totalArea = 0;

            List<Shape> shapes = new ArrayList<>();
            shapes.add(new Rectangle(rectHeight, rectWidth));
            shapes.add(new Triangle(triHeight, triWidth));
            shapes.add(new Circle(cirRadius));

            for(Shape shape : shapes)
            {
                totalArea += shape.GetArea();
            }

            System.out.println(String.valueOf(totalArea));

        } catch (Exception e) {
        }
    }
}

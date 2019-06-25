
package Geometry;

import java.io.BufferedReader;
import java.io.IOException;

public class Circle extends Geom2D {

    private double radius;
    private String type;
    
    public Circle() {
        this.radius = 1.0;
        name = "Circle";
    }
     
    public Circle(double radius) {
        this.radius = radius;
        name = "Circle";
    }
    
    public Circle(String name, double radius, double[] center) {
        this.name = name;
        this.radius = radius;
        this.center = center;
        type = "Circle";
    }

    @Override
    public double computeArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public String toString() {
        return "Circle:\n" 
        + "Radius = " + radius + "\n"
        + super.toString();
    }

    @Override
    public void read(BufferedReader br) throws IOException {
        String line = br.readLine();
        String numbers[] = line.split(" ");
        radius = Double.parseDouble(numbers[0]);
        center[0] = Double.parseDouble(numbers[1]);
        center[1] = Double.parseDouble(numbers[2]);
        center[2] = Double.parseDouble(numbers[3]);
    }
    
    @Override
    public String getParameters() {
        String value = radius + ",";
        value = value + center[0] + "," + center[1] + "," + center[2];
        return value;
    }
    
    @Override
     public String getType() {
         return type;
     }

    public double returnRadius(){
    return radius;
    }
}

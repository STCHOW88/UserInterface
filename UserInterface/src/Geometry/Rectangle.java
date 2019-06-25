package Geometry;

import java.io.BufferedReader;
import java.io.IOException;

public class Rectangle extends Geom2D {

    private double length;
    private double height;
    private String type;

    public Rectangle() {
        this.length = 1.0;
        this.height = 1.0;
        name = "Rectangle";
    }

    public Rectangle(double width, double height) {
        this.length = width;
        this.height = height;
        name = "Rectangle";
    }

    public Rectangle(String name, double length, double width, double[] center) {
        this.name = name;
        this.length = length;
        this.height = height;
        this.center = center;
        type = "Rectangle";
    }

    @Override
    public double computeArea() {
        return length * height;
    }

    @Override
    public String toString() {
        return "Rectangle: \n"
                + "Width = " + length + "\n"
                + "Height = " + height + "\n"
                + super.toString();
    }

    @Override
    public void read(BufferedReader br) throws IOException {
        String line = br.readLine();
        String numbers[] = line.split(" ");
        length = Double.parseDouble(numbers[0]);
        height = Double.parseDouble(numbers[1]);
        center[0] = Double.parseDouble(numbers[2]);
        center[1] = Double.parseDouble(numbers[3]);
        center[2] = Double.parseDouble(numbers[4]);
    }

    @Override
    public String getParameters() {
        String value = length + "," + length + ",";
        value = value + center[0] + "," + center[1] + "," + center[2];
        return value;
    }
    
    @Override
     public String getType() {
         return type;
     }

    public double returnLength() {
        return length;
    }
    
    public double returnWidth() {
        return height;
    }

}

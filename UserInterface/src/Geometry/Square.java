package Geometry;

import java.io.BufferedReader;
import java.io.IOException;

public class Square extends Geom2D {

    private double length;
    private String type;

    public Square() {
        this.length = 1.0;
        name = "Square";
    }

    public Square(double length) {
        this.length = length;
        name = "Square";
    }

    public Square(String name, double length, double[] center) {
        this.name = name;
        this.length = length;
        this.center = center;
        type = "Square";
    }

    @Override
    public double computeArea() {
        return length * length;
    }

    @Override
    public String toString() {
        return "Square:\n"
                + "Side length = " + length + "\n"
                + super.toString();
    }

    @Override
    public void read(BufferedReader br) throws IOException {
        String line = br.readLine();
        String numbers[] = line.split(" ");
        length = Double.parseDouble(numbers[0]);
        center[0] = Double.parseDouble(numbers[1]);
        center[1] = Double.parseDouble(numbers[2]);
        center[2] = Double.parseDouble(numbers[3]);
    }

    @Override
    public String getParameters() {
        String value = length + ",";
        value = value + center[0] + "," + center[1] + "," + center[2];
        return value;
    }
    
    @Override
     public String getType() {
         return type;
     }
    
    public double returnLength(){
    return length;
    }

}

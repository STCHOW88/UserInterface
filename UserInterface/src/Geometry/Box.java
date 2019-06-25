package Geometry;

import java.io.BufferedReader;
import java.io.IOException;

public class Box extends Geom3D {

    protected double length;
    protected double width;
    protected double height;
    protected String type;

    public Box() {
        length = 1.0;
        width = length;
        height = length;
        name = "Box";
    }

    public Box(double length) {
        this.length = length;
        width = length;
        height = length;
        name = "Box";
    }

    public Box(double length, double width) {
        this.length = length;
        this.width = width;
        height = 1.0;
        name = "Box";
    }

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;

        name = "Box";
    }

    public Box(String name, double length, double width, double height, double[] center) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.center = center;
        type = "Box";
    }

    @Override
    public double computeArea() {
        return 6 * length * width;
    }

    @Override
    public double computeVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return "Box:\n"
                + "Length = " + length + "\n"
                + "Width = " + width + "\n"
                + "Height = " + height + "\n"
                + super.toString();
    }

    @Override
    public void read(BufferedReader br) throws IOException {
        String line = br.readLine();
        String numbers[] = line.split(", ");
        name = numbers[0];
        length = Double.parseDouble(numbers[1]);
        width = Double.parseDouble(numbers[2]);
        height = Double.parseDouble(numbers[3]);
        center[0] = Double.parseDouble(numbers[4]);
        center[1] = Double.parseDouble(numbers[5]);
        center[2] = Double.parseDouble(numbers[6]);
    }

    @Override
    public String getParameters() {
        String value = name + ", " + length + ", " + width + ", " + height + ",";
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
        return width;
    }

    public double returnHeight() {
        return height;
    }
    public float[] getDimension(){
        float[] d = new float[3];
        d[0] = (float) length;
        d[1] = (float) width;
        d[2] = (float) height;
        return d;
    }
}

package Geometry;

import java.io.BufferedReader;
import java.io.IOException;

public class Cylinder extends Geom3D {

    private double radius;
    private double height;
    private String type;

    public Cylinder() {
        radius = 1.0;
        height = 1.0;
        name = "Cylinder";
    }

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
        name = "Cylinder";
    }

    public Cylinder(String name, double radius, double height, double[] center) {
        this.name = name;
        this.radius = radius;
        this.height = height;
        this.center = center;
        type = "Cylinder";
    }

    @Override
    public double computeArea() {
        return 2.0 * Math.PI * radius * height + 2 * Math.PI * radius * radius;
    }

    @Override
    public double computeVolume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return "Cylinder:\n"
                + "Radius = " + radius + "\n"
                + "Height = " + height + "\n"
                + super.toString();
    }

    @Override
    public void read(BufferedReader br) throws IOException {
        String line = br.readLine();
        String numbers[] = line.split(" ");
        radius = Double.parseDouble(numbers[0]);
        height = Double.parseDouble(numbers[1]);
        center[0] = Double.parseDouble(numbers[2]);
        center[1] = Double.parseDouble(numbers[3]);
        center[2] = Double.parseDouble(numbers[4]);
    }

    @Override
    public String getParameters() {
        String value = radius + "," + height + ",";
        value = value + center[0] + "," + center[1] + "," + center[2];
        return value;
    }
    
    @Override
     public String getType() {
         return type;
     }

    public float[] getDimension() {
        float[] d = new float[2];
        d[0] = (float) radius;
        d[2] = (float) height;
        return d;
    }

}

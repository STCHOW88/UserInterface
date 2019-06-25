package Geometry;

import java.io.BufferedReader;
import java.io.IOException;

public class Cone extends Geom3D {

    protected double radius;
    protected double height;
    protected String type;

    public Cone() {
        this.radius = 1.0;
        this.height = 1.0;
        name = "Cone";
    }

    public Cone(double length, double height) {
        this.radius = radius;
        this.height = height;
        name = "Cone";
    }

    public Cone(String name, double radius, double height, double[] center) {
        this.name = name;
        this.radius = radius;
        this.height = height;
        this.center = center;
        type = "Cone";
    }

    @Override
    public double computeArea() {
        return Math.PI * radius * (radius + Math.sqrt(radius * radius + height * height));
    }

    @Override
    public double computeVolume() {
        return Math.PI / 3 * (radius * radius * height);
    }

    @Override
    public String toString() {
        return "Cone:\n"
                + "radius = " + radius + "\n"
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

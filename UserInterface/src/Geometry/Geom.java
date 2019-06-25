package Geometry;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Geom implements Relatable {

    // Common data
    protected String name = null;
    protected double[] center = new double[3];

    // Abstract functions
    public abstract double computeArea();

    public abstract double computeVolume();

    public abstract void read(BufferedReader br) throws IOException;

    public abstract String getParameters();

    // Common functions
    /**
     * Set the position of the center of geometry
     *
     * @param position x, y, z coordinates of the center
     */
    public void getLocation(double[] position) {
        if (position == null || position.length != 3) {
            System.out.println("Not a valid position");
            return;
        }
        center = position;
    }

    /**
     * Get the name of the class
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    public void printDescription() {
        System.out.println("\nGeometry = " + name);
        System.out.println("Area = " + computeArea());
        System.out.println("Volume = " + computeVolume());
        System.out.println("Center located at: (" + center[0] + ", " + center[1] + ", " + center[2] + ")");
    }

    @Override
    public String toString() {
        return "Center = (" + center[0] + ", " + center[1] + ", " + center[2] + ")\n"
                + "Area = " + computeArea() + "\n"
                + "Volume = " + computeVolume() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Geom)) {
            return false;
        }
        Geom geom = (Geom) obj;
        return geom.name.equalsIgnoreCase(this.name) && geom.computeVolume() == this.computeVolume();
    }

    @Override
    public int isLargerThan(Relatable other) {
        Geom otherGeom = (Geom) other;
        if (this.computeVolume() < otherGeom.computeVolume()) {
            return -1;
        } else if (this.computeVolume() == otherGeom.computeVolume()) {
            return 0;
        } else {
            return 1;
        }
    }

    public String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double[] getLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

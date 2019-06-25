package Geometry;

public abstract class Geom2D extends Geom {

    protected double thickness = 1.0;

    @Override
    public double computeVolume() {
        return thickness * computeArea();
    }
}

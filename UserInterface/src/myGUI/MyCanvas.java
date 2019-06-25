/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myGUI;

import Geometry.*;
import java.awt.*;
import javax.swing.JPanel;
import java.util.ArrayList;

/**
 *
 * @author harry
 */
public class MyCanvas extends Canvas {

    private ArrayList shapes;
    private int index;
    double center[];
    boolean indexProvided = false;

    public MyCanvas() {
    }

    public MyCanvas(ArrayList shapes2) {
        shapes = shapes2;
        index = shapes.size()-1;
    }
    
    public MyCanvas(ArrayList shapes2, int i){
        indexProvided = true;
        shapes = shapes2;
        index = i;
    }

    private void updateIndex(){
        if(indexProvided == false){
            index = shapes.size()-1;
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        updateIndex();
        indexProvided = false;
        try {
            if (!shapes.isEmpty()) {
                Geom shape = (Geom) shapes.get(index);
                center = shape.getLocation();
                String type = (String) shape.getType();
                switch (type) {
                    case "Rectangle":
                        Geometry.Rectangle rect = (Geometry.Rectangle) shape;
                        g.fillRect((int) center[0] + 200, (int) center[1] + 150, (int) rect.returnLength(), (int) rect.returnWidth());
                        break;
                    case "Circle":
                        Circle circ = (Circle) shape;
                        g.fillOval((int) center[0] + 200, (int) center[1] + 150, (int) circ.returnRadius(), (int) circ.returnRadius());
                        break;
                    case "Square":
                        Square sq = (Square) shape;
                        g.fillRect((int) center[0] + 200, (int) center[1] + 150, (int) sq.returnLength(), (int) sq.returnLength());
                        break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Error");
        }

    }
}

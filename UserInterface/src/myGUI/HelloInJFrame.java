/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myGUI;


import Geometry.Box;
import Geometry.Cone;
import Geometry.Cylinder;
import Geometry.Geom;
import Geometry.Sphere;
import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeCanvasContext;
import java.awt.Canvas;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelloInJFrame extends SimpleApplication {
   
    protected final Canvas cnvs;
    private CustomCam customCam = null;
    private final AmbientLight ambient = new AmbientLight();
    private final DirectionalLight light1 = new DirectionalLight();
    private Geom shape;
    
    public HelloInJFrame() {
        Logger.getLogger("").setLevel(Level.SEVERE);
        AppSettings newSetting = new AppSettings(true);
        newSetting.setFrameRate(30);
        setSettings(newSetting);
        createCanvas(); // create canvas!
        startCanvas();
        JmeCanvasContext ctx = (JmeCanvasContext) getContext();
        ctx.setSystemListener(this);
        cnvs = ctx.getCanvas();
        setPauseOnLostFocus(false);
    } // end of Constructor

    public HelloInJFrame(Geom shape) {
        Logger.getLogger("").setLevel(Level.SEVERE);
        AppSettings newSetting = new AppSettings(true);
        newSetting.setFrameRate(30);
        setSettings(newSetting);
        createCanvas(); // create canvas!
        startCanvas();
        JmeCanvasContext ctx = (JmeCanvasContext) getContext();
        ctx.setSystemListener(this);
        cnvs = ctx.getCanvas();
        setPauseOnLostFocus(false);
        this.shape = shape;
    } // end of Constructor

    @Override
    public void simpleInitApp() {
        customCam = new CustomCam(cam);
        if (customCam != null) {
            flyCam.setEnabled(false);
            customCam.registerWithInput(inputManager);
            customCam.setZoomSpeed(10f);
            customCam.setRotationSpeed(10f);
            customCam.setMoveSpeed(3f);
            customCam.setDistance(10.0f);
        }
        setDisplayStatView(false); // to hide the statistics
        setDisplayFps(false);
        
        ambient.setColor(new ColorRGBA(0.7f, 0.7f, 0.8f, 1.0f));
        rootNode.addLight(ambient);
        // Set up the directional light
        light1.setColor(ColorRGBA.White);
        rootNode.addLight(light1);
        
        createSceneGraph();
        
    }
    
    //==========================================================================
    /* Use the main event loop to trigger repeating actions. */
    private final Quaternion camQ = new Quaternion();

    @Override
    public void simpleUpdate(float tpf) {
        light1.setDirection(
                new Vector3f(
                        cam.getDirection().x, 
                        cam.getDirection().y, 
                        cam.getDirection().z));
        camQ.lookAt(cam.getLocation(), cam.getUp());
    } // simpleUpdate()
    
    
    private void addBox() {
        Box box = (Box) shape;
        float[] dims = new float[3];
        float[] center = new float[3];
        int i;
        for(i = 0; i<3; i++){
            dims[i] = (float)box.getDimension()[i];
            center[i] = (float)box.getLocation()[i];
        }
        com.jme3.scene.shape.Box box1 = new com.jme3.scene.shape.Box(dims[0], dims[1], dims[2]);
        Geometry g = new Geometry ("Box", box1);
        g.setLocalTranslation(new Vector3f(center[0], center[1], center[2]));
        Material mat1 = new Material(assetManager,
                "Common/MatDefs/Light/Lighting.j3md");
        mat1.setBoolean("UseMaterialColors", true);
        mat1.setColor("Ambient", ColorRGBA.Blue);
        g.setMaterial(mat1);

        Node pivot = new Node("pivot");
        rootNode.attachChild(pivot); // put this node in the scene

        /** Attach the two boxes to the *pivot* node. (And transitively to the root node.) */
        pivot.attachChild(g);
        /** Rotate the pivot node: Note that both boxes have rotated! */
        pivot.rotate(.4f,.4f,0f);
        
        pivot.setLocalScale(0.3f);
        com.jme3.math.Vector3f lookAt = new com.jme3.math.Vector3f(1, 1, 1);
        customCam.setLookAt(lookAt);
    }
    
    private void addCone() {
        Cone cone = (Cone) shape;
        float[] dims = new float[2];
        float[] center = new float[3];
        int i;
        for(i = 0; i<2; i++){
            dims[i] = (float)cone.getDimension()[i];
        }
        for(i = 0; i<3; i++){
            center[i] = (float)cone.getLocation()[i];
        }
        com.jme3.scene.shape.Dome cone1 = new com.jme3.scene.shape.Dome((int)dims[1], 20, dims[0]);
        Geometry c = new Geometry ("Cone", cone1);
        c.setLocalTranslation(new Vector3f(center[0], center[1], center[2]));
        Material mat1 = new Material(assetManager,
                "Common/MatDefs/Light/Lighting.j3md");
        mat1.setBoolean("UseMaterialColors", true);
        mat1.setColor("Ambient", ColorRGBA.Blue);
        c.setMaterial(mat1);

        Node pivot = new Node("pivot");
        rootNode.attachChild(pivot); // put this node in the scene

        /** Attach the two boxes to the *pivot* node. (And transitively to the root node.) */
        pivot.attachChild(c);
        /** Rotate the pivot node: Note that both boxes have rotated! */
        pivot.rotate(.4f,.4f,0f);
        
        pivot.setLocalScale(0.3f);
        com.jme3.math.Vector3f lookAt = new com.jme3.math.Vector3f(1, 1, 1);
        customCam.setLookAt(lookAt);
    }
    
    private void addSphere() {
        Sphere cone = (Sphere) shape;
        float[] dims = new float[1];
        float[] center = new float[3];
        int i;
        for(i = 0; i<1; i++){
            dims[i] = (float)cone.getDimension()[i];
        }
        for(i = 0; i<3; i++){
            center[i] = (float)cone.getLocation()[i];
        }
        com.jme3.scene.shape.Sphere sphere1 = new com.jme3.scene.shape.Sphere(10, 10, dims[0]);
        Geometry c = new Geometry ("Sphere", sphere1);
        c.setLocalTranslation(new Vector3f(center[0], center[1], center[2]));
        Material mat1 = new Material(assetManager,
                "Common/MatDefs/Light/Lighting.j3md");
        mat1.setBoolean("UseMaterialColors", true);
        mat1.setColor("Ambient", ColorRGBA.Blue);
        c.setMaterial(mat1);

        Node pivot = new Node("pivot");
        rootNode.attachChild(pivot); // put this node in the scene

        /** Attach the two boxes to the *pivot* node. (And transitively to the root node.) */
        pivot.attachChild(c);
        /** Rotate the pivot node: Note that both boxes have rotated! */
        pivot.rotate(.4f,.4f,0f);
        
        pivot.setLocalScale(0.3f);
        com.jme3.math.Vector3f lookAt = new com.jme3.math.Vector3f(1, 1, 1);
        customCam.setLookAt(lookAt);
    }
    
    private void addCylinder() {
        Cylinder cylinder = (Cylinder) shape;
        float[] dims = new float[2];
        float[] center = new float[3];
        int i;
        for(i = 0; i<2; i++){
            dims[i] = (float)cylinder.getDimension()[i];
        }
        for(i = 0; i<3; i++){
            center[i] = (float)cylinder.getLocation()[i];
        }
        com.jme3.scene.shape.Cylinder cylinder1 = new com.jme3.scene.shape.Cylinder(20, 20, dims[0], dims[1]);
        Geometry c = new Geometry ("Cylinder", cylinder1);
        c.setLocalTranslation(new Vector3f(center[0], center[1], center[2]));
        Material mat1 = new Material(assetManager,
                "Common/MatDefs/Light/Lighting.j3md");
        mat1.setBoolean("UseMaterialColors", true);
        mat1.setColor("Ambient", ColorRGBA.Blue);
        c.setMaterial(mat1);

        Node pivot = new Node("pivot");
        rootNode.attachChild(pivot); // put this node in the scene

        /** Attach the two boxes to the *pivot* node. (And transitively to the root node.) */
        pivot.attachChild(c);
        /** Rotate the pivot node: Note that both boxes have rotated! */
        pivot.rotate(.4f,.4f,0f);
        
        pivot.setLocalScale(0.3f);
        com.jme3.math.Vector3f lookAt = new com.jme3.math.Vector3f(1, 1, 1);
        customCam.setLookAt(lookAt);
    }
    
    private void createSceneGraph(){
        
        String type = shape.getType();
        switch(type){
            case "Box":
                 addBox();
                 break;
            case "Cone":
                addCone();
                break;
            case "Sphere":
                addSphere();
                break;
            case "Cylinder":
                addCylinder();
                break;
        }
        
    }
    
    
}
    


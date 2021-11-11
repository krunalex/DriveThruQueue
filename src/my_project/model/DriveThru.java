package my_project.model;

import java.util.LinkedList;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.swing.text.View;
import java.util.Queue;

public class DriveThru extends GraphicalObject {

    private ViewController viewController;

    public DriveThru(double x, double y, double width, double height, ViewController viewController){
        this.viewController = viewController;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        viewController.draw(this);
    }

    /**
     * Zeichnet den DriveThru
     * @param drawTool f&uuml;r die draw Methoden ben&ouml;tigt
     */
    @Override
    public void draw (DrawTool drawTool){
        drawTool.drawFilledRectangle(x-100,y,width,height);
        drawTool.drawFilledRectangle(x+50,y,width,height);
        drawTool.drawRectangle(x-100,y,width*10,height-185);
        drawTool.drawRectangle(x+100,y+80,width+45,height-80);
        drawTool.drawFilledRectangle(x+114,y+95,width+20,height-160);
    }
}

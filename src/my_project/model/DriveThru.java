package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class DriveThru extends GraphicalObject {

    public DriveThru(){
    }

    public void draw (DrawTool drawTool){
        drawTool.drawFilledRectangle(100,200,15,200);
        drawTool.drawFilledRectangle(250,200,15,200);
        drawTool.drawRectangle(100,200,150,15);
    }
}

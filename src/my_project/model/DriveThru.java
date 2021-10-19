package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.Queue;

public class DriveThru extends GraphicalObject {

    private Queue myQueue;

    public DriveThru(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw (DrawTool drawTool){
        drawTool.drawFilledRectangle(x-100,y,width,height);
        drawTool.drawFilledRectangle(x+50,y,width,height);
        drawTool.drawRectangle(x-100,y,width*10,height-185);
    }

    // Muss benutzt werden wenn das Auto den Drive Thru erreicht
    public void anstellen(Auto myAuto, Queue myQueue){
        System.out.println("Willkommen, wir bitten um ihre Bestellung, Nummer: " + myAuto.getNummer());
        myQueue.enqueue(myAuto);
    }

    // Wenn auf den Knopf (den wir noch programmieren müssen) gedrückt wurde, wird diese Methode aufgerufen
    public void bedienen(Auto myAuto, Queue myQueue){
        System.out.println("Folgendes Auto wurde bedient, Nummer: " + myAuto.getNummer());
        System.out.println("Bestellt wurde: " + myAuto.getBestellung());
        myQueue.dequeue();
        myAuto.setBedient(true);
    }

}

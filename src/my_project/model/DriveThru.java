package my_project.model;

import java.util.LinkedList;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import java.util.Queue;

public class DriveThru extends GraphicalObject {

    private Queue<Auto> queue = new LinkedList<Auto>();

    public DriveThru(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Zeichnet den DriveThru
     * @param drawTool f&uuml;r die draw Methoden ben&ouml;tigt
     */
    public void draw (DrawTool drawTool){
        drawTool.drawFilledRectangle(x-100,y,width,height);
        drawTool.drawFilledRectangle(x+50,y,width,height);
        drawTool.drawRectangle(x-100,y,width*10,height-185);
    }

    /**
     * F&uuml;gt das &uuml;bergebene Auto zu der Queue hinzu und gibt etwas in die Konsole aus
     * @param auto das auto das zur Queue hinzugef&uuml;gt wird
     */
    public void anstellen(Auto auto){
        System.out.println("Willkommen, wir bitten um ihre Bestellung, Nummer: " + auto.getNummer());
        queue.add(auto);
    }

    /**
     * Bei dem &uuml;bergebenen Auto wird der boolean bedient auf true gesetzt. + Gibt etwas in der Konsole aus
     * @param auto das auto bei dem bedient auf true gesetz wird
     */
    public void bedienen(Auto auto){
        System.out.println("Folgendes Auto wurde bedient, Nummer: " + auto.getNummer());
        System.out.println("Bestellt wurde: " + auto.getBestellung());
        auto.setBedient(true);
    }

    /**
     * Ruft f&uuml;r alle Autos in der Queue bewegeAuto auf
     * @param dt Z&auml;hlt Zeit
     */
    public void bewegeAutos(double dt){
        for(Auto item : queue)
            item.bewegeAuto(dt);
    }

    /**
     * Ruft f&uuml;r alle Autos in der Queue stop auf
     */
    public void stopAutos(){
        for(Auto item : queue)
            item.stop();
    }

    /**
     * Ruft f&uuml;r alle Autos in der Queue start auf
     */
    public void startAutos(){
        for(Auto item : queue)
            item.start();
    }

    public Queue<Auto> getQueue() {
        return queue;
    }
}

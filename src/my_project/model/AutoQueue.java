package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class AutoQueue extends GraphicalObject {

    private ViewController viewController;
    private AutoQueue previousQueueAuto;
    public String bestellung;
    private int nummer;
    private boolean arrived;
    private boolean deleted;

    public AutoQueue(double x, double y, AutoQueue previousQueueAuto, ViewController viewController) {
        this.x = x;
        this.y = y;
        this.previousQueueAuto = previousQueueAuto;
        this.viewController = viewController;
        this.nummer = randomNummer();
        bestellung = randomBestellung();
        arrived = false;
        deleted = false;
        viewController.draw(this);
    }

    /**
     * Zeichnet die Autos
     * @param drawTool f&uuml;r die draw Methoden ben&ouml;tigt
     */
    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawText(x+20,y-60,"Nr. " + nummer + ", Bestellung: " + bestellung);
        drawTool.drawRectangle(x,y,150,60);
        drawTool.drawRectangle(x+35,y-50,90,50);
        drawTool.drawRectangle(x+35,y-50,20,50);
        drawTool.drawFilledCircle(x+20, y+70, 20);
        drawTool.drawFilledCircle(x+130, y+70, 20);
    }

    /**
     * Generiert eine zuf&auml;llige Zahl, basierend auf dieser Zahl wird String bestellung auf etwas gesetzt
     * @return bestellung - gibt den wert zur&uuml;ck auf den bestellung gerade gesetzt wurde
     */
    public String randomBestellung() {
        int zufallsZahl = (int) (Math.random() * 3 + 1);

        if (zufallsZahl == 1) bestellung = "Burger";
        if (zufallsZahl == 2) bestellung = "Pizza";
        if (zufallsZahl == 3) bestellung = "Salat";

        return bestellung;
    }

    public int randomNummer() {
        int nummer = (int) (Math.random() * 99 + 1);
        return nummer;
    }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previousQueueAuto == null || x > previousQueueAuto.getX()+200) x -= 100*dt;
            if (x < 410) arrived = true;
        }
        if(deleted){
            x -= 200*dt;
            if(x < -200) viewController.removeDrawable(this);
        }
    }

    public boolean tryToDelete(){
        if(arrived){
            deleted = true;
            return deleted;
        }
        return false;
    }
}
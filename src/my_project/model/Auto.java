package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.view.ProgramController;

public class Auto extends GraphicalObject {

    private final int nummer;
    private String bestellung;
    private boolean bedient;
    private boolean bewegtSich;
    private boolean imDriveThru;

    public Auto (int nummer, String bestellung, int x, int y){
        randomBestellung();
        this.x = x;
        this.y = y;
        this.nummer = nummer;
        this.bestellung = randomBestellung();
        bewegtSich = true;
        imDriveThru = false;
    }

    public boolean isBewegtSich() {
        return bewegtSich;
    }

    public int getNummer() {
        return nummer;
    }

    public String getBestellung() {
        return bestellung;
    }

    public void setBedient(boolean bedient) {
        this.bedient = bedient;
    }

    public void setImDriveThru(boolean imDriveThru) {
        this.imDriveThru = imDriveThru;
    }

    public boolean isImDriveThru() {
        return imDriveThru;
    }

    public boolean isBedient() {
        return bedient;
    }

    /**
     * Generiert eine zuf&auml;llige Zahl, basierend auf dieser Zahl wird String bestellung auf etwas gesetzt
     * @return bestellung - gibt den wert zur&uuml;ck auf den bestellung gerade gesetzt wurde
     */
    public String randomBestellung() {
        int zufallsZahl = (int) (Math.random() * 3 + 1);

        if (zufallsZahl == 1) {
            bestellung = "Burger";
        }
        if (zufallsZahl == 2) {
            bestellung = "Pizza";
        }
        if (zufallsZahl == 3) {
            bestellung = "Salat";
        }
        return bestellung;
    }

    /**
     * Zeichnet die Autos
     * @param drawTool f&uuml;r die draw Methoden ben&ouml;tigt
     */
    public void draw(DrawTool drawTool){
        drawTool.drawText(x+20,y-60,"Nr. " + nummer + ", Bestellung: " + bestellung);
        drawTool.drawRectangle(x,y,150,60);
        drawTool.drawRectangle(x+35,y-50,90,50);
        drawTool.drawRectangle(x+35,y-50,20,50);
        drawTool.drawFilledCircle(x+20, y+70, 20);
        drawTool.drawFilledCircle(x+130, y+70, 20);
    }

    /**
     * Sorgt daf&uuml;r, dass das Auto sich mit 60 Pixel pro Sekunde nach links bewegt, sofern die Methode durchgehend aufgerufen wird und bewegtSich true ist
     * @param dt Z&auml;hlt Zeit
     */
    public void bewegeAuto(double dt){
        if(bewegtSich){
            x = x - (dt * 60);
        }
    }

    /**
     * Setzt bewegtSich auf false, wodurch das Auto aufhört sich zu bewegen, auch wenn bewegeAuto aufgerufen wird
     */
    public void stop(){
        if(!bedient) bewegtSich = false;
    }

    /**
     * Setzt bewegtSich auf true, wodurch sich das Auto wieder weiter bewegt, falls bewegtSich vorher auf false war
     */
    public void start(){
        bewegtSich = true;
    }
}
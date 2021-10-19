package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.view.ProgramController;

public class Auto extends GraphicalObject {

    private int nummer;
    private String bestellung;
    private boolean bedient;

    public Auto (int nummer, String bestellung, int x, int y){
        randomBestellung();
        this.x = x;
        this.y = y;
        this.nummer = nummer;
        this.bestellung = randomBestellung();
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

    public void draw(DrawTool drawTool){
        drawTool.drawText(x+20,y-60,"Nr. " + nummer + ", Bestellung: " + bestellung);
        drawTool.drawRectangle(x,y,150,60);
        drawTool.drawRectangle(x+35,y-50,90,50);
        drawTool.drawRectangle(x+35,y-50,20,50);
        drawTool.drawFilledCircle(x+20, y+70, 20);
        drawTool.drawFilledCircle(x+130, y+70, 20);
    }

    public void update(double dt) {
        x = x - dt * 60;
    }
}


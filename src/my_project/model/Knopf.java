package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.KeyEvent;

public class Knopf extends GraphicalObject {

    private ViewController viewController;
    private Auto auto;

    public Knopf(Auto auto, ViewController viewController){
        this.viewController = viewController;
        this.auto = auto;
    }

    /**
     * Zeichnet den Knopf
     * @param drawTool f&uuml;r die draw Methoden ben&ouml;tigt
     */
    public void draw(DrawTool drawTool){
        drawTool.drawRectangle(102,75,160,45);
        drawTool.drawText(141,92, "Drücke Space:");
        drawTool.drawText(117,108, "Bestellung abschließen");
    }

    public void bestellungAbschließen(){
        if(viewController.isKeyDown(KeyEvent.VK_SPACE)){
            auto.start();
        }
    }
}

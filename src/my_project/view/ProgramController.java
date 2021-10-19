package my_project.view;

import KAGO_framework.control.DatabaseController;
import KAGO_framework.control.Drawable;
import KAGO_framework.control.ViewController;
import my_project.model.Auto;
import my_project.model.DriveThru;
import java.awt.event.MouseEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    // Referenzen
    private ViewController viewController;// diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private DriveThru firstDriveThru;
    private Auto firstAuto;
    private Auto secondAuto;
    private Auto thirdAuto;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Achtung: funktioniert nicht im Szenario-Modus
     */
    public void startProgram() {
        firstDriveThru = new DriveThru(200,200,15,200);
        viewController.draw(firstDriveThru);

        firstAuto = new Auto(1, "" , 400 ,300);
        viewController.draw(firstAuto);

        secondAuto = new Auto(2,"", 600 ,300);
        viewController.draw(secondAuto);

        thirdAuto = new Auto(3, "", 800 ,300);
        viewController.draw(thirdAuto);
    }

    /**
     * Sorgt dafür, dass zunächst gewartet wird, damit der SoundController die
     * Initialisierung abschließen kann. Die Wartezeit ist fest und damit nicht ganz sauber
     * implementiert, aber dafür funktioniert das Programm auch bei falscher Java-Version
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
        if(firstAuto.collidesWith(firstDriveThru)){
            firstAuto.setX(500);
        }
    }


    /**
     * Verarbeitet einen Mausklick.
     * @param e das Objekt enthält alle Informationen zum Klick
     */
    public void mouseClicked(MouseEvent e){

    }
}

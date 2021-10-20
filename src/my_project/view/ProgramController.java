package my_project.view;

import KAGO_framework.control.ViewController;
import my_project.model.Auto;
import my_project.model.DriveThru;
import my_project.model.Knopf;

import java.awt.event.MouseEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    // Referenzen
    private final ViewController viewController;// diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private DriveThru driveThru;
    private Knopf knopf;
    private Auto firstAuto;
    private Auto secondAuto;
    private Auto thirdAuto;
    private Auto fourthAuto;
    private Auto fifthAuto;

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
        driveThru = new DriveThru(200,200,15,200);
        viewController.draw(driveThru);

        firstAuto = new Auto(1, "", 400, 300);
        viewController.draw(firstAuto);
        driveThru.anstellen(firstAuto);

        secondAuto = new Auto(2, "", 600, 300);
        viewController.draw(secondAuto);
        driveThru.anstellen(secondAuto);

        thirdAuto = new Auto(3, "", 800, 300);
        viewController.draw(thirdAuto);
        driveThru.anstellen(thirdAuto);

        fourthAuto = new Auto(4,"",1000,300);
        viewController.draw(fourthAuto);
        driveThru.anstellen(fourthAuto);

        fifthAuto = new Auto(5, "", 1200, 300);
        viewController.draw(fifthAuto);
        driveThru.anstellen(fifthAuto);

        knopf = new Knopf(driveThru, viewController);
        viewController.draw(knopf);
    }

    /**
     * Sorgt dafür, dass zunächst gewartet wird, damit der SoundController die
     * Initialisierung abschließen kann. Die Wartezeit ist fest und damit nicht ganz sauber
     * implementiert, aber dafür funktioniert das Programm auch bei falscher Java-Version
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
        driveThru.bewegeAutos(dt);
        for(Auto item : driveThru.getQueue()) {
            if (item.collidesWith(driveThru) && !item.isBedient()) {
                driveThru.stopAutos();
                item.setImDriveThru(true);
                knopf.bestellungAbschliessen();
            } else {
                item.setImDriveThru(false);
            }
            if(item.getX() < -150){
                item.setX(1150);
                item.setBedient(false);
            }
        }
    }


    /**
     * Verarbeitet einen Mausklick.
     * @param e das Objekt enthält alle Informationen zum Klick
     */
    public void mouseClicked(MouseEvent e){
    }
}

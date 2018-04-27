package threads;

import program.JFrameGUI;

import javax.swing.*;

public class BridgeThread extends Thread {

    public BridgeThread(JFrameGUI jFrameGUI) {
        this.jFrameGUI = jFrameGUI;
    }

    private JFrameGUI jFrameGUI;


    // odczyt danych z pliku


    // ustawianie semafora, zmianę kolorów świateł
    private void switchLights() {
        jFrameGUI.switchLights();
    }

    // zapis danych do pliku

    public void run() {
        while (true) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {

                    //zmienianie swiatel
                    switchLights();
                }
            });

            try {
                this.sleep(2500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
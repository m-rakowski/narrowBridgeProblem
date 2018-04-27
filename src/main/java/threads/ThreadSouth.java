package threads;

import program.JFrameGUI;
import program.Utilities;

public class ThreadSouth extends Thread {

    private JFrameGUI jFrameGUI;

    public ThreadSouth(JFrameGUI jFrameGUI) {
        this.jFrameGUI = jFrameGUI;
    }


    public void run() {
        while (true) {
            try {
                sleep(Integer.parseInt(Utilities.loadFromPropertiesFile("SOUTHERN_CARS_SPEED")));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (jFrameGUI.southernTrafficLightIsGreen()) {
                jFrameGUI.letOneSouthernCarGo();
            }
        }
    }
}
package threads;

import program.JFrameGUI;
import program.Utilities;

public class ThreadNorth extends Thread {

    private JFrameGUI jFrameGUI;

    public ThreadNorth(JFrameGUI jFrameGUI) {
        this.jFrameGUI = jFrameGUI;
    }


    public void run() {
        while (true) {
            try {
                sleep(Integer.parseInt(Utilities.loadFromPropertiesFile("NORTHERN_CARS_SPEED")));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (jFrameGUI.northernTrafficLightIsGreen()) {
                jFrameGUI.letOneNorthernCarGo();
            }
        }
    }
}
package threads;

import program.JFrameGUI;

public class ThreadNorth extends Thread {

    private JFrameGUI jFrameGUI;

    public ThreadNorth(JFrameGUI jFrameGUI) {
        this.jFrameGUI = jFrameGUI;
    }

    // sprawdzać ustawienie semafora oraz przepuszczać pojazdy, gdy otrzymają zezwolenie.
    private void checkLights() {
        if(jFrameGUI.northernTrafficLightIsGreen()){
            letOneCarGo();

        }

    }

    private void letOneCarGo() {
    }


}

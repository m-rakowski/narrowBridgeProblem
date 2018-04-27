package threads;

import program.JFrameGUI;
import program.Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BridgeThread extends Thread {
    private JFrameGUI jFrameGUI;

    public BridgeThread(JFrameGUI jFrameGUI) {
        this.jFrameGUI = jFrameGUI;
    }

    // odczyt danych z pliku
    public void loadTrafficLightsAndCarsInitialSetupFromConfigFile(){

        String path = Utilities.loadFromPropertiesFile("PATH_TO_CONFIG");

        String[] records = new String[1000];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            for (int i = 0; (line = reader.readLine()) != null; i++) {
                records[i] = line;
            }
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", path);
            e.printStackTrace();
            throw new IllegalArgumentException();
        }

        jFrameGUI.setNumberOfCarsNorth(Integer.parseInt(records[0]));
        jFrameGUI.setNumberOfCarsSouth(Integer.parseInt(records[1]));

        for(String chunk: records[2].split(", ")){
            if("NORTH".equalsIgnoreCase(chunk.split(": ")[0])) {
                if("GREEN".equalsIgnoreCase(chunk.split(": ")[1])){
                    jFrameGUI.setNorthernTrafficLightToGreen();
                } else if("RED".equalsIgnoreCase(chunk.split(": ")[1])){
                    jFrameGUI.setNorthernTrafficLightToRed();
                } else {
                    jFrameGUI.tellUserConfigIsWrongAndQuit();
                }
            }

            if("SOUTH".equalsIgnoreCase(chunk.split(": ")[0])) {
                if("GREEN".equalsIgnoreCase(chunk.split(": ")[1])){
                    jFrameGUI.setSouthernTrafficLightToGreen();
                } else if("RED".equalsIgnoreCase(chunk.split(": ")[1])){
                    jFrameGUI.setSouthernTrafficLightToRed();
                } else {
                    jFrameGUI.tellUserConfigIsWrongAndQuit();
                }
            }
        }

    }

    // ustawianie semafora, zmianę kolorów świateł
    private void switchLights() {

        System.out.println("BridgeThread: Switching lights");
        jFrameGUI.switchLights();
    }

    // zapis danych do pliku

    public void run() {
        loadTrafficLightsAndCarsInitialSetupFromConfigFile();


        while (true) {
            try {
                sleep(1000 * Integer.parseInt(Utilities.loadFromPropertiesFile("LIGHTS_CHANGE_EVERY_X_SECONDS")));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switchLights();
        }
    }
}
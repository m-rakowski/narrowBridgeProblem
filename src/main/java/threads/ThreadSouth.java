package threads;//Wątek most powinien implementować metody, odpowiadające za odczyt danych z pliku
//        tekstowego, ustawianie semafora, zmianę kolorów świateł oraz zapis danych do pliku.

import program.JFrameGUI;

public class ThreadSouth extends Thread {

    private JFrameGUI jFrameGUI;

    public ThreadSouth(JFrameGUI jFrameGUI) {
        this.jFrameGUI = jFrameGUI;
    }

    // sprawdzać ustawienie semafora oraz przepuszczać pojazdy, gdy otrzymają zezwolenie.
    private void checkLights() {
    }

}

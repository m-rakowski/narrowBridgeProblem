package program;

import java.util.ResourceBundle;

public class Utilities {

    public static String loadFromPropertiesFile(String propertyName) {
        ResourceBundle rb = ResourceBundle.getBundle("config");
        return rb.getString(propertyName);
    }


}

package program;

import java.util.ResourceBundle;

public class Utils {

    public static String loadFromPropertiesFile(String propertyName) {
        ResourceBundle rb = ResourceBundle.getBundle("config");
        return rb.getString(propertyName);
    }
}

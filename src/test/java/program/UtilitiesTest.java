package program;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UtilitiesTest {

    @Test()
    public void should_returnPropertyPATH_TO_CONFIG_When_Called() {
        String path_to_config_file = Utilities.loadFromPropertiesFile("PATH_TO_CONFIG");

        Assert.assertEquals(path_to_config_file, "config.txt");
    }

}
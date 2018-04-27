import org.testng.Assert;
import org.testng.annotations.Test;
import program.Utils;

public class JFrameGUITest {

    @Test()
    public void should_returnPropertyPATH_TO_CONFIG_When_Called() {
        String path_to_config_file = Utils.loadFromPropertiesFile("PATH_TO_CONFIG");

        Assert.assertEquals(path_to_config_file, "config.txt");

    }
}
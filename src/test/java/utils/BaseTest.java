package utils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        //Configuration.headless = true;
    }
}

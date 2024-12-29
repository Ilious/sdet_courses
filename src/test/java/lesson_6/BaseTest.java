package lesson_6;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    void initBeforeClass() {
        Configuration.baseUrl = "https://www.simbirsoft.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30_000;
    }
}

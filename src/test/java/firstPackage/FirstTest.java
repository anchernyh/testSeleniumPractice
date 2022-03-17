package firstPackage;

import helper.TestBase;
import org.junit.jupiter.api.Test;

public class FirstTest extends TestBase {

    @Test
    public void firstTest() {
        fillNameSurnameMail();
        driver.close();
    }
}


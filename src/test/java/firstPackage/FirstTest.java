package firstPackage;

import helper.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

public class FirstTest extends TestBase {

    @Test
    public void firstTest() {

        driver.get("https://demoqa.com/");
        String name = "Anastasiia";
        String surname = "Test";
        String mail = "name@mail.ua";
        driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div/div[2]/div/div")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forms'])[2]/following::span[1]")).click();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(name);
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(surname);
        driver.findElement(By.id("userEmail")).click();
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys(mail);
        driver.close();

    }

}


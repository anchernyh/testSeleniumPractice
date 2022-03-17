package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.jsoup.helper.Validate.fail;

public class TestBase {
    protected static WebDriver driver;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    @BeforeEach
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = ((Alert) alert).getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    protected void fillNameSurnameMail() {
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
    }
}

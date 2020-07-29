package Tests;

import Base.PageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestsSetup {

    WebDriver driver;
    Base.PageObjects PageObjects;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageObjects=new PageObjects(driver);
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}

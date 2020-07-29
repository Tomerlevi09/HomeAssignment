package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BaseMethods {

    public WebDriver driver;
    public WebDriverWait wait;

    public BaseMethods(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public String getURL() {
        return driver.getCurrentUrl();
    }
    public void clickOnElement(By elements) {
        driver.findElement(elements).click();
    }

    public void sendKeysToElement(By elements, String text) {
        driver.findElement(elements).sendKeys(text);
    }

    public String getTabName() {
        return driver.getTitle();
    }

    public String getURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }
    public void waitForElementToBeVisable(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementToBeClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public int countOfElements(By element, int expectedCountOfElements) {
        wait.until(ExpectedConditions.numberOfElementsToBe(element, expectedCountOfElements));
        List<WebElement> list = driver.findElements(element);
        return list.size();
    }


    }

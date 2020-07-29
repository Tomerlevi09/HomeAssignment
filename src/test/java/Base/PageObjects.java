package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class PageObjects extends BaseMethods {
    public PageObjects(WebDriver driver) {
        super(driver);
    }

    String webSiteTitle = "הירולו - חברת פיתוח מובילה המתמחה בפתרונות פרונט אנד";
    String name = "tomer";
    String email = "tomerg12tm7@gmail.com";
    String phone = "0504567412";
    String expectedURL = "https://automation.herolo.co.il/thank-you/";
    String urlWhatsApp = "https://api.whatsapp.com/send?phone=972544945333";
    String expectedFacebookURL = "https://www.facebook.com/Herolofrontend";
    String company = "tomertest";
    String windowsHandle;
    int expectedProjectsNumber = 4;
    int actualNumberOfProjects = 4;
    int numberOfProjects;

    By submitFooterButton= By.cssSelector("button[class^='Footer__Button']");
    By nameField = By.cssSelector("footer input[name='name']");
    By emailField = By.cssSelector("footer input[name='email']");
    By phoneField = By.cssSelector("footer input[name='phone']");
    By jugglingId = By.id("juggling");
    By backbtn = By.cssSelector("a[href='/']");

    By whatsAppLink = By.xpath("//a[starts-with(@class,'callUsWhatsapp')]");
    By projectsImages = By.xpath("//div[@data-index and @aria-hidden='false']//img[@alt='Project image']");
    By faceBookLink = By.cssSelector("a[href='https://www.facebook.com/Herolofrontend']");

    By nameBottom = By.id("name");
    By emailBottom = By.id("email");
    By phoneBottom = By.id("telephone");
    By companyBottom = By.id("company");
    By submitBottom = By.xpath("//a[@type='button']");
    By backBtnBottom = By.cssSelector("a[href='/frontend-developers/']");

    public void getWebSite(String siteURL) {
        driver.get(siteURL);
    }

    public void testTabName() {
        assertEquals(getTabName(), webSiteTitle);
    }

    public void testWhatsAppLink() {
        windowsHandle = driver.getWindowHandle();
        waitForElementToBeClickable(whatsAppLink);
        clickOnElement(whatsAppLink);
        Set<String> handle = driver.getWindowHandles();
        for (String windowHandle : handle) {
            driver.switchTo().window(windowHandle);
        }
        assertEquals(getURL(), urlWhatsApp);
        driver.switchTo().window(windowsHandle);
    }

    public void testFaceBookLink() {
        windowsHandle = driver.getWindowHandle();
        clickOnElement(faceBookLink);
        Set<String> handle = driver.getWindowHandles();
        for (String windowHandle : handle) {
            driver.switchTo().window(windowHandle);
        }
        assertEquals(getURL(driver), expectedFacebookURL);
        driver.switchTo().window(windowsHandle);
    }

    public void sendFooterFormFields() {
        sendKeysToElement(nameField, name);
        sendKeysToElement(emailField, email);
        sendKeysToElement(phoneField, phone);
        clickOnElement(submitFooterButton);
        waitForElementToBeVisable(jugglingId);
        assertEquals(getURL(), expectedURL);
        clickOnElement(backbtn);
    }

    public void testNumberOfProjects() {
        numberOfProjects = countOfElements(projectsImages, expectedProjectsNumber);
        assertEquals(numberOfProjects, actualNumberOfProjects);
    }

    public void sendBottomFormFields() {
        sendKeysToElement(nameBottom, name);
        sendKeysToElement(emailBottom, email);
        sendKeysToElement(phoneBottom, phone);
        sendKeysToElement(companyBottom, company);
        clickOnElement(submitBottom);
        waitForElementToBeVisable(jugglingId);
        assertEquals(getURL(), expectedURL);
        clickOnElement(backBtnBottom);
    }
}

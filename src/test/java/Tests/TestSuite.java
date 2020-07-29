package Tests;
import org.testng.annotations.Test;

public class TestSuite extends TestsSetup{
    String siteURL = "https://automation.herolo.co.il/";

    @Test(priority = 1, description = "Open the web site")
    public void openWebSite() {
        PageObjects.getWebSite(siteURL);
    }

    @Test(priority = 2, description = "Verify the tab name")
    public void verifyTile() {
        PageObjects.testTabName();
    }

    @Test(priority = 3, description = "Test the footer form")
    public void testFooterForm() {
        PageObjects.sendFooterFormFields();
    }

    @Test(priority = 4, description = "Test whatsApp link")
    public void testwhatAppLink() {
        PageObjects.testWhatsAppLink();
    }
    @Test(priority = 5, description = "Test FaceBook Link")
    public void testFaceBookLink() {
        PageObjects.testFaceBookLink();
    }

    @Test(priority = 6, description = "Test the number of projects")
    public void numberOfProjects() {
        PageObjects.testNumberOfProjects();
    }

    @Test(priority = 7 , description = "Test the form at the bottom of the page")
    public void testBottomForm() {
        PageObjects.sendBottomFormFields();
    }
}

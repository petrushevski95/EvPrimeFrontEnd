import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.UrlConfig.BASE_URL;

public class ContactPageTests {
    // CAN NOT ASSERT THE VALIDATION MESSAGES (CODE NOT OPTIMIZED)

    private WebDriver driver;
    private ContactPage contactPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        contactPage = new ContactPage(driver);
        contactPage.clickContactButton();
    }

    @After
    public void closeDriver() { //cannot assert validation message
        driver.quit();
    }

    @Test
    public void successfulReachOutTest() {
        contactPage.enterFullName("Test full name");
        contactPage.enterEmail("test@gmail.com");
        contactPage.enterMessage("Test message");
        contactPage.clickSendButton();
        assertTrue(contactPage.isOnTheContactPage());

    }

    @Test
    public void unsuccessfulReachOutEmptyFullNameFieldTest() throws InterruptedException {
        contactPage.enterEmail("test@gmail.com");
        contactPage.enterMessage("Test message");
        contactPage.clickSendButton();
        assertEquals("#304ffe",contactPage.getFullNameBottomBorderColor());
    }

    @Test
    public void unsuccessfulReachOutEmptyEmailFieldTest() {
        contactPage.enterFullName("Test full name");
        contactPage.enterMessage("Test message");
        contactPage.clickSendButton();
        assertEquals("#304ffe",contactPage.getEmailBottomBorderColor());
    }

    @Test
    public void unsuccessfulReachOutInvalidEmailFormat1Test() throws InterruptedException {
        contactPage.enterFullName("Test full name");
        contactPage.enterEmail("testmail.com");
        contactPage.clickSendButton();
        assertEquals("#d32f2f",contactPage.getEmailBottomBorderColor());
    }

    @Test
    public void unsuccessfulReachOutInvalidEmailFormat2Test() throws InterruptedException {
        contactPage.enterFullName("Test full name");
        contactPage.enterEmail("@mail.com");
        contactPage.clickSendButton();
        assertEquals("#304ffe",contactPage.getEmailBottomBorderColor());
    }

    @Test
    public void unsuccessfulReachOutEmptyMessageFieldTest() throws InterruptedException {
        contactPage.enterFullName("Test full name");
        contactPage.enterEmail("test@mail.com");
        contactPage.clickSendButton();
        assertEquals("#304ffe",contactPage.getMessageBottomBorderColor());
    }
}

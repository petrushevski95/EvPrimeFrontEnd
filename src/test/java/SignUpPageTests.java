
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignUpPage;
import static org.junit.Assert.*;


public class SignUpPageTests {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://localhost:3000/auth?mode=login");

        signUpPage = new SignUpPage(driver);
        signUpPage.clickCreateUserButton();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void successfulSignupTest() {
        signUpPage.enterEmail(RandomStringUtils.randomAlphanumeric(8) + "@mail.com");
        signUpPage.enterPassword("test12345");
        signUpPage.clickGoButton();
        assertTrue(signUpPage.isOnTheHomePage());
        assertFalse(signUpPage.isSignUpFormDisplayed());
    }

    @Test
    public void unsuccessfulSignupInvalidEmailFormatValidPasswordTest() {
        signUpPage.enterEmail(RandomStringUtils.randomAlphanumeric(8) + "mail.com");
        signUpPage.enterPassword("test12345");
        signUpPage.clickGoButton();
        assertEquals("Invalid email.",signUpPage.invalidEmailMessageText());
    }

    @Test
    public void unsuccessfulSignupInvalidEmailFormatInvalidPasswordTest() {
        signUpPage.enterEmail(RandomStringUtils.randomAlphanumeric(8) + "mail.com");
        signUpPage.enterPassword("tes");
        signUpPage.clickGoButton();
        assertEquals("Invalid email.",signUpPage.invalidEmailMessageText());
        assertEquals("Invalid password. Must be at least 6 characters long.",signUpPage.invalidPasswordMessageText());
    }

    @Test
    public void unsuccessfulSignupExistingEmailTest() {
        signUpPage.enterEmail("test@gmail.com");
        signUpPage.enterPassword("test12345");
        signUpPage.clickGoButton();
        assertEquals("Email exists already.",signUpPage.existingEmailMessageText());
    }

    @Test
    public void unsuccessfulSignupExistingEmailInvalidPasswordTest() {
        signUpPage.enterEmail("test@gmail.com");
        signUpPage.enterPassword("tes");
        signUpPage.clickGoButton();
        assertEquals("Email exists already.",signUpPage.existingEmailMessageText());
        assertEquals("Invalid password. Must be at least 6 characters long.",signUpPage.invalidPasswordMessageText());
    }

    @Test
    public void unsuccessfulSignupValidEmailInvalidPasswordTest() {
        signUpPage.enterEmail(RandomStringUtils.randomAlphanumeric(8) + "@mail.com");
        signUpPage.enterPassword("tes");
        signUpPage.clickGoButton();
        assertEquals("Invalid password. Must be at least 6 characters long.",signUpPage.invalidPasswordValidMailText());
    }

    @Test
    public void loginButton() {
        signUpPage.clickLogInButton();
        assertTrue(signUpPage.isOnTheLoginPage());
    }
}

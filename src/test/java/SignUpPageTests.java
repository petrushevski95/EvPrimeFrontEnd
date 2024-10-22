
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SignUpPage;
import static org.junit.Assert.*;
import static utils.UrlConfig.BASE_URL;


public class SignUpPageTests {

    private WebDriver driver;
    private SignUpPage signUpPage;
    private LoginPage loginPage;

    @Before
    public void setUp () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(BASE_URL);

        loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();

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
        assertTrue(signUpPage.isInvalidEmailMessageDisplayed());
        assertEquals("Invalid email.",signUpPage.invalidEmailMessageText());
        assertTrue(signUpPage.isUserValidationErrorMessageDisplayed());
        assertEquals("User signup failed due to validation errors.",signUpPage.userValidationErrorMessageText());
    }

    @Test
    public void unsuccessfulSignupInvalidEmailFormatInvalidPasswordTest() {
        signUpPage.enterEmail(RandomStringUtils.randomAlphanumeric(8) + "mail.com");
        signUpPage.enterPassword("tes");
        signUpPage.clickGoButton();
        assertTrue(signUpPage.isInvalidEmailMessageDisplayed());
        assertEquals("Invalid email.",signUpPage.invalidEmailMessageText());
        assertTrue(signUpPage.isInvalidPasswordMessageDisplayed());
        assertEquals("Invalid password. Must be at least 6 characters long.",signUpPage.invalidPasswordMessageText());
        assertTrue(signUpPage.isUserValidationErrorMessageDisplayed());
        assertEquals("User signup failed due to validation errors.",signUpPage.userValidationErrorMessageText());
    }

    @Test
    public void unsuccessfulSignupExistingEmailTest() {
        signUpPage.enterEmail("test@gmail.com");
        signUpPage.enterPassword("test12345");
        signUpPage.clickGoButton();
        assertTrue(signUpPage.isExistingEmailMessageDisplayed());
        assertEquals("Email exists already.",signUpPage.existingEmailMessageText());
        assertTrue(signUpPage.isUserValidationErrorMessageDisplayed());
        assertEquals("User signup failed due to validation errors.",signUpPage.userValidationErrorMessageText());
    }

    @Test
    public void unsuccessfulSignupExistingEmailInvalidPasswordTest() {
        signUpPage.enterEmail("test@gmail.com");
        signUpPage.enterPassword("tes");
        signUpPage.clickGoButton();
        assertTrue(signUpPage.isExistingEmailMessageDisplayed());
        assertEquals("Email exists already.",signUpPage.existingEmailMessageText());
        assertTrue(signUpPage.isInvalidPasswordMessageDisplayed());
        assertEquals("Invalid password. Must be at least 6 characters long.",signUpPage.invalidPasswordMessageText());
        assertTrue(signUpPage.isUserValidationErrorMessageDisplayed());
        assertEquals("User signup failed due to validation errors.",signUpPage.userValidationErrorMessageText());
    }

    @Test
    public void unsuccessfulSignupValidEmailInvalidPasswordTest() {
        signUpPage.enterEmail(RandomStringUtils.randomAlphanumeric(8) + "@mail.com");
        signUpPage.enterPassword("tes");
        signUpPage.clickGoButton();
        assertTrue(signUpPage.isInvalidPasswordValidMailMessageDisplayed());
        assertEquals("Invalid password. Must be at least 6 characters long.",signUpPage.invalidPasswordValidMailText());
        assertTrue(signUpPage.isUserValidationErrorMessageDisplayed());
        assertEquals("User signup failed due to validation errors.",signUpPage.userValidationErrorMessageText());
    }

    @Test
    public void loginButton() {
        signUpPage.clickLogInButton();
        assertEquals("CREATE USER",signUpPage.getLoginButtonText());
        assertEquals("Log in",signUpPage.loginUserTitleTextPage());
        assertTrue(signUpPage.isOnTheLoginPage());
    }
}

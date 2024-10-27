
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SliderMenu;

import static org.junit.Assert.*;

public class LoginPageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private SliderMenu sliderMenu;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        sliderMenu = new SliderMenu(driver);
        sliderMenu.goToHomePage();

//        signUpPage = new SignUpPage(driver);
//        signUpPage.enterEmail(RandomStringUtils.randomAlphanumeric(8) + "mail.com");
//        signUpPage.enterPassword("test12345");
//        signUpPage.clickGoButton();  this needs to happen before every test and deleted after executing the test (database do not recognize the registered users)

        loginPage.clickLoginButton();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickGoButton();
        assertTrue(loginPage.isOnTheHomePage());
        Thread.sleep(500);
        assertFalse(loginPage.isSignUpFormDisplayed());
        assertTrue(loginPage.isHoverButtonDisplayed());
    }

    @Test
    public void unsuccessfulLoginInvalidEmailTest() {
        loginPage.enterEmail("testgmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickGoButton();
        assertEquals("Authentication failed.", loginPage.authenticationFailedMessage());
    }

    @Test
    public void unsuccessfulLoginValidEmailInvalidPasswordTest() {
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test12345");
        loginPage.clickGoButton();
        assertTrue(loginPage.isInvalidEmailOrInvalidPasswordMessageDisplayed());
        assertEquals("Invalid email or password entered.", loginPage.invalidEmailOrInvalidPasswordMessageText());
        assertTrue(loginPage.isInvalidCredentialsMessageDisplayed());
        assertEquals("Invalid credentials.", loginPage.invalidCredentialsMessageText());
    }

    @Test
    public void createUserButtonTest() {
        loginPage.clickCreateUserButton();
        assertEquals("LOG IN", loginPage.getCreateUserButtonText());
        assertEquals("Create new user", loginPage.createNewUserTitlePageText());
        assertTrue(loginPage.isOnTheSignUpPage());
    }
}

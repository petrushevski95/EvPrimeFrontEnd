import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SliderMenu;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utils.UrlConfig.BASE_URL;

public class SliderMenuTests {

    private WebDriver driver;
    private SliderMenu sliderMenu;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(BASE_URL);

        sliderMenu = new SliderMenu(driver);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void sliderMenuCloseButtonTest() {
        sliderMenu.clickSliderMenuButton();
        assertTrue(sliderMenu.isSliderMenuDisplayed());
        assertTrue(sliderMenu.isHomeButtonTextDisplayed());
        assertTrue(sliderMenu.isEventsButtonTextDisplayed());
        assertTrue(sliderMenu.isContactButtonTextDisplayed());
        assertTrue(sliderMenu.isLoginButtonTextDisplayed());
        sliderMenu.closeSliderMenu();
        assertFalse(sliderMenu.isSliderMenuDisplayed());
    }

    @Test
    public void homeButtonTest() {
        sliderMenu.goToEventsPage();
        sliderMenu.clickHomeButton();
        assertTrue(sliderMenu.isOnTheHomePage());
    }

    @Test
    public void  eventsButtonTest() {
        sliderMenu.clickEventsButton();
        assertTrue(sliderMenu.isOnTheEventsPage());
    }

    @Test
    public void contactButtonTest() {
        sliderMenu.clickContactButton();
        assertTrue(sliderMenu.isOnTheContactPage());
    }

    @Test
    public void loginButtonTest() {
        sliderMenu.clickLoginButton();
        assertTrue(sliderMenu.isOnTheLoginPage());
    }

}

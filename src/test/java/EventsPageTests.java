
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EventsPage;
import pages.LoginPage;
import pages.SliderMenu;

import static org.junit.Assert.*;


public class EventsPageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private EventsPage eventsPage;
    private SliderMenu sliderMenu;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        sliderMenu = new SliderMenu(driver);
        loginPage = new LoginPage(driver);
        eventsPage = new EventsPage(driver);

        sliderMenu.goToHomePage();
        loginPage.clickLoginButton();
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickGoButton();
    }

    @After
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void createAnEventButtonTest() throws InterruptedException {
        eventsPage.goToEventsPage();
        eventsPage.hoverOverThePlusButton();
        assertTrue(eventsPage.isDisplayedCreateEventButton());
        eventsPage.clickCreateAnEventButton();
        assertTrue(eventsPage.isOnTheCreateNewEventPage());
    }

}

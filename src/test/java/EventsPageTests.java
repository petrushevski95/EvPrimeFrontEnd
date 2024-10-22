import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EventsPage;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;
import static utils.UrlConfig.BASE_URL;

public class EventsPageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private EventsPage eventsPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        eventsPage = new EventsPage(driver);

        loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickGoButton();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void createAnEventButtonTest() throws InterruptedException {
        eventsPage.hoverOverThePlusButton();
        assertTrue(eventsPage.isDisplayedCreateEventButton());
        eventsPage.clickCreateEventButton();
        assertTrue(eventsPage.isOnTheCreateNewEventPage());
    }


}

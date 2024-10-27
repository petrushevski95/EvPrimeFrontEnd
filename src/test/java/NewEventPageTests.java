import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NewEventPageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private EventsPage eventsPage;
    private SliderMenu sliderMenu;
    private NewEventPage newEventPage;
    private EventPage eventPage;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        sliderMenu = new SliderMenu(driver);
        loginPage = new LoginPage(driver);
        eventsPage = new EventsPage(driver);
        newEventPage = new NewEventPage(driver);
        eventPage = new EventPage(driver);

        sliderMenu.goToHomePage();
        loginPage.clickLoginButton();
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickGoButton();
        eventsPage.hoverOverThePlusButton();
        eventsPage.clickCreateAnEventButton();
    }

    @After
    public void closeDriver() {
        eventPage.clickDeleteButton();
        eventPage.clickConfirmDeleteButton();
        driver.quit();
    }

    @Test
    public void successfulCreateAnEventTest() throws InterruptedException {
        newEventPage.enterTitle("Test title 2024");
        newEventPage.enterImage("https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516_640.jpg");
        newEventPage.enterDate("10.25.2024");
        newEventPage.enterLocation("Test location 2024");
        Thread.sleep(3000);
//        eventsPage.enterDescription("test"); selectors do not work for this field tried everything
        newEventPage.clickCreateEventButton();
        eventsPage.selectLastCreatedEvent();
        assertTrue(eventPage.isOnTheEventPage());
        assertEquals("Test title 2024",eventPage.getEventTitle());
        assertTrue(eventPage.isEventTitleDisplayed());
        assertEquals("10.25.2024",eventPage.getEventDate());
        assertTrue(eventPage.isEventDateDisplayed());
        assertEquals("Test location 2024",eventPage.getEventLocation());
        assertTrue(eventPage.isEventLocationDisplayed());
        assertEquals("https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516_640.jpg",eventPage.getCreatedEventImage());
        assertTrue(eventPage.isEventImageDisplayed());
        assertEquals("test",eventPage.getEventDescription());
        assertTrue(eventPage.isEventDescriptionDisplayed());
    }

}

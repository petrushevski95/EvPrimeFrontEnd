import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.*;

public class EventPageTests {

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
        eventPage = new EventPage(driver);
        newEventPage = new NewEventPage(driver);

        sliderMenu.goToHomePage();
        loginPage.clickLoginButton();
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickGoButton();
        eventsPage.hoverOverThePlusButton();
        eventsPage.clickCreateAnEventButton();
        newEventPage.enterTitle("Test title 2024");
        newEventPage.enterImage("https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516_640.jpg");
        newEventPage.enterDate("10.25.2024");
        newEventPage.enterLocation("Test location 2024");
        Thread.sleep(3000);
        newEventPage.clickCreateEventButton();
        eventsPage.selectLastCreatedEvent();
    }

    @After
    public void closeDriver() {


        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void clickOnEvent() throws InterruptedException {
        assertTrue(eventPage.isOnTheEventPage());
    }

    @Test
    public void displayedEventInformationOnTheEventPage() {
        assertEquals("Test title 2024", eventPage.getEventTitle());
        assertTrue(eventPage.isEventTitleDisplayed());
        assertEquals("10.25.2024", eventPage.getEventDate());
        assertTrue(eventPage.isEventDateDisplayed());
        assertEquals("Test location 2024", eventsPage.getEventLocation());
        assertTrue(eventPage.isEventLocationDisplayed());
        assertEquals("https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516_640.jpg", eventPage.getCreatedEventImage());
        assertTrue(eventPage.isEventUpdatedImageDisplayed());
        assertEquals("test", eventPage.getEventDescription());
    }

    @Test
    public void successfulDeleteAnEvent() {
        eventPage.clickDeleteButton();
        assertEquals("Are you sure you want to delete this event?",eventPage.getDeleteMessageText());
        assertTrue(eventPage.isWindowWithDeleteMessageDisplayed());
        assertTrue(eventPage.isConfirmDeleteButtonDisplayed());
        assertTrue(eventPage.isNoButtonDisplayed());
        eventPage.clickConfirmDeleteButton();
        assertTrue(eventPage.isOnTheEventsPage());
        assertFalse(eventPage.isEventDisplayed());
    }

    @Test
    public void unsuccessfulDeleteAnEvent() throws InterruptedException {
        eventPage.clickDeleteButton();
        assertEquals("Are you sure you want to delete this event?",eventPage.getDeleteMessageText());
        assertTrue(eventPage.isWindowWithDeleteMessageDisplayed());
        assertTrue(eventPage.isConfirmDeleteButtonDisplayed());
        assertTrue(eventPage.isNoButtonDisplayed());
        eventPage.clickNoButton();
        assertTrue(eventPage.isOnTheEventPage());
    }

    @Test
    public void editButtonTest() throws InterruptedException {
        eventPage.clickEditButton();
        assertTrue(eventPage.isOnTheEditEventPage());
    }

    @Test
    public void backToEventsButtonTest() {
        eventPage.clickBackToEvents();
        assertTrue(eventPage.isOnTheEventsPage());

    }

    @Test
    public void updateEventButton() throws InterruptedException {
        eventPage.clickEditButton();
        eventPage.clearTitleField();
        eventPage.enterTitle("New test title 2024");
        eventPage.clearLocationField();
        eventPage.enterLocation("New test location 2024");
        eventPage.clickUpdateButton();
        assertTrue(eventPage.isOnTheEventPage());
        assertEquals("New test title 2024", eventPage.getEventTitle());
        assertTrue(eventPage.isEventTitleDisplayed());
        assertEquals("New test location 2024", eventPage.getEventLocation());
    }
}

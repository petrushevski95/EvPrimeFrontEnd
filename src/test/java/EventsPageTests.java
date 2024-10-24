import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EventsPage;
import pages.LoginPage;

import static org.junit.Assert.*;
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
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void successfulCreateAnEventTest() throws InterruptedException {
        eventsPage.hoverOverThePlusButton();
        assertTrue(eventsPage.isDisplayedCreateEventButton());
        eventsPage.clickCreateAnEventButton();
        assertTrue(eventsPage.isOnTheCreateNewEventPage());
        eventsPage.enterTitle("Test title 2024");
        eventsPage.enterImage("https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516_640.jpg");
        eventsPage.enterDate("10.25.2024");
        eventsPage.enterLocation("Test location 2024");
        Thread.sleep(3000);
//        eventsPage.enterDescription("test"); selectors do not work for this field tried everything
        eventsPage.clickCreateEventButton();
        eventsPage.selectLastCreatedEvent();
        assertTrue(eventsPage.isOnTheEventPage());
        assertEquals("Test title 2024",eventsPage.getEventTitle());
        assertTrue(eventsPage.isEventTitleDisplayed());
        assertEquals("10.25.2024",eventsPage.getEventDate());
        assertTrue(eventsPage.isEventDateDisplayed());
        assertEquals("Test location 2024",eventsPage.getEventLocation());
        assertTrue(eventsPage.isEventLocationDisplayed());
        assertEquals("https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516_640.jpg",eventsPage.getCreatedEventImage());
        assertTrue(eventsPage.isEventImageDisplayed());
        assertEquals("test",eventsPage.getEventDescription());
        assertTrue(eventsPage.isEventDescriptionDisplayed());
    }

    @Test
    public void successfulUpdateAnEventTest() throws InterruptedException {
        eventsPage.clickEventsButton();
        eventsPage.selectLastCreatedEvent();
        assertTrue(eventsPage.isOnTheEventPage());
        eventsPage.clickEditButton();
        eventsPage.clearTitleField();
        eventsPage.enterTitle("New test title 2024");
        eventsPage.clearLocationField();
        eventsPage.enterLocation("New test location 2024");
        eventsPage.clickUpdateButton();
        assertTrue(eventsPage.isOnTheEventPage());
        assertEquals("New test title 2024", eventsPage.getEventTitle());
        assertTrue(eventsPage.isEventTitleDisplayed());
//        assertEquals("10.25.2024", eventsPage.getEventDate());
//        assertTrue(eventsPage.isEventDateDisplayed());
        assertEquals("New test location 2024", eventsPage.getEventLocation());
        assertTrue(eventsPage.isEventLocationDisplayed());
//        assertEquals("https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516_640.jpg", eventsPage.getCreatedEventImage());
//        assertTrue(eventsPage.isEventUpdatedImageDisplayed());
//        assertEquals("test", eventsPage.getEventDescription());
    }

    @Test
    public void successfulDeleteAnEventTest () throws InterruptedException {
        eventsPage.clickEventsButton();
        eventsPage.selectLastCreatedEvent();
        assertTrue(eventsPage.isOnTheEventPage());
//        assertEquals("New test title 2024", eventsPage.getEventTitle());
//        assertTrue(eventsPage.isEventTitleDisplayed());
//        assertEquals("10.25.2024", eventsPage.getEventDate());
//        assertTrue(eventsPage.isEventDateDisplayed());
//        assertEquals("New test location 2024", eventsPage.getEventLocation());
//        assertTrue(eventsPage.isEventLocationDisplayed());
//        assertEquals("https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516_640.jpg", eventsPage.getCreatedEventImage());
//        assertTrue(eventsPage.isEventUpdatedImageDisplayed());
//        assertEquals("test", eventsPage.getEventDescription());
        eventsPage.clickDeleteButton();
        assertEquals("Are you sure you want to delete this event?",eventsPage.getDeleteMessageText());
        assertTrue(eventsPage.isWindowWithDeleteMessageDisplayed());
        assertTrue(eventsPage.isConfirmDeleteButtonDisplayed());
        assertTrue(eventsPage.isNoButtonDisplayed());
        eventsPage.clickConfirmDeleteButton();
        assertTrue(eventsPage.isOnTheEventsPage());
        assertFalse(eventsPage.isEventDisplayed());
    }

}

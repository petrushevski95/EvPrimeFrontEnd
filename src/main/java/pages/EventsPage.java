package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static utils.UrlConfig.CREATE_NEW_EVENT_PAGE_URL;

public class EventsPage extends BasePage{

    private final By hoverButton = By.cssSelector(".MuiSpeedDial-fab");
    private final By createEventButton = By.cssSelector(".MuiSpeedDialAction-fab");

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverThePlusButton() {
        waitForVisibility(hoverButton, Duration.ofSeconds(1));
        hoverOverElement(hoverButton);
    }

    public boolean isDisplayedCreateEventButton() {
        return isDisplayed(createEventButton);
    }

    public void clickCreateEventButton() {
        waitForVisibility(createEventButton,Duration.ofSeconds(1));
        clickElement(createEventButton);
    }

    public boolean isOnTheCreateNewEventPage() {
       return isOnThePage(CREATE_NEW_EVENT_PAGE_URL);
    }
}

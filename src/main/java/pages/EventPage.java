package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.UrlConfig.CREATE_NEW_EVENT_PAGE_URL;
import static utils.UrlConfig.EVENTS_PAGE_URL;

public class EventPage extends BasePage{

    private final By titleField = By.name("title");
    private final By locationField = By.name("location");
    private final By deleteButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/button");
    private final By confirmDeleteButton = By.xpath("/html/body/div[2]/div[3]/div/div/button[1]");
    private final By editButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[1]");
    private final By eventTitle = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/h2");
    private final By eventDate = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[2]/h6");
    private final By eventLocation = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[3]/h6");
    private final By eventDescription = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[2]/span");
    private final By updateEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");
    private final By updatedImage = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[2]/div/img");
    private final By deleteMessage = By.xpath("/html/body/div[2]/div[3]/div/h5");
    private final By noButton = By.xpath("/html/body/div[2]/div[3]/div/div/button[2]");
    private final By createdEventImage = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[2]/div/img");
    private final By backToEventsButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[2]");

    public EventPage(WebDriver driver) {
        super(driver);
    }

    public void clickBackToEvents() {
        clickElement(backToEventsButton);
    }

    public void enterTitle(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendKeysToElement(titleField,value);
    }

    public void enterLocation(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendKeysToElement(locationField,value);
    }

    public boolean isOnTheEventsPage() {
        waitForUrlToBe(EVENTS_PAGE_URL,Duration.ofSeconds(5));
        return isOnThePage(EVENTS_PAGE_URL);
    }

    public void clickDeleteButton() {
        clickElement(deleteButton);
    }

    public void clickConfirmDeleteButton () {
        clickElement(confirmDeleteButton);
    }

    public void clickEditButton() {
        clickElement(editButton);
    }

    public boolean isOnTheEventPage() throws InterruptedException {
        waitForVisibilityElement(deleteButton,Duration.ofSeconds(5));
        return isDisplayed(deleteButton);
    }

    public String getEventTitle() {
        return getText(eventTitle);
    }

    public String getEventDate() {
        return getText(eventDate);
    }

    public String getEventLocation() {
        return getText(eventLocation);
    }

    public String getEventDescription() {
        return getText(eventDescription);
    }

    public boolean isEventTitleDisplayed() {
        return isDisplayed(eventTitle);
    }

    public boolean isEventDateDisplayed() {
        return isDisplayed(eventDate);
    }

    public boolean isEventImageDisplayed() {
        return isDisplayed(createdEventImage);
    }

    public boolean isEventLocationDisplayed() {
        return isDisplayed(eventLocation);
    }

    public boolean isEventDescriptionDisplayed() {
        return isDisplayed(eventDescription);
    }

    public void clickUpdateButton() {
        clickElement(updateEventButton);
    }

    public boolean isEventUpdatedImageDisplayed(){
        return isDisplayed(updatedImage);
    }

    public String getDeleteMessageText() {
        return getText(deleteMessage);
    }

    public boolean isWindowWithDeleteMessageDisplayed() {
        return isDisplayed(deleteButton);
    }

    public boolean isConfirmDeleteButtonDisplayed() {
        return isDisplayed(confirmDeleteButton);
    }

    public boolean isNoButtonDisplayed() {
        return isDisplayed(noButton);
    }

    public boolean isEventDisplayed(){
        return isDisplayed(eventTitle);
    }

    public String getCreatedEventImage() {
        return getAttributes(createdEventImage,"src");
    }

    public void clearTitleField() {
        clearField(titleField);
    }

    public void clearLocationField() {
        clearField(locationField);
    }

    public void clickNoButton() {
        clickElement(noButton);
    }

    public boolean isOnTheEditEventPage() {
        return isDisplayed(updateEventButton);
    }


}

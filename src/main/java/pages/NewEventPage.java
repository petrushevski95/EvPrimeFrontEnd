package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewEventPage extends BasePage {

    private final By titleField = By.name("title");
    private final By imageField = By.name("image");
    private final By dateField = By.name("date");
    private final By locationField = By.name("location");
    private final By createEventButton = By.xpath("//button[contains(text(), 'Create event')]");

    public NewEventPage(WebDriver driver) {
        super(driver);
    }

    public void enterTitle(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendKeysToElement(titleField,value);
    }

    public void enterImage(String value) {
        sendKeysToElement(imageField,value);
    }

    public void enterDate(String value) {
        sendKeysToElement(dateField,value);
    }

    public void enterLocation(String value) throws InterruptedException {
        Thread.sleep(1000);
        sendKeysToElement(locationField,value);
    }

    public void clickCreateEventButton() {
        clickElement(createEventButton);
    }
}

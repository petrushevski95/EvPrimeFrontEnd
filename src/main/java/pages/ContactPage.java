package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.UrlConfig.CONTACT_PAGE_URL;

public class ContactPage extends BasePage {

    private final By contactButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[3]");
    private final By fullNameField = By.xpath("//input[@name='name']");
    private final By emailField = By.xpath("//input[@name='email']");
    private final By messageField = By.xpath("//textarea[@name='description']");
    private final By sendButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/button");
    private final By emptyFullNameFieldBottomBorderColor = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/div[1]/div");
    private final By emptyEmailFieldBottomBorderColor = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/div[2]/div");
    private final By emptyMessageFieldBottomBorderColor = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/form/div[1]/div[3]/div");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void clickContactButton() {
        clickElement(contactButton);
    }

    public void enterFullName(String value) {
        sendKeysToElement(fullNameField,value);
    }

    public void enterEmail(String value) {
        sendKeysToElement(emailField,value);
    }

    public void enterMessage(String value) {
        sendKeysToElement(messageField,value);
    }

    public void clickSendButton() {
        clickElement(sendButton);
    }

    public boolean isOnTheContactPage() {
        return isOnThePage(CONTACT_PAGE_URL);
    }

    public String getFullNameBottomBorderColor() {
        return getPseudoElementBorderColorAsHex(emptyFullNameFieldBottomBorderColor,"borderBottomColor");
    }

    public String getEmailBottomBorderColor() {
        return getPseudoElementBorderColorAsHex(emptyEmailFieldBottomBorderColor,"borderBottomColor");
    }

    public String getMessageBottomBorderColor() {
        return getPseudoElementBorderColorAsHex(emptyMessageFieldBottomBorderColor,"borderBottomColor");
    }
}

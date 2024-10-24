package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

import static utils.UrlConfig.*;

public class LoginPage extends BasePage {

    private final By emailLocator = By.name("email");
    private final By passwordLocator = By.name("password");
    private final By goButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[1]");
    private final By loginText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[1]");
    private final By hoverButton = By.xpath("//*[@id=\"root\"]/div/div[2]/button");
    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[4]");
    private final By authenticationFailedMessageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/span");
    private final By invalidPasswordOrEmailMessageText = By.xpath("//ul/li[contains(text(), 'Invalid email or password entered.')]");
    private final By invalidCredentialsMessageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/span");
    private final By createUserButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[2]");
    private final By createNewUserTitlePageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[1]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String value) {
        sendKeysToElement(emailLocator, value);
    }

    public void enterPassword(String value) {
        sendKeysToElement(passwordLocator, value);
    }

    public void clickGoButton() {
        clickElement(goButton);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public boolean isOnTheHomePage() {
        return waitForUrlToBe(LOGIN_PAGE_URL, Duration.ofSeconds(1));
    }

    public boolean isSignUpFormDisplayed() {
        return isDisplayed(loginText);
    }

    public boolean isHoverButtonDisplayed() {
        return isDisplayed(hoverButton);
    }

    public String authenticationFailedMessage() {
        return getText(authenticationFailedMessageText);
    }

    public String invalidEmailOrInvalidPasswordMessageText() {
        return getText(invalidPasswordOrEmailMessageText);
    }

    public boolean isInvalidEmailOrInvalidPasswordMessageDisplayed() {
        try {return waitForVisibilityElement(invalidPasswordOrEmailMessageText, Duration.ofSeconds(1)).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public String invalidCredentialsMessageText() {
        return getText(invalidCredentialsMessageText);
    }

    public boolean isInvalidCredentialsMessageDisplayed() {
        return isDisplayed(invalidCredentialsMessageText);
    }

    public void clickCreateUserButton() {
        clickElement(createUserButton);
    }

    public String getCreateUserButtonText(){
        return getText(createUserButton);
    }

    public String createNewUserTitlePageText () {
        return getText(createNewUserTitlePageText);
    }

    public boolean isOnTheSignUpPage() {
        return isOnThePage(SIGNUP_PAGE_URL);
    }
}



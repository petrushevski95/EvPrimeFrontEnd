package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

import static utils.UrlConfig.BASE_URL;
import static utils.UrlConfig.LOGIN_PAGE_URL;

public class SignUpPage extends BasePage {

    private final By createUserButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[2]"); // Example locator
    private final By emailLocator = By.name("email");
    private final By passwordLocator = By.name("password");
    private final By goButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[1]");
    private final By createNewUserText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[2]");
    private final By invalidEmailMessageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li");
    private final By invalidPasswordMessageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li[2]");
    private final By existingEmailMessageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li");
    private final By invalidPasswordValidMailMessageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li");
    private final By loginButton = By.xpath("//button[text()='Log In']");
    private final By userValidationErrorMessage = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/span");
    private final By loginTitlePageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[1]");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateUserButton() {
        clickElement(createUserButton);
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

    public boolean isOnTheHomePage() {
        return waitForUrlToBe(BASE_URL, Duration.ofSeconds(1));
    }

    public boolean isSignUpFormDisplayed() {
        return isDisplayed(createNewUserText);
    }

    public String invalidEmailMessageText() {
        return getText(invalidEmailMessageText);
    }

    public String invalidPasswordMessageText() {
        return getText(invalidPasswordMessageText);
    }

    public String existingEmailMessageText() {
        return getText(existingEmailMessageText);
    }

    public String invalidPasswordValidMailText() {
        return getText(invalidPasswordValidMailMessageText);
    }

    public void clickLogInButton() {
        waitForVisibility(loginButton,Duration.ofSeconds(1)).click();
    }

    public boolean isOnTheLoginPage() {
        return waitForUrlToBe(LOGIN_PAGE_URL, Duration.ofSeconds(1));
    }

    public String userValidationErrorMessageText() {
        return getText(userValidationErrorMessage);
    }

    public boolean isInvalidEmailMessageDisplayed() {
        return isDisplayed(invalidEmailMessageText);
    }

    public boolean isUserValidationErrorMessageDisplayed() {
        return isDisplayed(userValidationErrorMessage);
    }

    public boolean isInvalidPasswordMessageDisplayed() {
        return isDisplayed(invalidPasswordMessageText);
    }

    public boolean isExistingEmailMessageDisplayed() {
        return isDisplayed(existingEmailMessageText);
    }

    public boolean isInvalidPasswordValidMailMessageDisplayed() {
        return isDisplayed(invalidPasswordValidMailMessageText);
    }

    public String getLoginButtonText() {
        return getText(createUserButton);
    }

    public String loginUserTitleTextPage() {
        return getText(loginTitlePageText);
    }
}


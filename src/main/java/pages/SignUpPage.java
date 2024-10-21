package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class SignUpPage {

    private final WebDriver driver;

    private final By createUserButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[2]/button");
    private final By emailLocator = By.name("email");
    private final By passwordLocator = By.name("password");
    private final By goButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[1]");
    private final By createNewUserText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[1]");
    private final By hoverButton = By.xpath("//*[@id=\"root\"]/div/div[2]/button");
    private final By invalidEmailMessageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li");
    private final By invalidPasswordMessageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li[2]");
    private final By existingEmailMessageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li");
    private final By invalidPasswordValidMailMessageText = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul/li");
    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[2]");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateUserButton() {
        driver.findElement(createUserButton).click();
    }

    public void enterEmail(String value) {
        driver.findElement(emailLocator).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(passwordLocator).sendKeys(value);
    }

    public void clickGoButton() {
        driver.findElement(goButton).click();
    }

    public boolean isOnTheHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
        return Objects.equals(driver.getCurrentUrl(), "http://localhost:3000/");
    }

    public boolean isSignUpFormDisplayed() {
            {try {return driver.findElement(createNewUserText).isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            }
            }
        }

    public boolean isHoverButtonDisplayed () {
        return driver.findElement(hoverButton).isDisplayed();
    }

    public String invalidEmailMessageText() {
        return driver.findElement(invalidEmailMessageText).getText();
    }

    public String invalidPasswordMessageText() {
        return driver.findElement(invalidPasswordMessageText).getText();
    }

    public String existingEmailMessageText() {
        return driver.findElement(existingEmailMessageText).getText();
    }

    public String invalidPasswordValidMailText() {
        return driver.findElement(invalidPasswordValidMailMessageText).getText();
    }

    public void clickLogInButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isOnTheLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/auth?mode=login"));
        return Objects.equals(driver.getCurrentUrl(), "http://localhost:3000/auth?mode=login");
    }

}

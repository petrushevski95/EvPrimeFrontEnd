package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    protected void goTo(String value){
        driver.get(value);
    }

    protected void sendKeysToElement(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    protected boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isOnThePage(String value) {
        return Objects.equals(driver.getCurrentUrl(), value);
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected WebElement waitForVisibility(By locator, Duration duration) {
        return new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean waitForUrlToBe(String url, Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.urlToBe(url));
        return Objects.equals(driver.getCurrentUrl(), url);
    }
}



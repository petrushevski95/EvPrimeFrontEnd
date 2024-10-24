package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
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

    protected WebElement waitForVisibilityElement(By locator, Duration duration) {
        return new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForInteractiveElement(By locator, Duration duration) {
        return new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean waitForUrlToBe(String url, Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.urlToBe(url));
        return Objects.equals(driver.getCurrentUrl(), url);
    }

    protected String getPseudoElementBorderColorAsHex(By locator, String cssProperty) {
        waitForVisibilityElement(locator, Duration.ofSeconds(2));
        if (locator != null) {
            // Find the element using the locator
            WebElement element = driver.findElement(locator);
            // Execute JavaScript to get the specified CSS property of the ::after pseudo-element
            String script = "return window.getComputedStyle(arguments[0], '::after')." + cssProperty + ";";
            String pseudoElementColor = (String) ((JavascriptExecutor) driver).executeScript(script, element);
            // Convert the color to hex format
            Color color = Color.fromString(pseudoElementColor);
            return color.asHex();
        } else {
            throw new IllegalArgumentException("The provided locator is null.");
        }
    }

    protected void hoverOverElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    protected void clearField(By locator) {
        WebElement field = driver.findElement(locator);
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        field.sendKeys(Keys.BACK_SPACE);
    }

    protected String getAttributes(By locator,String attribute) {
       return driver.findElement(locator).getAttribute(attribute);
    }

    protected List<WebElement> returnElementsList(By locator){
        return driver.findElements(locator);
    }

    protected void clickTheCenterOfTheElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element,0,0).click().build().perform();
    }

}







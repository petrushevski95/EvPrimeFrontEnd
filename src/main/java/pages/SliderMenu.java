package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class SliderMenu {

    private final WebDriver driver;

    private final By sliderMenu = By.xpath("//button[contains(@class, 'MuiIconButton-root')]");
    private final By homeButtonTextSliderMenu = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/ul/li[1]/div/div[2]/span");
    private final By eventsButtonTextSliderMenu = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/ul/li[2]/div/div[2]/span");
    private final By contactButtonTextSliderMenu = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[3]/div/div[2]/span");
    private final By loginButtonTextSliderMenu = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[4]/div/div[2]/span");
    private final By sliderMenuButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/button");
    private final By homeButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[1]");
    private final By eventsButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[2]/div");
    private final By contactButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[3]");
    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[4]");

    public SliderMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSliderMenuButton() {
        driver.findElement(sliderMenu).click();
    }

    public boolean isHomeButtonTextDisplayed() {
       return driver.findElement(homeButtonTextSliderMenu).getText().equals("Home");
    }

    public boolean isEventsButtonTextDisplayed() {
        return driver.findElement(eventsButtonTextSliderMenu).getText().equals("Events");
    }

    public boolean isContactButtonTextDisplayed() {
        return driver.findElement(contactButtonTextSliderMenu).getText().equals("Contact");
    }

    public boolean isLoginButtonTextDisplayed() {
        return driver.findElement(loginButtonTextSliderMenu).getText().equals("Login");
    }

    public void closeSliderMenu() {
        driver.findElement(sliderMenuButton).click();
    }

    public boolean isSliderMenuDisplayed () {
        return driver.findElement(loginButtonTextSliderMenu).getText().equals("Login");
    }

    public void goToEventsPage() {
        driver.get("http://localhost:3000/events");
    }

    public void clickHomeButton() {
        driver.findElement(homeButton).click();
    }

    public boolean isOnTheHomePage() {
       return Objects.equals(driver.getCurrentUrl(), "http://localhost:3000/");
    }

    public void clickEventsButton() {
        driver.findElement(eventsButton).click();
    }

    public boolean isOnTheEventsPage() {
        return Objects.equals(driver.getCurrentUrl(), "http://localhost:3000/events");
    }

    public void clickContactButton () {
        driver.findElement(contactButton).click();
    }

    public boolean isOnTheContactPage() {
        return Objects.equals(driver.getCurrentUrl(), "http://localhost:3000/contact");
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isOnTheLoginPage() {
        return Objects.equals(driver.getCurrentUrl(), "http://localhost:3000/auth?mode=login");
    }







}

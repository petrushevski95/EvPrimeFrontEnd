package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private final By sliderMenu = By.xpath("//*[@id=\"root\"]/div/div[1]/header/div/button/svg/path");
    private final By homeButtonTextSliderMenu = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/ul/li[1]/div/div[2]/span");
    private final By eventsButtonTextSliderMenu = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/ul/li[2]/div/div[2]/span");
    private final By contactButtonTextSliderMenu = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[3]/div/div[2]/span");
    private final By loginButtonTextSliderMenu = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/ul/li[4]/div/div[2]/span");
    private final By closeSliderMenuButton = By.id("ChevronLeftIcon")

    public void clickSliderMenu() {
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
        driver.findElement(closeSliderMenuButton).click();
    }







}

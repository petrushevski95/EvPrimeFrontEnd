package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.UrlConfig.*;

public class SliderMenu extends BasePage{

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
        super(driver);
    }

    public void clickSliderMenuButton() {
        clickElement(sliderMenu);
    }

    public boolean isHomeButtonTextDisplayed() {
       return isDisplayed(homeButtonTextSliderMenu);
    }

    public boolean isEventsButtonTextDisplayed() {
       return isDisplayed(eventsButtonTextSliderMenu);
    }

    public boolean isContactButtonTextDisplayed() {
        return isDisplayed(contactButtonTextSliderMenu);
    }

    public boolean isLoginButtonTextDisplayed() {
        return isDisplayed(loginButtonTextSliderMenu);
    }

    public void closeSliderMenu() {
        clickElement(sliderMenuButton);
    }

    public boolean isSliderMenuDisplayed () {
        return isDisplayed(loginButtonTextSliderMenu);
    }

    public void goToEventsPage() {
        goTo(EVENTS_PAGE_URL);
    }

    public void goToHomePage() {
        goTo(BASE_URL);
    }

    public void clickHomeButton() {
        clickElement(homeButton);
    }

    public boolean isOnTheHomePage() {
       return isOnThePage(BASE_URL);
    }

    public void clickEventsButton() {
        clickElement(eventsButton);
    }

    public boolean isOnTheEventsPage() {
        return isOnThePage(EVENTS_PAGE_URL);
    }

    public void clickContactButton () {
        clickElement(contactButton);
    }

    public boolean isOnTheContactPage() {
        return isOnThePage(CONTACT_PAGE_URL);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public boolean isOnTheLoginPage() {
        return isOnThePage(LOGIN_PAGE_URL);
    }

}

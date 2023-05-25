package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private WebDriver driver;

    //кнопка «Войти в аккаунт»
    private final By loginButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg");
    //кнопка «Личный кабинет»
    private final By personalAccountButton = By.xpath(".//p[(@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет')]");
    //раздел "Булки"
    private final By breadSection = By.xpath(".//span[text()='Булки']/..");
    //раздел "Соусы"
    private final By sauceSection = By.xpath(".//span[text()='Соусы']/..");
    //раздел "Начинки"
    private final By toppingSection = By.xpath(".//span[text()='Начинки']/..");
    private final By burgerAssembleTitle = By.xpath(".//*[text()='Соберите бургер']");
    private final By profileEnterButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By accountEnterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By orderPlaceButton = By.xpath(".//button[text()='Оформить заказ']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pushLoginButtonButton() {
        driver.findElement(loginButton).click();
    }

    public void pushPersonalAccountButtonButton() {
        driver.findElement(personalAccountButton).click();
    }

    public void pushBreadSection() {
        driver.findElement(breadSection).click();
    }

    public void pushSauceSection() {
        driver.findElement(sauceSection).click();
    }

    public void pushToppingSection() {
        driver.findElement(toppingSection).click();
    }

    public boolean selectBreadSectionButton(){
        return driver.findElement(breadSection).getAttribute("class").contains("current");
    }
    public boolean selectSauceSectionButton(){
        return driver.findElement(sauceSection).getAttribute("class").contains("current");
    }
    public boolean selectToppingSectionButton(){
        return driver.findElement(toppingSection).getAttribute("class").contains("current");
    }

    public void waitingForMainPageLoading() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(burgerAssembleTitle));
    }

    public void clickOnProfileEnterButton() {
        driver.findElement(profileEnterButton).click();
    }

    public void clickOnAccountEnterButton() {
        driver.findElement(accountEnterButton).click();
    }
    public boolean orderPlaceButtonIsDisplayed() {
        return driver.findElement(orderPlaceButton).isDisplayed();
    }
}

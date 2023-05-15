package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class LoginPage {
    private WebDriver driver;

    //кнопка «Войти в аккаунт»
    private final By loginButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg");
    //кнопка «Личный кабинет»
    private final By personalAccountButton = By.xpath(".//p[(@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет')]");

    //раздел "Булки"
    private final By breadSection = By.xpath(".//span[(@class='text text_type_main-default' and text()='Булки')]");

    //раздел "Соусы"
    private final By sauceSection = By.xpath(".//span[(@class='text text_type_main-default' and text()='Соусы')]");
    //раздел "Начинки"
    private final By toppingSection = By.xpath(".//span[(@class='text text_type_main-default' and text()='Начинки')]");




    //локатор кнопки "Заказать"
    private final By orderButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void pushHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
}

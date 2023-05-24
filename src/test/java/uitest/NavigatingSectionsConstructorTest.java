package uitest;

import constans.ApiEndpoints;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;
import setup.SetUpWebDriver;

import static org.junit.Assert.assertTrue;

public class NavigatingSectionsConstructorTest {
    public WebDriver driver;
    public MainPage mainPage;
    @Before
    public void setUp() {
        driver = SetUpWebDriver.setUpWDM();
        mainPage = new MainPage(driver);
        driver.get(ApiEndpoints.BASE_URL);
    }

    @Test
    public void checkBreadSection(){
        mainPage.pushSauceSection();
        mainPage.pushBreadSection();
        assertTrue("Не выбрана вкладка булок", mainPage.selectBreadSectionButton());
    }
    @Test
    public void checkSauceSection(){
        mainPage.pushSauceSection();
        assertTrue("Не выбрана вкладка соусов", mainPage.selectSauceSectionButton());
    }

    @Test
    public void checkToppingSection(){
        mainPage.pushToppingSection();
        assertTrue("Не выбрана вкладка начинок", mainPage.selectToppingSectionButton());
    }
    @After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }
}

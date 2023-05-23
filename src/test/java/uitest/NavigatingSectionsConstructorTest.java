package uitest;
import org.junit.Test;
import pageobjects.MainPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NavigatingSectionsConstructorTest extends BaseTest{

    @Test
    public void checkBreadSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.pushSauceSection();
        mainPage.pushBreadSection();
        assertTrue("Не выбрана вкладка булок", mainPage.selectBreadSectionButton());
    }
    @Test
    public void checkSauceSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.pushSauceSection();
        assertTrue("Не выбрана вкладка соусов", mainPage.selectSauceSectionButton());
    }

    @Test
    public void checkToppingSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.pushToppingSection();
        assertTrue("Не выбрана вкладка начинок", mainPage.selectToppingSectionButton());
    }



}

package uitest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pageobjects.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigatingSectionsConstructorTest extends BaseTest{
    @Test
    public void testEqualsTextQuestionsAboutImportant(){
        MainPage mainPage = new MainPage(driver);
        mainPage.pushToppingSection();
        assertTrue("Выбрана вкладка начинок", mainPage.selectToppingSectionButton());
    }

    @Test
    public void checkBunsPass(){
        MainPage mainPage = new MainPage(driver);
        mainPage.pushBreadSection();
        assertTrue("Выбрана вкладка булок", mainPage.selectBreadSectionButton());
    }



}

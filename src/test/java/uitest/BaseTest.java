package uitest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    // локатор для кнопки принятия куки
    private final String URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void startUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/Alina/Desktop/WebDriver/bin/chromedriver_mac64/chromedriver");
//        driver = new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", "/Users/Alina/Desktop/WebDriver/bin/geckodriver");
//        driver = new FirefoxDriver();
//
         driver = new SafariDriver();
//
        //открыть страницу
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}

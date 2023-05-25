import constans.ApiEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import user.User;
import user.UserRandom;
import user.UserSteps;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;
import pageobjects.SignUpPage;
import setup.SetUpWebDriver;

public class RegistrationTest {

    public WebDriver driver;
    public SignUpPage signUpPage;
    public LoginPage loginPage;
    public static String accessToken;

    @Before
    public void setUp() {
        RestAssured.baseURI = ApiEndpoints.BASE_URL;
        driver = SetUpWebDriver.setUpWDM();
        signUpPage = new SignUpPage(driver);
        driver.get(ApiEndpoints.BASE_URL + ApiEndpoints.CREATE_USER);
        signUpPage.waitingForSignUpPageLoading();
    }
    @After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }
    @AfterClass
    public static void afterClass() {
        UserSteps.deleteUser(accessToken);
    }


    @Test
    public void signUpTest() {
        User user = UserRandom.createNewRandomUser();
        loginPage = new LoginPage(driver);
        signUpPage.insertUserSignUpData(user);
        signUpPage.clickSignUpButton();
        loginPage.waitingForLoginFormLoading();
        Assert.assertEquals("Перешли на страницу логина", ApiEndpoints.BASE_URL + ApiEndpoints.LOGIN_USER, driver.getCurrentUrl());
        Response response = UserSteps.authUser(user);
        Assert.assertEquals("Удалось залогиниться с данными созданного пользователя", 200, response.statusCode());
        accessToken = response.path("accessToken");
    }

    @Test
    public void signUpWithShortPasswordTest() {
        User user = UserRandom.createNewRandomUser();
        user.setPassword("12345");
        signUpPage.insertUserSignUpData(user);
        signUpPage.clickSignUpButton();
        Assert.assertTrue("Отображается ошибка о некорректном пароле", signUpPage.checkSignUpWrongPassword());
        Assert.assertEquals("Остались на странице логина", ApiEndpoints.BASE_URL + ApiEndpoints.CREATE_USER, driver.getCurrentUrl());
        Response response = UserSteps.authUser(user);
        Assert.assertFalse("Не удалось залогиниться с данными созданного пользователя", response.path("success"));
    }

}
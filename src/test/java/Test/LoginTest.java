package Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Pages.RestorePasswordPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static Constants.Constant.URL_HOME_PAGE;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    public final int random = 1 + (int) (Math.random() * 100000);
    private final String name = "Zalogin" + random;
    private final String email = "Zalogin+" + random + "@yandex.ru";
    private final String password = "000000";

    public WebDriver getWebDriver(boolean useFirefox) {
        if (useFirefox) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            return new FirefoxDriver(options);
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            return new ChromeDriver(options);
        }
    }

    @Before
    public void actionBefore() {
        driver = getWebDriver(false);
        driver.get(URL_HOME_PAGE);
        HomePage homePage = new HomePage(driver);
        homePage.registrationUser(name, email, password);
    }

    @After
    public void actionAfter() {
        driver.quit();
    }

    @DisplayName("Авторизация пользователя по кнопке Войти в аккаунт")
    @Description("Успешное авторизация пользователя")
    @Test
    public void userAuthorizationUsingLoginButtonTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitStartLoginPage();
        loginPage.authorizationUser(email, password);
        loginPage.clickLoginButton();

        homePage.waitStartHomePage();
        assertTrue(homePage.isOrderButtonDisplayed());
    }

    @DisplayName("Авторизация пользователя по кнопке Личный кабинет")
    @Description("Успешное авторизация пользователя")
    @Test
    public void userAuthorizationUsingPersonalAccountButtonTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitStartLoginPage();
        loginPage.authorizationUser(email, password);
        loginPage.clickLoginButton();

        homePage.waitStartHomePage();
        assertTrue(homePage.isOrderButtonDisplayed());
    }

    @DisplayName("Авторизация пользователя через страницу регистрации")
    @Description("Успешное авторизация пользователя")
    @Test
    public void userAuthorizationInRegistrationFormTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.waitStartRegisterPage();
        registerPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitStartLoginPage();
        loginPage.authorizationUser(email, password);
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(driver);
        homePage.waitStartHomePage();
        assertTrue(homePage.isOrderButtonDisplayed());
    }

    @DisplayName("Авторизация пользователя через страницу восстановление пароля")
    @Description("Успешное авторизация пользователя")
    @Test
    public void userAuthorizationUsingRestorePasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.waitStartLoginPage();
        loginPage.clickRestorePasswordButton();

        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
        restorePasswordPage.waitStartRestorePasswordPage();
        restorePasswordPage.clickRegistrationButton();

        loginPage.waitStartLoginPage();
        loginPage.authorizationUser(email, password);
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(driver);
        homePage.waitStartHomePage();
        assertTrue(homePage.isOrderButtonDisplayed());
    }
}

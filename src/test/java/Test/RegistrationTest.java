package Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RegistrationTest {

    private WebDriver driver;
    public final int random = 1 + (int) (Math.random() * 100000);

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
    }

    @After
    public void actionAfter() {
        driver.quit();
    }

    @DisplayName("Регистрация пользователя с валидными данными")
    @Description("Успешное регистрация пользователя")
    @Test
    public void successUserRegistrationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitStartHomePage();
        homePage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitStartLoginPage();
        loginPage.clickRegistrationButton();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.waitStartRegisterPage();
        registerPage.setUserData("Gena"+random,"Gena+"+random+"@yandex.ru", "000000");
        registerPage.waitClickRegistrationButton();
        registerPage.clickRegistrationButton();

        loginPage.waitStartLoginPage();
        assertTrue(loginPage.isStatusLoginHeaderDisplayed());
        }

    @DisplayName("Регистрация пользователя с невалидным паролем")
    @Description("Неудачная регистрация пользователя")
    @Test
    public void failedUserRegistrationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitStartHomePage();
        homePage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitStartLoginPage();
        loginPage.clickRegistrationButton();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.waitStartRegisterPage();
        registerPage.setUserData("Cheburashka"+random,"Cheburashka+"+random+"@yandex.ru", "00000");
        registerPage.waitClickRegistrationButton();
        registerPage.clickRegistrationButton();

        registerPage.waitErrorMessage();
        assertTrue(registerPage.isStatusErrorMessageDisplayed());
        assertEquals("Некорректный пароль", registerPage.getTextErrorMessage());
    }
}



package Test;

import Constants.Constant;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
        driver.get(Constant.URL_HOME_PAGE);
    }

    @After
    public void actionAfter() {
        driver.quit();
    }


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
        registerPage.setUserData("Cheburashka"+random,"Cheburashka+"+random+"@yandex.ru", "00");
        registerPage.waitClickRegistrationButton();
        registerPage.clickRegistrationButton();

        registerPage.waitErrorMessage();
        assertTrue(registerPage.isStatusErrorMessageDisplayed());
    }
}



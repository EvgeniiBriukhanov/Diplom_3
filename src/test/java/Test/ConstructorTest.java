package Test;

import Pages.HomePage;
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

public class ConstructorTest {
    private WebDriver driver;

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

    @DisplayName("Переход  разделу - Булки")
    @Description("Проверка, что работают переходы к разделу - Булки")
    @Test
    public void checkBunsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitStartHomePage();
        homePage.clickSauceButton();
        homePage.waitingForTheSauceSectionToAppear();
        homePage.clickBunButton();
        homePage.waitingForTheBunsSectionToAppear();
        assertTrue(homePage.isBunSectionDisplayed());
    }

    @DisplayName("Переход  разделу - Соусы")
    @Description("Проверка, что работают переходы к разделу - Соусы")
    @Test
    public void checkSauceTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitStartHomePage();
        homePage.clickSauceButton();
        homePage.waitingForTheSauceSectionToAppear();
        assertTrue(homePage.isSauceSectionDisplayed());
    }

    @DisplayName("Переход  разделу - Начинка")
    @Description("Проверка, что работают переходы к разделу - Начинка")
    @Test
    public void checkStuffingTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitStartHomePage();
        homePage.clickStuffingButton();
        homePage.waitingForTheStuffingSectionToAppear();
        assertTrue(homePage.isStuffingSectionDisplayed());
    }
}

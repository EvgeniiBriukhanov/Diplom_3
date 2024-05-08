package Test;

import Pages.HomePage;
import Resources.WebDriver;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static Constants.Constant.URL_HOME_PAGE;
import static org.junit.Assert.assertTrue;

public class ConstructorTest extends WebDriver {
    private org.openqa.selenium.WebDriver driver;

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
        homePage.clickStuffingButton();
        homePage.clickBunButton();
        assertTrue(homePage.isBunEnabled());
    }

    @DisplayName("Переход  разделу - Соусы")
    @Description("Проверка, что работают переходы к разделу - Соусы")
    @Test
    public void checkSauceTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitStartHomePage();
        homePage.clickSauceButton();
        assertTrue(homePage.isSauceEnabled());
    }

    @DisplayName("Переход  разделу - Начинка")
    @Description("Проверка, что работают переходы к разделу - Начинка")
    @Test
    public void checkStuffingTest() {
        HomePage homePage = new HomePage(driver);
        homePage.waitStartHomePage();
        homePage.clickStuffingButton();
        assertTrue(homePage.isStuffingEnabled());

    }
}

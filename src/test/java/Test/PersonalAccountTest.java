package Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PersonalAccountPage;
import Resources.WebDriver;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static Constants.Constant.URL_HOME_PAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonalAccountTest extends WebDriver {
    private org.openqa.selenium.WebDriver driver;
    public final int random = 1 + (int) (Math.random() * 100000);
    private final String name = "Zalogin" + random;
    private final String email = "Zalogin+" + random + "@yandex.ru";
    private final String password = "000000";

    @Before
    public void actionBefore() {
        driver = getWebDriver(false);
        driver.get(URL_HOME_PAGE);
        HomePage homePage = new HomePage(driver);
        homePage.registrationUser(name, email, password);
        LoginPage loginPage =new LoginPage(driver);
        loginPage.waitStartLoginPage();
        loginPage.authorizationUser(email, password);
        loginPage.waitClickLoginButton();
        loginPage.clickLoginButton();
        homePage.waitStartHomePage();
        homePage.clickPersonalAccountButton();
    }

    @After
    public void actionAfter() {
        driver.quit();
    }
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода по клику на «Личный кабинет».")
    @Test
    public void checkingTransitionClickingOnPersonalAccountTest() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.waitStartPersonalAccountPage();
        assertTrue(personalAccountPage.isStatusPersonalAccountInfoTextDisplayed());
        assertEquals("В этом разделе вы можете изменить свои персональные данные", personalAccountPage.getPersonalAccountInfoText());
    }

    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Проверка перехода по клику на Конструктор")
    @Test
    public void checkingTransitionClickingOnConstructorButtonTest(){
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.waitStartPersonalAccountPage();
        personalAccountPage.clickConstructorButton();

        HomePage homePage = new HomePage(driver);
        homePage.waitStartHomePage();
        assertTrue(homePage.isOrderButtonDisplayed());
    }

    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Проверка перехода по клику на логотип Stellar Burgers")
    @Test
    public void checkingTransitionClickingOnLogoStellarBurgersButtonTest(){
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.waitStartPersonalAccountPage();
        personalAccountPage.clickStellarBurgersButton();

        HomePage homePage = new HomePage(driver);
        homePage.waitStartHomePage();
        assertTrue(homePage.isOrderButtonDisplayed());
    }

    @DisplayName("Выход из аккаунта")
    @Description("Проверка выхода по кнопке «Выйти» в личном кабинете.")
    @Test
    public void checkingTransitionClickingOnLogoutButtonTest(){
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.waitStartPersonalAccountPage();
        personalAccountPage.clickLogoutButton();

        LoginPage loginPage =new LoginPage(driver);
        loginPage.waitStartLoginPage();
        assertTrue(loginPage.isStatusLoginHeaderDisplayed());
    }
}

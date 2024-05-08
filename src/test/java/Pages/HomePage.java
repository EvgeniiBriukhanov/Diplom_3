package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import static Constants.Constant.URL_HOME_PAGE;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By HOME_PAGE_HEADER = By.xpath("//*[text() = 'Соберите бургер']");
    private final By PERSONAL_ACCOUNT_BUTTON = By.xpath("//a[@class='AppHeader_header__link__3D_hX' and @href='/account']");
    private final By LOGIN_BUTTON = By.xpath("//*[text() = 'Войти в аккаунт']");
    private final By ORDER_BUTTON = By.className("button_button__33qZ0");
    private final By BUN_BUTTON = By.xpath("//span[text()='Булки']");
    private final By SAUCE_BUTTON = By.xpath("//span[text()='Соусы']");
    private final By STUFFING_BUTTON = By.xpath("//span[text()='Начинки']");
    private final By BUN_ENABLED_BUTTON = By.xpath("//div[(@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect') " +
            "and (span[text() = 'Булки'])]");
    private final By SAUCE_ENABLED_BUTTON = By.xpath("//div[(@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect') " +
            "and (span[text() = 'Соусы'])]");
    private final By STUFFING_ENABLED_BUTTON = By.xpath("//div[(@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect') " +
            "and (span[text() = 'Начинки'])]");


    private void clickButton(By button) {
        driver.findElement(button).isDisplayed();
        driver.findElement(button).click();
    }

    @Step("Ожидание загрузки домашней страницы")
    public void waitStartHomePage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_HEADER));
    }

    @Step("Нажатие на кнопку - Войти в аккаунт")
    public void clickLoginButton() {
        clickButton(LOGIN_BUTTON);
    }

    @Step("Нажатие на кнопку - Личный кабинет")
    public void clickPersonalAccountButton() {
        clickButton(PERSONAL_ACCOUNT_BUTTON);
    }

    @Step("Нажатие на кнопку - Войти в аккаунт")
    public void registrationUser(String name, String email, String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.waitStartRegisterPage();
        registerPage.setUserData(name, email, password);
        registerPage.waitClickRegistrationButton();
        registerPage.clickRegistrationButton();
    }

    @Step("Открыть домашнюю страницу")
    public void openHomePage() {
        driver.get(URL_HOME_PAGE);
    }

    @Step("Отображается ли кнопка - Оформить заказ")
    public boolean isOrderButtonDisplayed() {
        return driver.findElement(ORDER_BUTTON).isDisplayed();
    }

    @Step("Нажатие на кнопку - Булки")
    public void clickBunButton() {
        clickButton(BUN_BUTTON);
    }

    @Step("Нажатие на кнопку - Соусы")
    public void clickSauceButton() {
        clickButton(SAUCE_BUTTON);
    }

    @Step("Нажатие на кнопку - Начинки")
    public void clickStuffingButton() {
        clickButton(STUFFING_BUTTON);
    }
    @Step("Выбран ли таб - Булки")
    public boolean isBunEnabled() {
        return driver.findElement(BUN_ENABLED_BUTTON).isEnabled();
    }
    @Step("Выбран ли таб - Соусы")
    public boolean isSauceEnabled() {
        return driver.findElement(SAUCE_ENABLED_BUTTON).isEnabled();
    }

    @Step("Выбран ли таб - Начинка")
    public boolean isStuffingEnabled() {
        return driver.findElement(STUFFING_ENABLED_BUTTON).isEnabled();
    }
}

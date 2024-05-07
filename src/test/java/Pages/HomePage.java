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
    private final By BUN_SECTION = By.xpath("//h2[@class='text text_type_main-medium mb-6 mt-10' and text() = 'Булки']");
    private final By SAUCE_SECTION = By.xpath("//h2[@class='text text_type_main-medium mb-6 mt-10' and text() = 'Соусы']");
    private final By STUFFING_SECTION = By.xpath("//h2[@class='text text_type_main-medium mb-6 mt-10' and text() = 'Начинки']");

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
    public void clickLoginButton(){
        clickButton(LOGIN_BUTTON);
    }

    @Step("Нажатие на кнопку - Личный кабинет")
    public void clickPersonalAccountButton(){
        clickButton(PERSONAL_ACCOUNT_BUTTON);
    }
    @Step("Нажатие на кнопку - Войти в аккаунт")
    public void registrationUser(String name, String email, String password){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.waitStartRegisterPage();
        registerPage.setUserData(name,email,password);
        registerPage.waitClickRegistrationButton();
        registerPage.clickRegistrationButton();
    }
    @Step("Открыть домашнюю страницу")
    public void openHomePage (){
        driver.get(URL_HOME_PAGE);
    }

    @Step("Отображается ли кнопка - Оформить заказ")
    public boolean isOrderButtonDisplayed () {
      return driver.findElement(ORDER_BUTTON).isDisplayed();
    }

    @Step("Нажатие на кнопку - Булки")
    public void clickBunButton(){
        clickButton(BUN_BUTTON);
    }
    @Step("Нажатие на кнопку - Соусы")
    public void clickSauceButton(){
        clickButton(SAUCE_BUTTON);
    }
    @Step("Нажатие на кнопку - Начинки")
    public void clickStuffingButton(){
        clickButton(STUFFING_BUTTON);
    }
    @Step("Отображается ли секция - Булки")
    public boolean isBunSectionDisplayed () {
        return driver.findElement(BUN_SECTION).isDisplayed();
    }
    @Step("Отображается ли секция - Соус")
    public boolean isSauceSectionDisplayed () {
        return driver.findElement(SAUCE_SECTION).isDisplayed();
    }
    @Step("Отображается ли секция - Начинка")
    public boolean isStuffingSectionDisplayed () {
        return driver.findElement(STUFFING_SECTION).isDisplayed();
    }
    @Step("Ожидание появления секции -Булки")
    public void waitingForTheBunsSectionToAppear() {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(BUN_SECTION));
    }
    @Step("Ожидание появления секции - Соус")
    public void waitingForTheSauceSectionToAppear() {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(SAUCE_SECTION));
    }
    @Step("Ожидание появления секции - Начинка")
    public void waitingForTheStuffingSectionToAppear() {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(STUFFING_SECTION));
    }
}

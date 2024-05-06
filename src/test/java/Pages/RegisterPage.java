package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constants.Constant.URL_REGISTER_PAGE;

public class RegisterPage {
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By REGISTER_PAGE_HEADER = By.xpath(".//*[text() = 'Регистрация']");
    private final By USER_NAME_FIELD = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By USER_EMAIL_FIELD = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By USER_PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private final By REGISTRATION_BUTTON = By.className("button_button__33qZ0");
    private final By ERROR_MESSAGE = By.xpath(".//fieldset[3]/div/p[contains(text(), 'Некорректный пароль')]");
    private final By LOGIN_BUTTON = By.className("Auth_link__1fOlj");


    private void clickButton(By button) {
        driver.findElement(button).isDisplayed();
        driver.findElement(button).click();
    }

    @Step("Ожидание загрузки страницы Регистрации")
    public void waitStartRegisterPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(REGISTER_PAGE_HEADER));
    }

    @Step("Заполнение данными пользователя")
    public void setUserData(String name, String email, String password) {
        driver.findElement(USER_NAME_FIELD).clear();
        driver.findElement(USER_NAME_FIELD).sendKeys(name);
        driver.findElement(USER_EMAIL_FIELD).clear();
        driver.findElement(USER_EMAIL_FIELD).sendKeys(email);
        driver.findElement(USER_PASSWORD_FIELD).clear();
        driver.findElement(USER_PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Ожидание на кликабельность кнопки Регистрации")
    public void waitClickRegistrationButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(REGISTRATION_BUTTON));
    }

    @Step("Нажатие на кнопку - Зарегистрироваться")
    public void clickRegistrationButton() {
        clickButton(REGISTRATION_BUTTON);
    }

    @Step("Нажатие на кнопку - Войти")
    public void clickLoginButton() {
        clickButton(LOGIN_BUTTON);
    }

    @Step("Ожидание сообщение об ошибки")
    public void waitErrorMessage() {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
    }

    @Step("Отображается ли ошибка")
    public Boolean isStatusErrorMessageDisplayed() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    @Step("Получить текст ошибки")
    public String getTextErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    @Step("Открыть страницу регистрации")
    public void openRegisterPage(){
        driver.get(URL_REGISTER_PAGE);
    }
}
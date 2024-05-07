package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constants.Constant.URL_LOGIN_PAGE;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By LOGIN_PAGE_HEADER = By.xpath("//*[text() = 'Вход']");
    private final By REGISTRATION_BUTTON = By.xpath("//*[text() = 'Зарегистрироваться']");
    private final By USER_EMAIL_FIELD = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By USER_PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private final By LOGIN_BUTTON = By.className("button_button__33qZ0");
    private final By RESTORE_PASSWORD_BUTTON = By.xpath("//*[text() = 'Восстановить пароль']");


    private void clickButton(By button) {
        driver.findElement(button).isDisplayed();
        driver.findElement(button).click();
    }

    @Step("Ожидание загрузки страницы Логина")
    public void waitStartLoginPage() {
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_PAGE_HEADER));
    }

    @Step("Нажатие на кнопку - Войти в аккаунт")
    public void clickRegistrationButton(){
        clickButton(REGISTRATION_BUTTON);
    }

    @Step("Нажатие на кнопку - Восстановить пароль")
    public void clickRestorePasswordButton(){
        clickButton(RESTORE_PASSWORD_BUTTON);
    }
    @Step("Видна ли надпись - Вход")
    public Boolean isStatusLoginHeaderDisplayed() {
        return driver.findElement(LOGIN_PAGE_HEADER).isDisplayed();
    }
    @Step("Заполнение данными для логина")
    public void authorizationUser (String email, String password){
        driver.findElement(USER_EMAIL_FIELD).clear();
        driver.findElement(USER_EMAIL_FIELD).sendKeys(email);
        driver.findElement(USER_PASSWORD_FIELD).clear();
        driver.findElement(USER_PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Ожидание на кликабельность кнопки Войти")
    public void waitClickLoginButton() {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
    }

    @Step("Нажатие на кнопку - Войти в аккаунт")
    public void clickLoginButton(){
        clickButton(LOGIN_BUTTON);
    }
    @Step("Открыть домашнюю страницу")
    public void openLoginPage (){
        driver.get(URL_LOGIN_PAGE);
    }
}

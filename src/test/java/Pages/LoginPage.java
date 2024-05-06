package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By LOGIN_PAGE_HEADER = By.xpath(".//*[text() = 'Вход']");
    private final By REGISTRATION_BUTTON = By.xpath(".//*[text() = 'Зарегистрироваться']");
    private final By USER_EMAIL_FIELD = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By USER_PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private final By LOGIN_BUTTON = By.className("button_button__33qZ0");

    private void clickButton(By button) {
        driver.findElement(button).isDisplayed();
        driver.findElement(button).click();
    }

    @Step("Ожидание загрузки страницы Логина")
    public void waitStartLoginPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_PAGE_HEADER));
    }

    @Step("Нажатие на кнопку - Войти в аккаунт")
    public void clickRegistrationButton(){
        clickButton(REGISTRATION_BUTTON);
    }
    @Step("Видна ли надпись - Вход")
    public Boolean isStatusLoginHeaderDisplayed() {
        return driver.findElement(LOGIN_PAGE_HEADER).isDisplayed();
    }
}

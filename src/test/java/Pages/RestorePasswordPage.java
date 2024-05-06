package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RestorePasswordPage {
    private final WebDriver driver;

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By RESTORE_PASSWORD_PAGE_HEADER = By.xpath(".//*[text() = 'Восстановление пароля']");
    private final By LOGIN_BUTTON = By.className("Auth_link__1fOlj");

    private void clickButton(By button) {
        driver.findElement(button).isDisplayed();
        driver.findElement(button).click();
    }

    @Step("Ожидание загрузки страницы Восстановление пароля")
    public void waitStartRestorePasswordPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(RESTORE_PASSWORD_PAGE_HEADER));
    }

    @Step("Нажатие на кнопку - Войти в аккаунт")
    public void clickRegistrationButton(){
        clickButton(LOGIN_BUTTON);
    }
}

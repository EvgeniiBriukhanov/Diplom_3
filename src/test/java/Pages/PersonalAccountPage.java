package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    private final WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By PROFILE_BUTTON = By.xpath(".//*[text() = 'Профиль']");
    private final By PERSONAL_ACCOUNT_INFO_TEXT = By.xpath(".//*[text() = 'В этом разделе вы можете изменить свои персональные данные']");
    private final By LOGOUT_BUTTON = By.className("Account_button__14Yp3");
    private final By CONSTRUCTOR_BUTTON = By.xpath("//a[@href='/' and @class='AppHeader_header__link__3D_hX']");
    private final By STELLAR_BURGERS_LOGO_BUTTON = By.className("AppHeader_header__logo__2D0X2");

    private void clickButton(By button) {
        driver.findElement(button).isDisplayed();
        driver.findElement(button).click();
    }

    @Step("Ожидание загрузки страницы Логина")
    public void waitStartPersonalAccountPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(PROFILE_BUTTON));
    }

    @Step("Нажатие на кнопку - Конструктор")
    public void clickLogoutButton(){
        clickButton(LOGOUT_BUTTON);
    }
    @Step("Нажатие на кнопку логотипа - Stellar Burgers")
    public void clickStellarBurgersButton(){
        clickButton(STELLAR_BURGERS_LOGO_BUTTON);
    }

    @Step("Нажатие на кнопку - Конструктор")
    public void clickConstructorButton(){
        clickButton(CONSTRUCTOR_BUTTON);
    }
    @Step("Отображается ли ошибка")
    public Boolean isStatusPersonalAccountInfoTextDisplayed() {
        return driver.findElement(PERSONAL_ACCOUNT_INFO_TEXT).isDisplayed();
    }

    @Step("Получить текст ошибки")
    public String getPersonalAccountInfoText() {
        return driver.findElement(PERSONAL_ACCOUNT_INFO_TEXT).getText();
    }
}

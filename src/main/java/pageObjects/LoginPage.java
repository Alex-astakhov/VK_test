package pageObjects;


import core.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import static core.MethodsFactory.driver;

/**
 * Created by Alex Astakhov on 22.05.2016.
 */
public class LoginPage extends MethodsFactory {
    private By emailField = By.id("index_email");
    private By passField = By.id("index_pass");
    private By loginButton = By.id("index_login_button");

    @Step
    public void login(String email, String password){
        get("https://vk.com");
        type(emailField, email);
        type(passField, password);
        driver().findElement(loginButton).click();
        waitForUrlContains("feed");
    }
}

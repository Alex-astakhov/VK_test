package pageObjects;

import core.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alex Astakhov on 13.08.2016.
 */
public class UserPage extends MethodsFactory {

    private By newMessage = By.xpath(".//*[@id='l_msg']//*[text()='+1']");

    @Step
    public void waitForNewMessage(){
        WebDriverWait wait = new WebDriverWait(driver(), 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(newMessage));
    }
}

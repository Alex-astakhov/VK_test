package pageObjects;

import core.MethodsFactory;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alex Astakhov on 13.08.2016.
 */
public class MessagesPage extends MethodsFactory {
    private By unreadMessage = By.xpath(".//*[@data-unread='1']");
    private By lastMessage = By.xpath(".//*[@class='im_in'][last()]//div[@class='im_msg_text']");

    @Step
    public String getUnreadMessage(){
        driver().findElement(unreadMessage).click();
        waitForElement(lastMessage);
        return driver().findElement(lastMessage).getText();
    }

}

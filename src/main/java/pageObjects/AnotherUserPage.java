package pageObjects;

import core.MethodsFactory;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alex Astakhov on 13.08.2016.
 */
public class AnotherUserPage extends MethodsFactory {
    private By writeMessageButton = By.xpath(".//button[@class='flat_button profile_btn_cut_left']");
    private By textBox = By.id("mail_box_editable");
    private By sendMessageButton = By.id("mail_box_send");
    private By messageIsSent = By.xpath(".//div[@class='top_result_header']");

    @Step("Sending message - {0}")
    public void sendMessage(String text){
        driver().findElement(writeMessageButton).click();
        waitForElement(textBox);
        type(textBox, text);
        driver().findElement(sendMessageButton).click();
        waitForElement(messageIsSent);
    }
}

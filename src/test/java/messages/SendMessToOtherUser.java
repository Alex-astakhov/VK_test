package messages;

import core.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AnotherUserPage;
import pageObjects.LoginPage;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by Alex Astakhov on 13.08.2016.
 */
public class SendMessToOtherUser extends BrowserFactory {
    public static long sendTime = 0;
    
    @Parameters({"user", "password", "message"})
    @Test
    public void sendMessage(String userName, String password, @Optional("Standard check") String message){
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        driver().get("https://vk.com/id363341738");
        AnotherUserPage anotherUserPage = new AnotherUserPage();
        anotherUserPage.sendMessage(message);
        sendTime = System.currentTimeMillis();
    }
}

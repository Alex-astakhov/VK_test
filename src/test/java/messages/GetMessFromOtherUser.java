package messages;

import core.BrowserFactory;
import listeners.ListenerWithBrowserShot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AnotherUserPage;
import pageObjects.LoginPage;
import pageObjects.MessagesPage;
import pageObjects.UserPage;

/**
 * Created by Alex Astakhov on 13.08.2016.
 */
@Listeners({ListenerWithBrowserShot.class})
public class GetMessFromOtherUser extends BrowserFactory {

    @Parameters({"message"})
    @Test
    public void sendMessage(@Optional("Standard check") String message) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login("+380938703788", "ahtung85");
        UserPage userPage = new UserPage();
        userPage.waitForNewMessage();
        long sendingTime = System.currentTimeMillis() - SendMessToOtherUser.sendTime;
        System.out.print("Time for sending: ");
        System.out.print((double) sendingTime/1000);
        System.out.println(" sec.");
        get("https://vk.com/im");
        MessagesPage msp = new MessagesPage();
        Assert.assertEquals(msp.getUnreadMessage(), message);
    }
}

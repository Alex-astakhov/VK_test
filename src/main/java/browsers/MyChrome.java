package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Alex Astakhov on 25.07.2016.
 */
public class MyChrome {
    public WebDriver getDriver(){
        return new ChromeDriver();
    }
}

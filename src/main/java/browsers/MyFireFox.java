package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Alex Astakhov on 25.07.2016.
 */
public class MyFireFox {

    public WebDriver getDriver(){
        return new FirefoxDriver();
    }
}

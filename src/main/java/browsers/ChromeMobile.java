package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex Astakhov on 25.07.2016.
 */
public class ChromeMobile {

    public WebDriver getDriver(){

        /*Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 320);
        deviceMetrics.put("height", 480);
        deviceMetrics.put("pixelRatio", 3.0);*/

        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("deviceName", "Apple iPhone 6");

        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return new ChromeDriver(capabilities);
    }
}

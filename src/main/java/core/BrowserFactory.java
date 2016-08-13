package core;

import browsers.ChromeMobile;
import browsers.MyChrome;
import browsers.MyFireFox;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alex Astakhov on 18.05.2016.
 */
public class BrowserFactory extends MethodsFactory {


    @BeforeTest
    @Parameters({"browser"})
    public void setupUp(@Optional("CH") String browser) {
        switch (browser){
            case "CH": driver = new MyChrome().getDriver(); break;
            case "CHM": driver = new ChromeMobile().getDriver(); break;
            case "FF": driver = new MyFireFox().getDriver(); break;
        }

        driver.manage().window().maximize();            // максимизация окна
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //время ожидания загрузки ннужного элемента
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // время ожидания загрузки страницы
        DRIVER.set(driver);
    }

    @AfterTest
    public void tearDown() {  // закрытие браузера

        driver().quit();   // закрываем процесс
    }
}

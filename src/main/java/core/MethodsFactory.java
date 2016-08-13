package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Alex Astakhov on 21.05.2016.
 */
public class MethodsFactory {

    public static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    public WebDriver driver;


    @Step("Type to {1} field {0}")
    public void type(By locator, String s){
        driver().findElement(locator).clear();
        driver().findElement(locator).sendKeys(s);
    }

    @Step("Type to {1} field {0}")
    public void type(WebElement w, String s){
        w.clear();
        w.sendKeys(s);
    }

    public void click(By by){
        driver().findElement(by).click();
    }

    public static WebDriver driver(){
        return DRIVER.get();
    }

    public void get(String url){
        driver().get(url);
    }

    public void waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForUrlContains(String text){
        WebDriverWait wait = new WebDriverWait(driver(), 10);
        wait.until(ExpectedConditions.urlContains("feed"));
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] pngAttachment(String fileName){
        File scrFile = ((TakesScreenshot) BrowserFactory.driver()).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
            // FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\" + fileName));
            return Files.readAllBytes(Paths.get(scrFile.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

}

package mainpkg;

import loginTest.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v103.log.Log;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedInputStream;
import java.io.File;
import java.time.Duration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Main {
    public static WebDriver  webDriver;
    public static void run(){
        //System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--log-level=3");
        chromeOptions.addArguments("--silent");

        System.setProperty("webdriver.chrome.silentOutput", "true");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://react-application-cart.herokuapp.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
    }
    public static void quit(){
        webDriver.quit();
    }
    public static void close(){
        webDriver.close();
    }
    public static void main(String[] args) {
        run();


    }
}

package loginTest;

import io.cucumber.java.an.E;
import mainpkg.Main;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

public class LoginTest {
    public static String  actual="https://react-application-cart.herokuapp.com/";
    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(actual,"feras.94.kasabri@gmail.com","123"),
                Arguments.of(actual,"feras.94@gmail.com","12"),
                Arguments.of(actual,"feras.94.kasabri@gmail.com","12"),
                Arguments.of(actual,"feras.94@gmail.com","123")
        );
    }
//    @BeforeAll
//    public static void before(){
//        Main.run();
//    }
    @DisplayName("Test login")
    @ParameterizedTest
    @MethodSource("provideParameters")
    public void Test(String actual,String emailStr,String passwordStr){
        try {
            Main.run();
            WebElement loginNav = Main.webDriver.findElement(By.linkText("Login"));
            loginNav.click();
            WebElement email = Main.webDriver.findElement(By.cssSelector("input[type='email']"));
            email.sendKeys(emailStr);
            WebElement password = Main.webDriver.findElement(By.cssSelector("input[type='password']"));
            password.sendKeys(passwordStr);
            WebElement login = Main.webDriver.findElement(By.cssSelector(".login"));

            login.click();
            WebDriverWait wait = new WebDriverWait(Main.webDriver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe(actual));
            System.out.println(Main.webDriver.getCurrentUrl());
            Assertions.assertEquals(actual, Main.webDriver.getCurrentUrl());
            //Main.quit();
        }
        catch (Exception e){
            Assertions.fail("user not found");
        }
        finally {
            Main.quit();
        }

    }


}

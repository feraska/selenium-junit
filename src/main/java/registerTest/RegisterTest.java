package registerTest;

import io.cucumber.java.an.E;
import mainpkg.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

public class RegisterTest {
    public static String  actual="https://react-application-cart.herokuapp.com/";
    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(actual,"feras.94.kasabri@gmail.com","123","feras","kasabri"),
                Arguments.of(actual,"feras.94@gmail.com","123","feras","kasabri"),
                Arguments.of(actual,"feras.94.kasabri@gmail.com","12","feras","kasabri"),
                Arguments.of(actual,"feras.94@gmail.com","12","feras","kasabri")
        );
    }

    @DisplayName("Test Register")
    @ParameterizedTest
    @MethodSource("provideParameters")
    public void Test(String actual,String emailStr,String passwordStr,String firstNameStr,
                     String lastNameStr){
        Main.run();

        try {

            WebElement loginNav = Main.webDriver.findElement(By.linkText("Login"));
            loginNav.click();
            WebElement registerBtn = Main.webDriver.findElement(By.cssSelector(".register"));
            registerBtn.click();
            WebElement email = Main.webDriver.findElement(By.cssSelector(".register-form input[name='email']"));
            email.sendKeys(emailStr);

            WebElement password = Main.webDriver.findElement(By.cssSelector((".register-form input[name='password']")));
            password.sendKeys(passwordStr);

            WebElement firstName = Main.webDriver.findElement(By.cssSelector(".register-form input[name='firstName']"));
            firstName.sendKeys(firstNameStr);

            WebElement lastName = Main.webDriver.findElement(By.cssSelector((".register-form input[name='lastName']")));
            lastName.sendKeys(lastNameStr);

            WebElement submit = Main.webDriver.findElement(By.cssSelector(".register-form button"));
            submit.click();

            WebElement registerForm = Main.webDriver.findElement(By.cssSelector(".register-form"));


            WebDriverWait wait = new WebDriverWait(Main.webDriver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(registerForm));
            Assertions.assertFalse(registerForm.isDisplayed());

        }
        catch (Exception e){
            Assertions.fail("failed register or duplicate email");
        }
        finally {
            Main.quit();
        }

    }
}

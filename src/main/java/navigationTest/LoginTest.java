package navigationTest;

import mainpkg.Main;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginTest {


        @BeforeAll
        public static void b() {
            Main.run();
        }

        @Test
        @DisplayName("test log in")
        public void test(){

            String actual = "https://react-application-cart.herokuapp.com/login";
            WebElement login = Main.webDriver.findElement(By.linkText("Login"));
            login.click();
            String expected = Main.webDriver.getCurrentUrl();
            Assertions.assertEquals(actual,expected);
        }
    @AfterAll
    public static void after() {
        Main.quit();
    }
    }


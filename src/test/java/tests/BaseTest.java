package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    LoginPage loginPage;
    MainPage mainPage;

    @BeforeMethod
    public void setup() {

        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        Configuration.timeout = 50000;
        Configuration.headless = false;
        loginPage = new LoginPage();
        mainPage = new MainPage();


    }
    @AfterMethod
    public void tearDown() {
        {
            getWebDriver().quit();
        }

    }
}

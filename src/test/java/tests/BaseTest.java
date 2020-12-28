package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BoardPage;
import pages.EnterPage;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    LoginPage loginPage;
    MainPage mainPage;
    BoardPage boardPage;
    EnterPage enterPage;

    @BeforeMethod
    public void setup() {

        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 30000;
        Configuration.headless = false;
        loginPage = new LoginPage();
        mainPage = new MainPage();
        boardPage = new BoardPage();
        enterPage = new EnterPage();

    }


    @AfterMethod
    public void tearDown() {
        {
            getWebDriver().quit();
        }

    }
}

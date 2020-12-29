package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.BoardPage;
import pages.EnterPage;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
@Log4j2
public class BaseTest {

    LoginPage loginPage;
    MainPage mainPage;
    BoardPage boardPage;
    EnterPage enterPage;

    @BeforeMethod(description = "configuration and initialization")
    public void setup() {

        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 30000;
        Configuration.headless = false;
        Configuration.reportsFolder = "target/site/allure-maven-plugin/data";
        loginPage = new LoginPage();
        mainPage = new MainPage();
        boardPage = new BoardPage();
        enterPage = new EnterPage();

    }


    @AfterMethod(alwaysRun = true, description = "driver quit")
    public void tearDown() {
        try {
            getWebDriver().quit();
        } catch (IllegalStateException ex) {
            log.warn("WebDriver is not opened");
            log.warn(ex.getLocalizedMessage());
        }

    }
}

package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.BoardPage;
import pages.EnterPage;
import pages.LoginPage;
import pages.MainPage;
import utils.CapabilitiesGenerator;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;
    MainPage mainPage;
    BoardPage boardPage;
    EnterPage enterPage;
    WebDriver driver;
    @BeforeMethod
    public void setup(ITestContext context) {

        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 30000;
        Configuration.headless = false;
        loginPage = new LoginPage();
        mainPage = new MainPage();
        boardPage = new BoardPage();
        enterPage = new EnterPage();

        try {
            driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        } catch (SessionNotCreatedException ex) {
            Assert.fail("Браузер не был открыт. Проверьте, что используется корректная версия драйвера");
            log.fatal(ex.getLocalizedMessage());
        }

        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }


    @AfterMethod
    public void tearDown() {
        {
            getWebDriver().quit();
        }

    }
}

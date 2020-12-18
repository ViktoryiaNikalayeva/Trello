package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    String email;
    String password;
    public static final String PATH_TO_PROPERTIES = "src/test/resources/config.properties";
    public static final String URL = "https://trello.com/login";


    public LoginPage openPage() {
        open(URL);
        return this;
    }

    public LoginPage isPageOpened() {
        $(byClassName("global-footer-list")).waitUntil(Condition.visible, 24000);
        return this;
    }

    public MainPage login() throws InterruptedException {
        open("https://trello.com/login");
        $(byId("user")).sendKeys(email);
        $(byId("password")).sendKeys(password);
        $(byId("login")).click();
        Thread.sleep(2000);
        $(byId("password")).sendKeys(password);
        $(byClassName("css-t5emrf")).click();
        return new MainPage();
    }

    public void loginForErrorVars1and3(String email, String password) {
        open("https://trello.com/login");
        $(byId("user")).sendKeys(email);
        $(byId("password")).sendKeys(password);
        $(byId("login")).click();
    }

    public void loginForErrorVars2(String email, String password) throws InterruptedException {
        open("https://trello.com/login");
        $(byId("user")).sendKeys(email);
        $(byId("password")).sendKeys(password);
        $(byId("login")).click();
        Thread.sleep(2000);
        $(byId("password")).sendKeys(password);
        $(byClassName("css-t5emrf")).click();
    }

    public WebElement getErrorMessage1()
    {
        return $(byXpath("//div[@id='error']/child::*"));
    }

    public WebElement getErrorMessage2() {
        return $(byText("Войдите, чтобы перейти далее:"));
    }
    public WebElement getErrorMessage3() {
        return $(byText("Не удается войти?"));
    }


    public LoginPage() {
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            email = prop.getProperty("email");
            password = prop.getProperty("password");
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
            e.printStackTrace();
        }
    }
}


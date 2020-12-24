package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    String email;
    String password;
    public static final String PATH_TO_PROPERTIES = "src/test/resources/config.properties";
    public static final String URL = "https://trello.com/login";
    public static final String PAGE_OPEN_TRUE = "global-footer-list";
    public static final String USER = "user";
    public static final String PASSWORD =  "password";
    public static final String LOGIN_BUTTON = "login";
    public static final String LOGIN_BUTTON_FINISH = "css-t5emrf";
    public static final String ERR_MESS_1 = "//div[@id='error']/child::*";
    public static final String ERR_MESS_2 = "Войдите, чтобы перейти далее:";
    public static final String ERR_MESS_3 = "Не удается войти?";
    public static final String BUTTON_TO_USER = "_24AWINHReYjNBf";
    public static final String USER_NAME= "_1njv2a9PIrnydF";

    public LoginPage openPage() {
        open(URL);
        return this;
    }

    public LoginPage isPageOpened() {
        $(byClassName(PAGE_OPEN_TRUE)).waitUntil(Condition.visible, 24000);
        return this;
    }

    public MainPage login()  {
        open(URL);
        $(byId(USER)).sendKeys(email);
        $(byId(PASSWORD)).sendKeys(password);
        $(byId(LOGIN_BUTTON)).click();
        sleep(2000);
        $(byId(PASSWORD)).sendKeys(password);
        $(byClassName(LOGIN_BUTTON_FINISH)).click();
        return new MainPage();
    }

    public void loginForErrorVars1and3(String email, String password) {
        open(URL);
        $(byId(USER)).sendKeys(email);
        $(byId(PASSWORD)).sendKeys(password);
        $(byId(LOGIN_BUTTON)).click();
    }

    public void loginForErrorVars2(String email, String password) {
        open(URL);
        $(byId(USER)).sendKeys(email);
        $(byId(PASSWORD)).sendKeys(password);
        $(byId(LOGIN_BUTTON)).click();
        sleep(2000);
        $(byId(PASSWORD)).sendKeys(password);
        $(byClassName(LOGIN_BUTTON_FINISH)).click();
    }

    public WebElement getErrorMessage1()
    {
        return $(byXpath(ERR_MESS_1));
    }
    public WebElement getErrorMessage2() {
        return $(byText(ERR_MESS_2));
    }
    public WebElement getErrorMessage3() {
        return $(byText(ERR_MESS_3));
    }

    public WebElement isUserLogined () {
        $(byClassName(BUTTON_TO_USER)).click();
        return $(byClassName(USER_NAME));

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


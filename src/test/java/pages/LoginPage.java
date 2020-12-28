package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
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
    public static final String ERR_MESS_1 = "Не удается войти?";
    public static final String ERR_MESS_2 = "Войдите, чтобы перейти далее:";
    public static final String BUTTON_TO_USER = "_24AWINHReYjNBf";
    public static final String USER_NAME= "_1njv2a9PIrnydF";

    public LoginPage openPage() {
        log.fatal("open LoginPage trello.com/login");
        open(URL);
        return this;
    }

    public LoginPage isPageOpened() {
        log.debug("check that page trello.com/login is opened");
        $(byClassName(PAGE_OPEN_TRUE)).waitUntil(exist, 30000, 500);
        return this;
    }

    public MainPage login()  {
        log.fatal("open LoginPage trello.com/login");
        open(URL);
        log.info("find input of email and enter email");
        $(byId(USER)).waitUntil(Condition.visible, 30000, 500).sendKeys(email);
        sleep(1000);
        $(byId(LOGIN_BUTTON)).waitUntil(exist, 30000, 500).click();
        sleep(1000);
        $(byId(PASSWORD)).waitUntil(exist, 30000, 500).sendKeys(password);
        $(byClassName(LOGIN_BUTTON_FINISH)).waitUntil(exist, 30000, 500).click();
        return new MainPage();
    }

    public void loginForErrorVars1(String email, String password) {
        log.fatal("open LoginPage trello.com/login");
        open(URL);
        log.info("find input of email and enter email");
        $(byId(USER)).waitUntil(Condition.visible, 30000, 500).sendKeys(email);
        log.info("find input of password and enter password");
        $(byId(PASSWORD)).sendKeys(password);
        $(byId(LOGIN_BUTTON)).click();
    }

    public void loginForErrorVars2(String email, String password) {
        log.fatal("open LoginPage trello.com/login");
        open(URL);
        log.info("find input of email and enter email");
        $(byId(USER)).waitUntil(Condition.visible, 30000, 500).sendKeys(email);
        $(byId(LOGIN_BUTTON)).click();
        sleep(2000);
        log.info("find input of password and enter password");
        $(byId(PASSWORD)).waitUntil(Condition.visible, 30000, 500).sendKeys(password);
        $(byClassName(LOGIN_BUTTON_FINISH)).waitUntil(exist, 30000, 500).click();
    }

    public WebElement getErrorMessage1() {
        return $(byText(ERR_MESS_1));
    }
    public WebElement getErrorMessage2() {
        return $(byText(ERR_MESS_2));
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


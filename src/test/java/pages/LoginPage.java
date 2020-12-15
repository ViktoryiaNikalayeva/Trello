package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
        $(By.className("global-footer-list")).waitUntil(Condition.visible, 24000);
        return this;
    }

    public MainPage login() throws InterruptedException {
        open("https://trello.com/login");
        $(By.id("user")).setValue(email);
        $(By.id("password")).setValue(password);
        $(By.id("login")).click();
        Thread.sleep(2000);
        $(By.id("password")).setValue(password);
        $(By.className("css-t5emrf")).click();
        return new MainPage();
    }

    public void loginForErrorVars1and3(String email, String password) {
        open("https://trello.com/login");
        $(By.id("user")).setValue(email);
        $(By.id("password")).setValue(password);
        $(By.id("login")).click();
    }

    public void loginForErrorVars2(String email, String password) throws InterruptedException {
        open("https://trello.com/login");
        $(By.id("user")).setValue(email);
        $(By.id("password")).setValue(password);
        $(By.id("login")).click();
        Thread.sleep(2000);
        $(By.id("password")).setValue(password);
        $(By.className("css-t5emrf")).click();
    }

    public WebElement getErrorMessage1() {
        return $(By.xpath("//div[@id='error']/child::*"));
    }

    public WebElement getErrorMessage2() {
        return $(By.xpath("//div[@class = 'sc-jnlKLf jPmbfd']/child::span)"));
    }

    public WebElement getErrorMessage3() {
        return $(By.xpath("//div[@id='password-error']/child::*"));
    }


    public LoginPage() {
        FileInputStream fileInputStream;
        //инициализируем специальный объект Properties
        //типа Hashtable для удобной работы с данными
        Properties prop = new Properties();
        try {
            //обращаемся к файлу и получаем данные
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


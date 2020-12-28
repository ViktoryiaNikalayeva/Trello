package tests;


import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    String email;
    String password;
    public static final String PATH_TO_PROPERTIES = "src/test/resources/config.properties";


    @Step("User should pass authorization and appear at MainPage")
    @Test(description = "user should pass authorization and appear at MainPage")
    public void loginAndGoToMainPage() {
        enterPage
                .openPage()
                .isPageOpened()
                .startAndEnter();
        loginPage
                .openPage()
                .isPageOpened()
                .login();
        assertEquals(loginPage.isUserLogined().getText(), "Viktoryia");
    }

    @Step("Check errors of authorization (null and incorrect email + variants)")
    @DataProvider
    public Object[][] errorVars1() {
        return new Object[][]{

                {"", password, "Не удается войти?"},
                {"", "", "Не удается войти?"},
                {"", "Fawkes", "Не удается войти?"},
                {"guy@gmail.com", "Fawkes", "Не удается войти?"},
                {"guy@gmail.com", password, "Не удается войти?"},
                {"guy@gmail.com", "", "Не удается войти?"},
        };
    }

    @Test(dataProvider = "errorVars1", description = "check errors of authorization (null email + variants)")
    public void errorVars1(String email, String password, String errorMessage1) {
        loginPage
                .openPage()
                .isPageOpened()
                .loginForErrorVars1(email, password);
        assertEquals(loginPage.getErrorMessage1().getText(), errorMessage1);
    }

    @Step("Check errors of authorization (correct email + variants")
    @DataProvider
    public Object[][] errorVars2() {
        return new Object[][]{
                {email, "", "Войдите, чтобы перейти далее:"},
                {email, "Fawkes", "Войдите, чтобы перейти далее:"},
        };
    }

    @Test(dataProvider = "errorVars2", description = "check errors of authorization (correct email + variants)")
    public void errorVars2(String email, String password, String errorMessage2) {
        loginPage
                .openPage()
                .isPageOpened()
                .loginForErrorVars2(email, password);
        assertEquals(loginPage.getErrorMessage2().getText(), errorMessage2);
    }

    public LoginTest() {
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


package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

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

    @DataProvider
    public Object[][] errorVars1() {
        return new Object[][]{
                {"", "password", "Отсутствует адрес электронной почты"},
                {"", "", "Отсутствует адрес электронной почты"},
                {"", "Fawkes", "Отсутствует адрес электронной почты"},
        };
    }

    @Test(dataProvider = "errorVars1", description = "check  errors of authorization (null email + variants)")
    public void errorVars1(String email, String password, String errorMessage1) {
        loginPage
                .openPage()
                .isPageOpened()
                .loginForErrorVars1and3(email, password);
        assertEquals(loginPage.getErrorMessage1().getText(), errorMessage1);
    }

    @DataProvider
    public Object[][] errorVars2() {
        return new Object[][]{
                {"v66@mailinator.com", "", "Войдите, чтобы перейти далее:"},
                {"v66@mailinator.com", "Fawkes", "Войдите, чтобы перейти далее:"},
        };
    }

    @Test(dataProvider = "errorVars2", description = "check  errors of authorization (correct email + variants)")
    public void errorVars2(String email, String password, String errorMessage2) throws InterruptedException {
        loginPage
                .openPage()
                .isPageOpened()
                .loginForErrorVars2(email, password);
        assertEquals(loginPage.getErrorMessage2().getText(), errorMessage2);
    }

    @DataProvider
    public Object[][] errorVars3() {
        return new Object[][]{
                {"guy@gmail.com", "Fawkes", "Не удается войти?"},
                {"guy@gmail.com", "password", "Не удается войти?"},
                {"guy@gmail.com", "", "Не удается войти?"},
        };
    }

    @Test(dataProvider = "errorVars3", description = "check errors of authorization (incorrect email + variants)")
    public void errorVars3(String email, String password, String errorMessage3) {
        loginPage
                .openPage()
                .isPageOpened()
                .loginForErrorVars1and3(email, password);
        assertEquals(loginPage.getErrorMessage3().getText(), errorMessage3);
    }


}


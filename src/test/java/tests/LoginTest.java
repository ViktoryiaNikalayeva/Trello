package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "User should pass authorization and appear at MainPage")
    public void loginAndGoToMainPage() {
        loginPage
                .openPage()
                .isPageOpened()
                .login();
        mainPage.isPageOpened();
    }

    @DataProvider
    public Object[][] errorVars1() {
        return new Object[][]{
                {"", "password", "Отсутствует адрес электронной почты"},
                {"", "", "Отсутствует адрес электронной почты"},
//1 вариант
                {"Guy", "", "Аккаунта с таким адресом электронной почты не существует"},
                {"Guy", "password", "Аккаунта с таким адресом электронной почты не существует"},
                {"v66@mailinator.com", "", "Аккаунта с таким адресом электронной почты не существует"},
                {"v66@mailinator.com", "Fawkes", "Аккаунта с таким именем пользователя не существует"},
       };
    }

    @Test(dataProvider = "errorVars1", description = "check variable errors of authorization process")
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
//2 вариант
                {"v66mailinator.com", "", "Неверный адрес электронной почты и/или пароль."},
                {"v66mailinator.com", "Неверный адрес электронной почты и/или пароль."},
                {"Guy", "", "Неверный адрес электронной почты и/или пароль."},
                {"Guy", "password", "Неверный адрес электронной почты и/или пароль."},
        };
    }

    @Test(dataProvider = "errorVars2", description = "check variable errors of authorization process")
    public void errorVars2(String email, String password, String errorMessage2) {
        loginPage
                .openPage()
                .isPageOpened()
                .loginForErrorVars2(email, password);
        assertEquals(loginPage.getErrorMessage2().getText(), errorMessage2);
    }

//ОК

    @DataProvider
    public Object[][] errorVars3() {
        return new Object[][]{
                {"guy@gmail.com", "Fawkes", "Указан неверный адрес и/или пароль. Нужна помощь?"},
        };
    }

    @Test(dataProvider = "errorVars3", description = "check variable errors of authorization process (password)")
    public void errorVars3(String email, String password, String errorMessage3) {
        loginPage
                .openPage()
                .isPageOpened()
                .loginForErrorVars1and3(email, password);
        assertEquals(loginPage.getErrorMessage3().getText(), errorMessage3);
    }
}

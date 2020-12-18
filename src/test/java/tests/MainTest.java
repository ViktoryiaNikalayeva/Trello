package tests;

import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test
    public void teamShouldBeCreate() throws InterruptedException {
        loginPage
                .openPage()
                .isPageOpened()
                .login();
        mainPage.isPageOpened()
                .createTeam();

    }
}

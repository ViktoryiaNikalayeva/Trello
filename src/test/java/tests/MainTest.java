package tests;


import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class MainTest extends BaseTest {

    @Step("Team should be created")
    @Test
    public void teamShouldBeCreate()  {
        enterPage
                .openPage()
                .isPageOpened()
                .startAndEnter();
        loginPage
                .openPage()
                .isPageOpened()
                .login();
        assertEquals(loginPage.isUserLogined().getText(), "Viktoryia");
        mainPage.isPageOpened()
                .createTeam("DreamTeam", "Test for test",
                        "Маркетинг", "n77@mailinator.com");
       assertEquals(mainPage.isTeamCreated().getText(), "Изменить информацию о команде");
    }

    @Step("Team should be deleted")
    @Test (description = "find the team and delete")
    public void teamShouldBeDeleted()  {
        enterPage
                .openPage()
                .isPageOpened()
                .startAndEnter();
        loginPage
                .openPage()
                .isPageOpened()
                .login();
        assertEquals(loginPage.isUserLogined().getText(), "Viktoryia");
        mainPage.isPageOpened()
                .deleteTeam("DreamTeam");
    }

}

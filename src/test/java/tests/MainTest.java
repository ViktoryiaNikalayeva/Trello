package tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class MainTest extends BaseTest {

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
}

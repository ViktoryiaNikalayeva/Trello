package tests;

import org.testng.annotations.Test;

public class BoardTest extends BaseTest {

    @Test
    public void boardsCardsAndSoOn() throws InterruptedException {

        loginPage
                .openPage()
                .isPageOpened()
                .login();
        mainPage
                .isPageOpened()
                .createBoard();
        boardPage
                .isPageOpened()
                .createLists()
                .createCards()
                .copyAndCreatingNewList()
                .moveLocationOfTheList()
               .signatureAtCard();

    }
}
package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoardTest extends BaseTest {

    @Test(priority = 1, description = "board should be created")
    public void boardShouldBeCreated() {
        enterPage
                .openPage()
                .isPageOpened()
                .startAndEnter();
        loginPage
                .openPage()
                .isPageOpened()
                .login();
        assertEquals(loginPage.isUserLogined().getText(), "Viktoryia");
        mainPage
                .isPageOpened()
                .createBoard("GreatDeal");
        assertEquals(boardPage.isBoardCreated().getText(), "доска");
    }

    @Test(priority = 2, description = "lists should be created")
    public void listShouldBeCreated() {
        enterPage
                .openPage()
                .isPageOpened()
                .startAndEnter();
        loginPage
                .openPage()
                .isPageOpened()
                .login();
        assertEquals(loginPage.isUserLogined().getText(), "Viktoryia");
        mainPage
                .isPageOpened()
                .choosingBoard("GreatDeal");
        assertEquals(mainPage.isCorrectBoardChosen().getText(), "GreatDeal");
        boardPage
                .isPageOpened()
                .firstList()
                .createList("Нужно сделать")
                .createList("В процессе")
                .createList("Готово");
        assertEquals(boardPage.isListCreated("Нужно сделать").getText(), "Нужно сделать");
        assertEquals(boardPage.isListCreated("В процессе").getText(), "В процессе");
        assertEquals(boardPage.isListCreated("Готово").getText(), "Готово");
    }

    @Test(priority = 3, description = "cards should be created")
    public void cardShouldBeCreated() {
        enterPage
                .openPage()
                .isPageOpened()
                .startAndEnter();
        loginPage
                .openPage()
                .isPageOpened()
                .login();
        assertEquals(loginPage.isUserLogined().getText(), "Viktoryia");
        mainPage
                .isPageOpened()
                .choosingBoard("GreatDeal");
        boardPage
                .isPageOpened()
                .createCard("Дело №36", 0)
                .createCard("Дело №24", 1)
                .createCard("Дело №16", 2)
                .createCard("Дело №58", 0);
        assertEquals(boardPage.isCardCreated("Дело №36").getText(), "Дело №36");
        assertEquals(boardPage.isCardCreated("Дело №24").getText(), "Дело №24");
        assertEquals(boardPage.isCardCreated("Дело №16").getText(), "Дело №16");
        assertEquals(boardPage.isCardCreated("Дело №58").getText(), "Дело №58");
    }

    @Test(priority = 4, description = "list should be copied and created")
    public void listShouldBeCopiedAndCreated() {
        enterPage
                .openPage()
                .isPageOpened()
                .startAndEnter();
        loginPage
                .openPage()
                .isPageOpened()
                .login();
        assertEquals(loginPage.isUserLogined().getText(), "Viktoryia");
        mainPage
                .isPageOpened()
                .choosingBoard("GreatDeal");
        boardPage
                .isPageOpened()
                .copyingAndCreatingNewList(2, "Совсем готово")
                .copyingAndCreatingNewList(1, "Завершённые процессы");
        assertEquals(boardPage.isListCreated("Совсем готово").getText(), "Совсем готово");
        assertEquals(boardPage.isListCreated("Завершённые процессы").getText(), "Завершённые процессы");
    }

    @Test(priority = 4, description = "signature should be exist")
    public void signature() {
        enterPage
                .openPage()
                .isPageOpened()
                .startAndEnter();
        loginPage
                .openPage()
                .isPageOpened()
                .login();
        assertEquals(loginPage.isUserLogined().getText(), "Viktoryia");
        mainPage
                .isPageOpened()
                .choosingBoard("GreatDeal");
        boardPage
                .isPageOpened()
                .signatureAtCard(0)
                .isSignatureExist();

    }

    @Test(priority = 4, description = "board should be deleted")
    public void boardShouldBeDeleted() {
        enterPage
                .openPage()
                .isPageOpened()
                .startAndEnter();
        loginPage
                .openPage()
                .isPageOpened()
                .login();
        assertEquals(loginPage.isUserLogined().getText(), "Viktoryia");
        mainPage
                .isPageOpened()
                .choosingBoard("GreatDeal");
        boardPage
                .isPageOpened()
                .deleteBoard();
        assertEquals(boardPage.isBoardDeleted().getText(), "Доска не найдена.");
    }
}
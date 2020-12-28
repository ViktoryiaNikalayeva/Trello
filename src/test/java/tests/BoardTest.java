package tests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoardTest extends BaseTest {

    @Step("Board should be created")
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

    @Step("Lists should be created")
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

    @Step("Cards should be created")
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

    @Step("List should be copied and created")
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

    @Step("Check that signature exist")
    @Test(priority = 5, description = "signature should be exist")
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

    @Step("Card: add mark, write checklist, create template and card as a template")
    @Test(priority = 6, description = "card should be archived and deleted")
    public void actionsWithCard() {
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
                .cardActions("Дело №58");
    }


    @Step("Card should be archived and deleted")
    @Test(priority = 7, description = "card should be archived and deleted")
    public void cardShouldBeArchivedAndDeleted() {
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
                .archiveAndDeleteCard("Дело №36");
    }
    @Step("List should be archive")
    @Test(priority = 8, description = "list should be archived")
    public void listShouldBeArchived() {
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
                .archiveList(0)
                .isListArchived();
    }

    @Step("Board should be deleted")
    @Test(priority = 9, description = "board should be deleted")
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
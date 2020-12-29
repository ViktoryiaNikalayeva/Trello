package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class BoardPage {

    public static final String URL = "https://trello.com/nfrj6";
    public static final String PAGE_OPEN = "[class ='org-label']";
    public static final String CREATE_LIST_INPUT = "input[name='name']";
    public static final String CREATE_LIST_BUTTON = "input[value='Add another list']";
    public static final String CREATE_CARD_BUTTON = "card-composer-container";
    public static final String CARD_NAME_INPUT = "list-card-composer-textarea";
    public static final String CREATE_CARD_FINISH = "input[value ='Add a card']";
    public static final String LIST_DROPDOWN = "list-header-extras-menu";
    public static final String COPY_LIST_OPT = "js-copy-list";
    public static final String NEW_LIST_NAME_INPUT = "[class='js-autofocus']";
    public static final String CREATE_NEW_LIST_BUTTON = "input[value='Enter list title...']";
    public static final String SIGNATURE_CLICK = "highlight-icon";
    public static final String DELETE_BUTTON_START = "More";
    public static final String CLOSE_STEP_1 = "Close Board…";
    public static final String CLOSE_STEP_2 = "input[value = 'Close']";
    public static final String CLOSE_STEP_3 = "Permanently Delete Board…";
    public static final String CLOSE_BUTTON_FINISH = "input[value = 'Delete']";
    public static final String BOARD_CREATE = "Board";
    public static final String FIRST_LIST_INPUT_ON = "placeholder";
    public static final String SIGNATURE = "icon-sm";
    public static final String DELETE_BOARD_TRUE = "Board not found.";
    public static final String ARCHIVE = "Hide from list";
    public static final String DELETE = "Delete";
    public static final String ARCHIVE_LIST = "js-close-list";
    public static final String CHECKLIST = "Checklist";
    public static final String ADD_BUTTON = "Add";
    public static final String CHECKLIST_INPUT = "[placeholder = 'Add an item']";
    public static final String MARKS = "Labels";
    public static final String ORANGE_COLOR = "[data-color = 'orange']";
    public static final String YELLOW_COLOR = "[data-color = 'orange']";
    public static final String NEW_MARK = "Create a new label";
    public static final String MARK_DESCRIPTION = "labelName";
    public static final String BLACK_COLOR = "[data-color = 'black']";
    public static final String CREATE = "Create";
    public static final String CREATE_TEMPLATE = "Template";
    public static final String CARD_AS_TEMPLATE = ("Create Card from Template");
    public static final String LIST_ARCHIVE_TRUE = "Нужно сделать";

    @Step("open BoardPage https://trello.com/board")
    public BoardPage openPage() {
        open(URL);
        return this;
    }

    @Step("check that page https://trello.com/board")
    public BoardPage isPageOpened() {
        $(byCssSelector(PAGE_OPEN)).waitUntil(Condition.visible, 30000, 500);
        return this;
    }

    public BoardPage firstList() {
        $(byClassName(FIRST_LIST_INPUT_ON)).waitUntil(Condition.visible, 30000, 500).click();
        return this;
    }

    public BoardPage createList(String listName) {
        log.info("enter name of list");
        $(byCssSelector(CREATE_LIST_INPUT)).sendKeys(listName);
        $(byCssSelector(CREATE_LIST_BUTTON)).click();
        return this;
    }

    public BoardPage createCard(String cardName, int numberOfList) {
        log.info("choose the list and start create card");
        $$(byClassName(CREATE_CARD_BUTTON)).get(numberOfList).click();
        log.info("enter name of card");
        $(byClassName(CARD_NAME_INPUT)).sendKeys(cardName);
        $(byCssSelector(CREATE_CARD_FINISH)).click();
        return this;
    }

    public BoardPage copyingAndCreatingNewList(int numberOfList, String newListName) {
        log.info("choose the list and start copy list");
        $$(byClassName(LIST_DROPDOWN)).get(numberOfList).click();
        $(byClassName(COPY_LIST_OPT)).click();
        log.info("rename list");
        $(byCssSelector(NEW_LIST_NAME_INPUT)).sendKeys(newListName);
        $(byCssSelector(CREATE_NEW_LIST_BUTTON)).click();
        return this;
    }

    public BoardPage signatureAtCard(int numberOfList) {
        log.info("choose the list and start check signature");
        $$(byClassName(LIST_DROPDOWN)).get(numberOfList).click();
        $(byClassName(SIGNATURE_CLICK)).click();
        return this;
    }

    public BoardPage archiveAndDeleteCard(String cardName) {
        log.info("start to archive card");
        $(byText(cardName)).click();
        $(byTitle(ARCHIVE)).click();
        $(byText(DELETE)).click();
        $(byValue(DELETE)).click();
        $(byText(cardName)).shouldNot(exist);
        return this;
    }

    public BoardPage cardActions(String cardName) {
        $(byText(cardName)).click();
        log.info("actions with Card: create checklist");
        $(byLinkText(CHECKLIST)).click();
        $(byValue(ADD_BUTTON)).click();
        $(byCssSelector(CHECKLIST_INPUT)).sendKeys("Пункт 1");
        $(byValue(ADD_BUTTON)).click();
        $(byCssSelector(CHECKLIST_INPUT)).sendKeys("Пункт 2");
        $(byValue(ADD_BUTTON)).click();
        $(byCssSelector(CHECKLIST_INPUT)).sendKeys("Пункт 3");
        $(byValue(ADD_BUTTON)).click();
        log.info("start to make actions with Card: make mark");
        $(byLinkText(MARKS)).click();
        $(byCssSelector(ORANGE_COLOR)).click();
        $(byCssSelector(YELLOW_COLOR)).click();
        log.info("start to make actions with Card: create new mark");
        $(byText(NEW_MARK)).click();
        $(By.id(MARK_DESCRIPTION)).sendKeys("Приоритетно");
        $(byCssSelector(BLACK_COLOR)).click();
        $(byValue(CREATE)).click();
        log.info("actions with Card: make this example as a template");
        $(byLinkText(CREATE_TEMPLATE)).click();
        $(byText(CARD_AS_TEMPLATE)).click();
        return this;
    }

    public BoardPage archiveList(int numberOfList) {
        log.info("start to archive list");
        $$(byClassName(LIST_DROPDOWN)).get(numberOfList).click();
        $(byClassName(ARCHIVE_LIST)).click();

        return this;
    }

    public BoardPage deleteBoard() {
        log.info("start to delete board");
        $(byText(DELETE_BUTTON_START)).click();
        $(byText(CLOSE_STEP_1)).click();
        $(byCssSelector(CLOSE_STEP_2)).click();
        $(byText(CLOSE_STEP_3)).click();
        $(byCssSelector(CLOSE_BUTTON_FINISH)).click();
        return this;
    }

    public WebElement isBoardCreated() {
        return $(byText(BOARD_CREATE));

    }

    public WebElement isListCreated(String listName) {
        return $(byCssSelector("[aria-label = '" + listName + "']"));
    }

    public WebElement isCardCreated(String cardName) {
        return $(byText(cardName));

    }

    public void isSignatureExist() {
        $(byClassName(SIGNATURE)).should(exist);

    }

    public WebElement isBoardDeleted() {
        return $(byText(DELETE_BOARD_TRUE));
    }

    public WebElement isListArchived() {
        return $(byText(LIST_ARCHIVE_TRUE)).shouldNot(exist);
    }
}

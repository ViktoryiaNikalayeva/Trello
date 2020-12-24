package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BoardPage {

    public static final String URL = "https://trello.com/nfrj6";
    public static final String PAGE_OPEN = "[class ='org-label']";
    public static final String CREATE_LIST_INPUT = "input[name='name']";
    public static final String CREATE_LIST_BUTTON = "input[value='Добавить список']";
    public static final String CREATE_CARD_BUTTON = "card-composer-container";
    public static final String CARD_NAME_INPUT = "list-card-composer-textarea";
    public static final String CREATE_CARD_FINISH = "input[value ='Добавить карточку']";
    public static final String CARD_DROPDOWN = "list-header-extras-menu";
    public static final String COPY_LIST_OPT = "js-copy-list";
    public static final String NEW_LIST_NAME_INPUT = "[class='js-autofocus']";
    public static final String CREATE_NEW_LIST_BUTTON = "input[value='Создать список']";
    public static final String SIGNATURE_CLICK = "highlight-icon";
    public static final String DELETE_BUTTON_START = "Ещё";
    public static final String CLOSE_STEP_1 = "Закрыть доску…";
    public static final String CLOSE_STEP_2 = "input[value = 'Закрыть']";
    public static final String CLOSE_STEP_3 = "Безвозвратное удаление доски…";
    public static final String CLOSE_BUTTON_FINISH = "input[value = 'Удалить']";
    public static final String BOARD_CREATE = "доска";
    public static final String FIRST_LIST_INPUT_ON = "placeholder";
    public static final String SIGNATURE = "icon-sm";
    public static final String DELETE_BOARD_TRUE = "Доска не найдена.";

    public BoardPage openPage() {
        open(URL);
        return this;
    }

    public BoardPage isPageOpened() {
        $(byCssSelector(PAGE_OPEN)).waitUntil(Condition.visible, 20000);
        return this;
    }

    public BoardPage firstList() {
        $(byClassName(FIRST_LIST_INPUT_ON)).click();
        return this;
    }

    public BoardPage createList(String listName) {
        $(byCssSelector(CREATE_LIST_INPUT)).sendKeys(listName);
        $(byCssSelector(CREATE_LIST_BUTTON)).click();
        return this;
    }

    public BoardPage createCard(String cardName, int numberOfList) {
        $$(byClassName(CREATE_CARD_BUTTON)).get(numberOfList).click();
        $(byClassName(CARD_NAME_INPUT)).sendKeys(cardName);
        $(byCssSelector(CREATE_CARD_FINISH)).click();
        return this;
    }

    public BoardPage copyingAndCreatingNewList(int numberOfList, String newListName) {
        $$(byClassName(CARD_DROPDOWN)).get(numberOfList).click();
        $(byClassName(COPY_LIST_OPT)).click();
        $(byCssSelector(NEW_LIST_NAME_INPUT)).sendKeys(newListName);
        $(byCssSelector(CREATE_NEW_LIST_BUTTON)).click();
        return this;
    }


    public BoardPage signatureAtCard(int numberOfList) {
        $$(byClassName(CARD_DROPDOWN)).get(numberOfList).click();
        $(byClassName(SIGNATURE_CLICK)).click();
        return this;
    }

    public BoardPage deleteBoard() {
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
}

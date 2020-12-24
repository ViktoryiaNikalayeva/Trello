package pages;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {

    public static final String URL = "https://trello.com/viktoryia_/boards";
    public static final String PAGE_OPEN = "_3qwe2tMMFonNvf";
    public static final String CREATE_TEAM_START = "_33CvMKqfH4Yf0j";
    public static final String TEAM_NAME_INPUT = "_1CLyNodCAa-vQi";
    public static final String TYPE_TEAM_DROPDOWN = "css-iikl2v";

    public static final String TEAM_TYPE(String teamType) {
        return ("//*[text()='" + teamType + "']");
    }

    public static final String DESCRIPTION = "_15aIJYNKhrO4vB";
    public static final String CREATE_TEAM_CLICK = "_1aS0LdGertk5P7";
    public static final String PARTICIPANT_INPUT = "autocomplete-input";
    public static final String PARTICIPANT_CLICK = "[data-test-id = 'team-invite-submit-button']";
    public static final String CREATE_BOARD_START = "Создать доску";
    public static final String BOARD_NAME_INPUT = "_23NUW98LaZfBpQ";
    public static final String CREATE_BOARD_FINISH = "//*[@class= '_2SGKaE34Vsusf2']/child::button";
    public static final String TEAM_CREATE_TRUE = "_2DZdmHnY2Nw7gI";
    public static final String CORRECT_BOARD_TRUE = "//h1[@dir = 'auto']";

    public MainPage openPage() {
        open(URL);
        return this;
    }

    public MainPage isPageOpened() {
        $(byClassName(PAGE_OPEN)).waitUntil(exist, 24000);
        return this;
    }

    public void createTeam(String teamName, String description, String teamType, String participant) {
        $(byClassName(CREATE_TEAM_START)).click();
        $(byClassName(TEAM_NAME_INPUT)).sendKeys(teamName);
        $(byClassName(TYPE_TEAM_DROPDOWN)).click();
        $(byXpath(TEAM_TYPE(teamType))).click();
        $(byClassName(DESCRIPTION)).setValue(description);
        $(byClassName(CREATE_TEAM_CLICK)).click();
        $(byClassName(PARTICIPANT_INPUT)).sendKeys(participant);
        $(byCssSelector(PARTICIPANT_CLICK)).click();
    }

    public BoardPage createBoard(String boardName) {
        $(byText(CREATE_BOARD_START)).click();
        $(byClassName(BOARD_NAME_INPUT)).sendKeys(boardName);
        $(byXpath(CREATE_BOARD_FINISH)).click();
        return new BoardPage();
    }

    public WebElement isTeamCreated() {
        return $(byClassName(TEAM_CREATE_TRUE));
    }

    public MainPage choosingBoard(String boardName) {
        $(byXpath("//div[@title =" + boardName + "]")).click();
        return this;
    }
    public WebElement isCorrectBoardChosen() {
        return $(byXpath(CORRECT_BOARD_TRUE));
    }
}

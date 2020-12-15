package pages;


import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {

    public static final String URL = "https://trello.com/viktoryia_/boards";


    public MainPage openPage() {
        open(URL);
        return this;
    }

    public MainPage isPageOpened() {
            $(byClassName("_3qwe2tMMFonNvf")).waitUntil(exist, 24000);
        return this;
    }

    public void createTeam() {
        $(byXpath("//span[@class='icon-add icon-sm _2aV_KY1gTq1qWc']")).click();
        $(byClassName("_1CLyNodCAa-vQi")).setValue("DreamTeam");
        $(byClassName("css-iikl2v")).click();
//        $$(byClassName("css-1h40s7-control _1T1MG_BX1zeaq8")).get(2).click();
        $(byClassName("_15aIJYNKhrO4vB")).setValue("Team for test");
        $(byClassName("X1P6DVryq8CYGC voB8NatlbuEme5 _21upOlzpUQJcdT _2srCG79MESAdFL")).click();
        $(byId("add-members-input")).setValue("n77@mailinator.com");
        $(byId("team-invite-submit-button")).click();
        $(byClassName("_3Ea60-0nkKsQ4D")).should(exist);
    }
}

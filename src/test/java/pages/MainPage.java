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
        $(byXpath("//*[text()='Маркетинг']")).click();
        $(byClassName("_15aIJYNKhrO4vB")).setValue("Team for test");
        $(byClassName("_1aS0LdGertk5P7")).click();
        $(byClassName("autocomplete-input")).sendKeys("n77@mailinator.com");
        $(byXpath("//button[@data-test-id = 'team-invite-submit-button']")).click();
        $(byClassName("_3Ea60-0nkKsQ4D")).should(exist);
    }

    public BoardPage createBoard() {
        $(byClassName("_3qwe2tMMFonNvf")).click();
        $(byText("Создать доску")).click();
        $(byClassName("_23NUW98LaZfBpQ")).sendKeys("GreatDeal");
        $(byXpath("//*[@class= '_2SGKaE34Vsusf2']/child::button")).click();
        $(byXpath("//span[@class ='org-label']")).should(exist);
        return new BoardPage();
    }


}

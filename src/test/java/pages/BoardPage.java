package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BoardPage {

    public static final String URL = "https://trello.com/nfrj6";

    public BoardPage openPage() {
        open(URL);
        return this;
    }

    public BoardPage isPageOpened() {
        $(byXpath("//span[@class ='org-label']")).waitUntil(Condition.visible, 20000);
        return this;
    }

    public BoardPage createLists() {
        $(byXpath("//input[@name='name']")).sendKeys("Нужно сделать");
        $(byXpath("//input[@value='Добавить список']")).click();
        $(byXpath("//input[@name='name']")).sendKeys("В процессе");
        $(byXpath("//input[@value='Добавить список']")).click();
        $(byXpath("//input[@name='name']")).sendKeys("Готово");
        $(byXpath("//input[@value='Добавить список']")).click();
        return this;

    }

    public BoardPage createCards() {
        $$(byClassName("card-composer-container")).get(0).click();
        $(byClassName("list-card-composer-textarea")).sendKeys("Дело №32");
        $(byXpath("//*[@value = 'Добавить карточку']")).click();

        $$(byClassName("card-composer-container")).get(1).click();
        $(byClassName("list-card-composer-textarea")).sendKeys("Дело №24");
        $(byXpath("//*[@value = 'Добавить карточку']")).click();

        $$(byClassName("card-composer-container")).get(2).click();
        $(byClassName("list-card-composer-textarea")).sendKeys("Дело №16");
        $(byXpath("//*[@value = 'Добавить карточку']")).click();

        $(byClassName("_32kNZW8b-DAcUd")).click();
        $$(byClassName("list-header-extras-menu")).get(0).click();
        $$(byClassName("pop-over-list")).get(0).click();
        $(byClassName("list-card-composer-textarea")).sendKeys("Дело №58");
        $(byXpath("//*[@value = 'Добавить карточку']")).click();

       $$(byClassName("list-header-extras-menu")).get(1).click();
       $(byClassName("js-add-card")).click();
       $(byClassName("list-card-composer-textarea")).sendKeys("Дело №45");
       $(byXpath("//*[@value = 'Добавить карточку']")).click();
        return this;
    }

    public BoardPage copyAndCreatingNewList() {
        $$(byClassName("list-header-extras-menu")).get(2).click();
        $(byClassName("js-copy-list")).click();
        $(byClassName("s-autofocus")).sendKeys("Совсем готово");
        $$(byClassName("list-header-extras-menu")).get(1).click();
        $(byClassName("js-copy-list")).click();
        $(byClassName("s-autofocus")).sendKeys("В процессе 'База'");
        return this;
    }

    public BoardPage moveLocationOfTheList() {
        $$(byClassName("list-header-extras-menu")).get(4).click();
        $(byClassName("js-move-list")).click();
        $$(byClassName("js-select-list-pos")).get(1).click();
        return this;
    }

    public BoardPage signatureAtCard() {
        $$(byClassName("list-header-extras-menu")).get(0).click();
        $(byClassName("highlight-icon")).click();
        $$(byClassName("list-header-extras-subscribe")).get(0).should(exist);
        return this;
    }

    public BoardPage deleteBoards() {
        $(byClassName("board-menu-navigation-item-link")).click();
        $(byClassName("highlight-icon")).click();
        $$(byClassName("list-header-extras-subscribe")).get(0).should(exist);
        return this;
    }


}

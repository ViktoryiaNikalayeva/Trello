package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EnterPage extends BasePage {

    public static final String ENTER_BUTTON = "Войти";
    public static final String PAGE_OPEN = "[class = 'lead']";
    public static final String URL = "https://trello.com";

    public EnterPage openPage()  {
        open(URL);
        return this;
    }

    public EnterPage isPageOpened() {
        $(byCssSelector(PAGE_OPEN)).waitUntil(Condition.visible, 20000);
        return this;
    }

    public EnterPage startAndEnter() {
        $(byText(ENTER_BUTTON)).click();
        return this;
    }
}
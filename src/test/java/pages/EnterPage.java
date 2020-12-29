package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class EnterPage extends BasePage {

    public static final String ENTER_BUTTON = "Log In";
    public static final String PAGE_OPEN = "[class = 'lead']";
    public static final String URL = "https://trello.com";

    @Step("open EnterPage trello.com")
    public EnterPage openPage()  {
        open(URL);
        return this;
    }

    @Step("check that page trello.com is opened")
    public EnterPage isPageOpened() {
        $(byCssSelector(PAGE_OPEN)).waitUntil(exist, 30000, 500);
        return this;
    }

    @Step("go to LoginPage")
    public LoginPage startAndEnter() {
        $(byText(ENTER_BUTTON)).click();
        return new LoginPage();
    }
}
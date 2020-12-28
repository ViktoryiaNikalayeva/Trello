package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class EnterPage extends BasePage {

    public static final String ENTER_BUTTON = "Войти";
    public static final String PAGE_OPEN = "[class = 'lead']";
    public static final String URL = "https://trello.com";

    public EnterPage openPage()  {
        log.fatal("open EnterPage trello.com");
        open(URL);
        return this;
    }

    public EnterPage isPageOpened() {
        log.info("check that page trello.com is opened");
        $(byCssSelector(PAGE_OPEN)).waitUntil(exist, 30000, 500);
        return this;
    }

    public LoginPage startAndEnter() {
        log.info("go to LoginPage");
        $(byText(ENTER_BUTTON)).click();
        return new LoginPage();
    }
}
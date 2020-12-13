package pages;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage {
    public MainPage openPage() {
        open("https://trello.com/viktoryia_/boards");
        return this;
    }

    public MainPage isPageOpened() {
        try {
            $(byText("Участники")).should(exist);
        } catch (TimeoutException Ex) {
            Assert.fail("Страница не загрузилась, т.к. не появились 'Участники'");
        }
        return this;
    }

}

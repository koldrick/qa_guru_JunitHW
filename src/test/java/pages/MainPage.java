package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {


    private final SelenideElement creditPrice = $("[data-test='realty_price_input']");
    private final SelenideElement creditFee = $("[data-test='initial_fee_input']");
    private final SelenideElement creditPeriod = $("[data-test='period_select']");
    private final SelenideElement creditRate = $("[data-test='rate_input']");
    private final SelenideElement creditResult = $("[data-test='table_results']");
    private final SelenideElement mainMenu = $("[data-test='main-menu-sections']");
    private final SelenideElement headerToolBar = $("[data-test='header']");

    public MainPage openCalcPage() {
        open("services/calculators/hypothec/");
        return this;
    }

    public MainPage openMainPage() {
        open("");
        return this;
    }


    public MainPage setCreditPrice(String realtyPrice) {
        $(creditPrice).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
        $(creditPrice).sendKeys(realtyPrice);
        return this;
    }

    public MainPage setCreditFee(String initialFee) {
        $(creditFee).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
        $(creditFee).sendKeys(initialFee);
        return this;
    }

    public MainPage setCreditPeriod(String period) {
        $(creditPeriod).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
        $(creditPeriod).sendKeys(period);
        return this;
    }

    public MainPage setCreditRate(String rate) {
        $(creditRate).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
        $(creditRate).sendKeys(rate);
        return this;
    }

    public MainPage checkResult(String payment) {
        $(creditResult).shouldHave(text(payment));
        return this;
    }

    public MainPage checkUnrealResult(String payment) {
        $(creditResult).shouldHave(text(payment));
        return this;
    }

    public MainPage openTab(String webPage) {
        $(mainMenu).$(byText(webPage)).click();
        return this;
    }

    public MainPage checkHeaderIsVisible() {
        $(headerToolBar).shouldBe(visible);
        return this;
    }



}

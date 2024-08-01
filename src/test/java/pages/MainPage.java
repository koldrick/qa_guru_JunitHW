package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    public final SelenideElement creditPrice = $("[data-test='realty_price_input']");
    public final SelenideElement creditFee = $("[data-test='initial_fee_input']");
    public final SelenideElement creditPeriod = $("[data-test='period_select']");
    public final SelenideElement creditRate = $("[data-test='rate_input']");
    public final SelenideElement creditResult = $("[data-test='table_results']");

    public void openPage() {
        open("");
    }


    public void clearCreditPrice() {
        $(creditPrice).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
    }
    public void clearCreditFee() {
        $(creditFee).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
    }
    public void clearCreditPeriod() {
        $(creditPeriod).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
    }
    public void clearCreditRate() {
        $(creditRate).sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
    }

}

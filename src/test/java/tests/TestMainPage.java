package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class TestMainPage extends TestBase{

    MainPage mainPage = new MainPage();

    @ParameterizedTest(name = "Проверяем что при стоимости - {0}, взносе - {1}, сроке - {2}, ставке - {3}, получаем ежемесячный платеж - {4}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB"),
            @Tag("SMOKE"),
    })
    @CsvFileSource(resources = "/test_data/calcShouldBeCorrect.csv")
    void calcShouldBeCorrect(String realtyPrice, String initialFee, String period, String rate, String payment) {
        mainPage.openPage();
        mainPage.clearCreditPrice();
        $(mainPage.creditPrice).sendKeys(realtyPrice);
        mainPage.clearCreditFee();
        $(mainPage.creditFee).sendKeys(initialFee);
        mainPage.clearCreditPeriod();
        $(mainPage.creditPeriod).sendKeys(period);
        mainPage.clearCreditRate();
        $(mainPage.creditRate).sendKeys(rate);
        $(mainPage.creditResult).shouldHave(text(payment));
    }


        @Disabled("Тест отключен пока мы не начнем раздавать деньги")
        @Test
        void calcShouldGiveFreeMoney() {
            mainPage.openPage();
            mainPage.clearCreditPrice();
            $(mainPage.creditPrice).sendKeys("1 000 000 000");
            mainPage.clearCreditFee();
            $(mainPage.creditFee).sendKeys("0");
            mainPage.clearCreditPeriod();
            $(mainPage.creditPeriod).sendKeys("0");
            mainPage.clearCreditRate();
            $(mainPage.creditRate).sendKeys("0");
            $(mainPage.creditResult).shouldHave(text("Мы сами вам заплатим"));

        }



}
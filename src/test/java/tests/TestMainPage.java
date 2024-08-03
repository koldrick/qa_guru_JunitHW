package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;


public class TestMainPage extends TestBase {

    MainPage mainPage = new MainPage();

    @ParameterizedTest(name = "Проверяем что при стоимости - {0}, взносе - {1}, сроке - {2}, ставке - {3}, получаем ежемесячный платеж - {4}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB"),
            @Tag("SMOKE"),
    })
    @CsvFileSource(resources = "/test_data/calcShouldBeCorrect.csv")
    void calcShouldBeCorrect(String realtyPrice, String initialFee, String period, String rate, String payment) {
        mainPage.openCalcPage()
                .setCreditPrice(realtyPrice)
                .setCreditFee(initialFee)
                .setCreditPeriod(period)
                .setCreditRate(rate)
                .checkResult(payment);
    }



    @Disabled("Пока не начнем раздавть деньги")
    @ParameterizedTest(name = "Проверяем, что начали раздавать бесплатные деньги, выдали {0} руб")
    @Tag("WEB")
    @CsvSource({
            "52000000, 0, 0, 0, Бесплатные деньги!",
            "100000000, 0, 0, 0, Бесплатные деньги!",
            "2342324, 0, 0, 0,Бесплатные деньги!"
    })

    void calcShouldGiveFreeMoney(String realtyPrice, String initialFee, String period, String rate, String payment) {
        mainPage.openCalcPage()
                .setCreditPrice(realtyPrice)
                .setCreditFee(initialFee)
                .setCreditPeriod(period)
                .setCreditRate(rate)
                .checkUnrealResult(payment);
    }



    @ParameterizedTest(name = "Проверяем, что начали раздавать бесплатные деньги, выдали {0} руб")
    @Tag("WEB")
    @ValueSource(strings = {
            "Вклады","Займы","Карты"
    })
    void tabsShouldOpen(String webPage) {
        mainPage.openMainPage()
                .openTab(webPage)
                .checkHeaderIsVisible();

    }


}
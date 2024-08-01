package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl= "https://www.banki.ru/services/calculators/hypothec/";
        Configuration.pageLoadStrategy = "eager";

    }
}

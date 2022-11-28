package org.zayac;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class ParameterizedTestsCsvSource {
    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("https://stroybatinfo.ru/");
    }
    @Disabled("Task-12345")
    @DisplayName("Проверка работы кнопки Поиск")
    @Test
    @Tag("BLOKER")
    void testSearchButton() {
        $(".api-search-input").sendKeys("УШМ");
        $("[type=submit]").click();
    }
    @CsvSource(value = {
            "УШМ, Шлифовальные машины угловые",
            "шуруповерт, Аккумуляторные шуруповерты"
    })
    @ParameterizedTest(name = "Проверка наличия нужной категории {1}" +
            "в результатах выдачи поиска по запросу {0}")
    @Tags({@Tag("BLOCKER"), @Tag("FEATURE")})
    void stroybatSearchTest(String value, String result) {
        $(".api-search-input").sendKeys(value);
        $("[type=submit]").click();
        $(".sid_search").shouldHave(text(result));
    }
}

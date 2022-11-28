package org.zayac;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParameterizdeTestTwo {

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("https://rivegauche.ru/");
    }
    @Disabled("Task-12345")
    @CsvFileSource(resources = "src/test/resources/country.csv")
    @ParameterizedTest(name = "Проверка изменения страны на {0}")
    void parameterizdeTestTwo(String country) {
    $("[icon=location]").click();
    $(".ng-arrow-wrapper").click();
    $(byText(country)).click();
    $(".ng-value-container").shouldHave(text(country));
    }
    @ValueSource(strings = {"Беларусь", "Казахстан"})
    @ParameterizedTest(name = "Проверка изменения страны на {0}")
    void parameterizdeTest(String arg) {
        $("[icon=location]").click();
        $(".ng-arrow-wrapper").click();
        $(byText(arg)).click();
        $(".ng-value-container").shouldHave(text(arg));
    }
}

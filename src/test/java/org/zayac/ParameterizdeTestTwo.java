package org.zayac;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ParameterizdeTestTwo {

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("https://rivegauche.ru/");
    }

    @CsvFileSource(resources = "src/test/resources/country.csv")
    @ParameterizedTest(name = "Проверка изменения страны на {0}")
    void ParameterizdeTestTwo(String country) {
    $("[icon=location]").click();
    $(".ng-arrow-wrapper").click();
    $(byText(country)).click();


    }

}

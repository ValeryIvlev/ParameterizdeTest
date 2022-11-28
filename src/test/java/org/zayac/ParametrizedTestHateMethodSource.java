package org.zayac;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedTestHateMethodSource {

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("https://vk.com/");
    }
    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("English", List.of("About VK Terms Developers")),
                Arguments.of("Русский", List.of("О ВКонтакте Правила Для бизнеса Разработчикам"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "хз как тебя пока назвать")
    void methodSource(String locale, List<String> buttons) {
        $(".footer_lang").$(byText(locale)).click();
        $$(".footer_links").filter(visible)
                .shouldHave(CollectionCondition.texts(buttons));
    }
    @Disabled("Task-12345")
    @Test
    void metodTest() {
    $(".footer_lang").$(byText("English")).click();
    $(".footer_links").shouldHave(text("О ВКонтакте"));

    }

}

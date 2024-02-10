package QAGU;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static jdk.internal.misc.ThreadFlock.open;

public class _12_Less_JUnitSimpleTest {
    @DisplayName("Демонстрационный тест")
    @Test
    void simpleTest() {
        Assertions.assertTrue(3 > 2);
    }

    @BeforeEach
    void setUp() {
        open("https://google.com");
    }

    @CsvSource({
            "Allure testops, https://qameta.io",
            "Selenide, https://selenide.org"
    })
    // OR!!!
    @CsvFileSource(resources = "/testData.csv")
    // или @CsvFileSource(files = "src/test/resources/testData.csv")
    @ParameterizedTest(name = "Адрес {1} должен быть в выдаче гугла по запросу {0}")
    //
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void productSiteUrlShouldBePresentInResultsOfSearchInGoggleByProductNameQuery(
            String productName,
            String productUrl
    ) {
        $("[name=q]").setValue(productName).pressEnter();
        $("[id=search]").shouldHave(text(productUrl));
    }

    @ValueSource(
            strings = {"Allure testops", "Selenide"}
    )
    @ParameterizedTest(name = "Адрес {1} должен быть в выдаче гугла по запросу {0}")
    //
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void searchResultsCountTest(String productName) {
        $("[name=q]").setValue(productName).pressEnter();
        $$("div[class='g']").shouldHave(CollectionCondition.sizeGreaterThan(5));
    }


    void selenideSiteShouldContainAllOfButtonsForGivenLocale(
            Locale locale,
            List<String> buttons
    ) {

    }

}

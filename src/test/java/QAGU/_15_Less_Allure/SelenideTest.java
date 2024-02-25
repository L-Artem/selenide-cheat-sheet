package QAGU._15_Less_Allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    //

    @Test
    public void testIssueSearch() {

        Configuration.holdBrowserOpen = true;

        open("https://github.com/");
        $("span.flex-1").click();
        $("input#query-builder-test").sendKeys("eroshenkoam/allure-example");
        actions().sendKeys(Keys.ENTER).perform();

        $(linkText("eroshenkoam/allure-example")).click();
        $("a#issues-tab").click();
        $(withText("#80")).should(Condition.exist);
    }
}

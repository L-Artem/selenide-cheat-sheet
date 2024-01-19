import com.codeborne.selenide.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class TestClass {

    @Test
    public void frstTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate parse = LocalDate.parse("22.10.2023", formatter);


        parse.getDayOfWeek();

        assertEquals(DayOfWeek.FRIDAY, parse.getDayOfWeek());

    }

    @Test
    public void fratSelenide() {

        String pathDriver = "C:\\Git.Selenium\\selenide-cheat-sheet\\resources\\yandexdriver\\yandexdriver.exe";
        String pathBrowser = "C:\\Users\\Artem\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";

        System.setProperty("webdriver.chrome.driver", pathDriver);
        Configuration.browserBinary = pathBrowser;
        Configuration.browserSize = "1920x1080";
        open("https://github.com/");
        //элемент
        //$("")
        // коллекция элементов
        //$$()
        $("[type=button].header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        $$("div[data-testid=results-list]").first().$("a").click();
        //$$("div[data-testid=results-list] div a").get(3).click();
        //$("a[href*=selenide]").shouldHave(text("selenide")).click();

        //подвести мышку к первому аватару
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();

        //поставить выполнение в браузере на паузу F8

        sleep(5000);
    }
}

package QAGU;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

public class _03_TestClass {

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
        //css элемент
        //$("")
        //css коллекция элементов
        //$$()
        // xpath селектор
        //$x("")

        $("[type=button].header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        $$("div[data-testid=results-list]").first().$("a").click();
        //$$("div[data-testid=results-list] div a").get(3).click();
        //$("a[href*=selenide]").shouldHave(text("selenide")).click();

        //подвести мышку к первому аватару // аналог ancestor closest предок
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();

        //поставить выполнение в браузере на паузу F8
        // поставить выполнение на паузу, набрать в консоли
        //setTimeout(function(){debugger},4000)

        // клик по первому видимому элементу, если есть еще точно такой же невидимый (размер 0x0).
        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));

        //$(byText("popover")); - для поиска элементов
        //$(".popover").shouldHave(text("text")); - для проверок
        //$(".popover").shouldBe(visible);

        sleep(5000);
    }
}

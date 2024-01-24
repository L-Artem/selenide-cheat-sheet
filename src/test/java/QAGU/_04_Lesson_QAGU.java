package QAGU;

// https://github.com/qa-guru/

import com.codeborne.selenide.*;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// команды управления браузером
// https://the-internet.herokuapp.com/ примеры элементов

public class _04_Lesson_QAGU {

    @Test
    public void command_examples() {
        //open("https://the-internet.herokuapp.com/basic_auth");

        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        open("basic_auth"); // for CI/CD -Dselenide.baseUrl=https://the-internet.herokuapp.com

        open("/basic_auth", AuthenticationType.BASIC, new BasicAuthCredentials("", "user", "password"));
        open("/basic_auth/", AuthenticationType.BASIC, new BasicAuthCredentials("user", "password"));

        back();
        refresh();

        clearBrowserCookies();
        clearBrowserLocalStorage();
        executeJavaScript("sessionStorage.clear();");

        confirm(); // OK in alert dialog
        dismiss(); // Cancel in alert dialog

        closeWindow(); //close active tab
        closeWebDriver(); // close browser completely


        switchTo().frame("new"); //перейти во фрэйм на странице
        switchTo().defaultContent(); //выйти из фрейма в DOM.

        switchTo().window("name"); // переключение между вкладками

        var cookie = new Cookie("foo", "bar");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie); // устновить куки
    }

    void selectors_examples() {
        $("div").click();
        element("div").click(); //эквивалентно, для котлина

        $("div", 3).click(); //кликнуть 3-ий div

        $x("//h1/div").click();
        $("div").$x(".//h1").click(); //? перепроверить
        $(byXpath("//h1/div")).click();

        $(byText("text on the page")).click(); // элемент с отображаемым текстом
        $(withText("ext on the pag")).click(); // элемент с подстрокой

        $(byTagAndText("div", "text on the page")).click(); // текст в тэге div
        $(withTagAndText("div", "ext on the pag")).click(); // подстрока в тэге div

        $("div").parent().click(); // подняться на уровень вверх
        $("div").sibling(1).click(); // второй сосед ниже
        $("div").preceding(1).click(); // второй сосед выше
        $("div").closest("h3"); // найти ближайший предок h3
        $("div").ancestor("h3"); // тоже самое // найти ближайший предок h3
        $("div:last-child"); //поиск с учетом псевдоэлеменов, работают не все

        $("div").$("h1").find(byText("abc")).click(); //найти div, потом h1, потом элменет с текстом и кликнуть.
        // нельзя начинать с find

        $(byAttribute("name", "val")).click();
        $("[name=val]").click(); // эквивалентно

        $(byId("idName")).click();
        $("#idName").click(); // эквивалентно

        $(byClassName("className")).click();
        $(".className").click(); // эквивалентно

    }

    void actions_examples() {
        $("div").click();
        $("div").doubleClick();
        $("div").contextClick(); // правая кнопка мыши
        $("div").hover();
        $("div").setValue("text"); // все сотрет и напешет заново
        $("div").append("text"); // добавит в конец
        $("div").clear(); // не всегда работает
        $("div").setValue(""); // эквивалентно

        $("div").sendKeys("c"); // нажатие клавиши на элементе
        actions().sendKeys("c").perform(); // нажатие клавиши без привязки к элементу
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")); // комбинация клавиш ctrl+f
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f")); // эквивалентно

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();

        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform(); // драгэнддроп
        // переместить мышку на див,
        // зажать кнопку,
        // сместить вниз вправо,
        // отпустить (release)

        $("select").selectOption("text_name"); // классический дроп дауны
        $("select").selectOptionByValue("val");

        $("").selectRadio("radio)optins"); // классические радиокнопки
    }

    void assertions_examples() {
        // логически shouldBe/shouldHave/should одно и то же, нужно для более выразительного синтаксиса
        $("").shouldBe(visible);
        $("").shouldNotBe(visible);
        $("").shouldHave(text("abs"));
        $("").shouldNotHave(text("abc"));
        $("").should(appear);
        $("").shouldNot(appear);

        $("").shouldBe(visible, Duration.ofSeconds(30)); // определить тайм аут для ожидания отображения конкретного элемента
    }

    void conditions_examples() {
        $("").shouldBe(visible);
        $("").shouldBe(hidden);

        $("").shouldHave(text("abc")); // поиск по части
        $("").shouldHave(exactText("abc")); // точное совпадение
        $("").shouldHave(textCaseSensitive("abc")); // с учетом регистра
        $("").shouldHave(exactTextCaseSensitive("abc")); // с учетом регистра
        $("").should(matchText("[0-9]abc$")); //regexp регулярные выражения

        $("").shouldHave(cssClass("class-name-1"), cssClass("class-name-2")); // элемент с двумя классами
        $("").shouldHave(cssValue("color", "red")); // css свойства элемента

        $("").shouldHave(value("inputTest")); // проверка введенного текста
        $("").shouldHave(exactValue("inputTest")); // точное совпадение
        $("").shouldBe(empty); // проверка что поле пустое

        $("").shouldHave(attribute("disabled")); //??? существует атрибюут
        $("").shouldHave(attribute("name", "value")); // проверка что у такого атрибута такое значение
        $("").shouldHave(attributeMatching("name", "[0-9]abc$"))// использование regExp

        $("").shouldBe(checked); // чекбокс выбран
        $("").shouldNotBe(checked); // чекбокс НЕ выбран

        $("").should(exist); // элемент существует в ДОМ модели, может быть невидимым
        $("").shouldBe(disabled); // для кнопок, проверка на дисэйблед, работа зависит от реализации.
        $("").shouldBe(enabled); // для кнопок

    }

    void collectons_examples() {

        $$("div"); // ничего не делает, нужно лействие, просто выберет все дивы
        $$x("//div"); // тоже самое только для xpath

        $$("div").filterBy(text("123")).shouldHave(size(1)); // поиск в коллекции элементов с текстом 123 сайз 1
        $$("div").excludeWith(text("123")).shouldHave(size(1)); // исключение из коллекции элементов соответствующих 123 сайз 1

        $$("div").first().click(); // первый див в коллекции
        elements("div").first().click(); // аналог $$
        $$("div").last().click(); // последний див в коллекции

        $$("div").get(1).click(); // второй див в коллекции
        $("div", 1).click(); // второй найденный див

        $$("div").findBy(text("123")).click(); // findBy уточняет поиск и берет первый элемент

        // assertions
        $$("div").shouldHave(size(0)); // количество найденных дивов = 0
        $$("div").shouldBe(CollectionCondition.empty); // эквивалентно

        $$("div").shouldHave(texts("AA", "BB", "CC")); // в коллекции должны быть только AA BB CC, если будет и DD будет ошибка.
        // текст проверяется по вхождению AA = AAB, учитывается порядок значений
        $$("div").shouldHave(exactTexts("AA", "BB", "CC")); // эквивалентно, но точное совпадение текста

        $$("div").shouldHave(textsInAnyOrder("BB", "AA", "CC")); // эквивалентно texts(), без учета порядка значений
        $$("div").shouldHave(exactTextsCaseSensitiveInAnyOrder("BB", "AA", "CC")); // эквивалентно, с учетом регистра

        $$("div").shouldHave(itemWithText("text")); // найти в коллекции элемент с текстом text

        $$("div").shouldHave(sizeGreaterThan(0)); // количество элементов больше 0
        $$("div").shouldHave(sizeGreaterThanOrEqual(1)); // количество элементов больше либо равно 1
        $$("div").shouldHave(sizeLessThan(2)); // количество элементов меньше 2
        $$("div").shouldHave(sizeLessThanOrEqual(3)); // количество элементов меньше или равно 3

    }

    void file_operation_examples() throws FileNotFoundException{

        // скачать файл https://www.youtube.com/watch?v=x0KWgnjxsl4&list=PL6h45kwyd3r1sE39ykWsWc2iTVE8AvgQg&index=1
        File file1 = $("a.fileLink").download(); // скачивание из простых линков
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER));

        // загрузить файл с компьютера upload
        File file = new File("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("readme.txt");
        $("uploadButton").click(); // не забыть нажать

    }

    void javascript_examples(){
        executeJavaScript("alert('selenide')");
        executeJavaScript("alert(argument[0]+argument[1])", "abc", 12);
        long fortytwo = executeJavaScript( "return argument[0]*argument[1];", 6,7);
    }
}

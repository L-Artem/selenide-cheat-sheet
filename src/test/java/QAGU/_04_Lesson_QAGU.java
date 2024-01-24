package QAGU;

// https://github.com/qa-guru/

import com.codeborne.selenide.*;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;

import java.time.Duration;

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

        $("").;
        $("").;
        $("").;


    }
}

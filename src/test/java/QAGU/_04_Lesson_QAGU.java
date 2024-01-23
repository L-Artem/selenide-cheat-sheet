package QAGU;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.BasicAuthCredentials;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.Cookie;

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
        $("div")
    }
}

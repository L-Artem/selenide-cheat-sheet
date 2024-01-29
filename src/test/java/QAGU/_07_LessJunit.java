package QAGU;

import Selenium.OtherBrowser;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class _07_LessJunit {


    @BeforeAll
    static void startYa() {
        OtherBrowser.startYandex();
    }


    @Test
    void fillForm() {

        Configuration.browserSize = "1930x1030";
        Configuration.browserPosition = "-8x-2";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";


        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("Ivan Pupkin");
        $("[id=userEmail]").setValue("qqq@www.ee");
        $("#currentAddress").setValue("some address 1");
        $("#permanentAddress").setValue("other address 1");
        $("#submit").click();

        $("[id=output]").shouldBe(visible);
        $("[id=output]").$("#name").shouldHave(text("Ivan Pupkin"));
        $("form [id=output] #email").shouldHave(text("qqq@www.ee"));


        sleep(5000);
    }

    void cssXpathExamples(){
        $("[data-testid=email]").setValue("1");
        $(by("data-testid","email")).setValue("1");

        //<div>Hello test</div>
        $x("//div[test()='Hello test']");
        $(byText("Hello test"));
        $(withText("ello tes"));

    }
}

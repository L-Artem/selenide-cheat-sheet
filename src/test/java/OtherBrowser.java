import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;

public class OtherBrowser {

    @Test
    void otherBrowser(){


        System.setProperty("webdriver.chrome.driver", "D:\\dev\\drivers\\yandexdriver.exe");
        Configuration.browserBinary = "C\\Yandex\\browser.exe";
        //"C:\\Users\\Artem\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"
        Configuration.reopenBrowserOnFail = true;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 300000L;

        Selenide.sleep(10000);
    }
}

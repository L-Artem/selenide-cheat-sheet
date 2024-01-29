package Selenium;

import com.codeborne.selenide.Configuration;

public class OtherBrowser {


    public static void startYandex(){


        System.setProperty("webdriver.chrome.driver", "C:\\Git.Selenium\\selenide-cheat-sheet\\resources\\yandexdriver\\yandexdriver.exe");
        Configuration.browserBinary = "C:\\Users\\Artem\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        //"C:\\Users\\Artem\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"
        Configuration.reopenBrowserOnFail = true;
        Configuration.browserSize = "1900x1060";
        Configuration.pageLoadTimeout = 300000L;

        //Selenide.sleep(10000);
    }
}

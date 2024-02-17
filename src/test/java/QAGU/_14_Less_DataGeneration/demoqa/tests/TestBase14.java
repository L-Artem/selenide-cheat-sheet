package QAGU._14_Less_DataGeneration.demoqa.tests;

import QAGU._14_Less_DataGeneration.demoqa.pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase14 {


    public RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

}

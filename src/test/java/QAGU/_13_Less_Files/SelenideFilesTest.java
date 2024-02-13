package QAGU._13_Less_Files;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFilesTest {

    static {
        //Configuration.fileDownload = FileDownloadMode.PROXY;
        Configuration.holdBrowserOpen = true;
        Configuration.downloadsFolder = "";
    }

    @Test
    void selenideLoadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = $("[data-testid=raw-button]").download();

        try (InputStream is = new FileInputStream(downloadedFile)) { // ресурс который нужно закрыть после трай
            byte[] bytes = is.readAllBytes();
            String textContent = new String(bytes, StandardCharsets.UTF_8);
            assertThat(textContent).contains("This repository is the home of _JUnit 5_.");
            System.out.println(textContent.contains("This repository is the home of _JUnit 5_."));
        }
    }

    @Test
    void selenideUploadFile() {
        open("https://fineuploader.com/demos.html");
        //$("input[type='file']").uploadFile("");
        $("input[type='file']").uploadFromClasspath("img/cat.png"); // если input[type='file'] невидимый,
        // то видимость можно поменять с помощью js скрипта, how change element visible javascript
        //executeJavaScript("");

        sleep(10000);
        $("div.qq-file-info").shouldHave(Condition.text("cat.png")); //"cat.png" может быть в ЛЮБОМ из дочерних элементов
        $("span.qq-upload-file-selector")
                .shouldHave(Condition.attribute("title" , "cat.png"));

    }
}

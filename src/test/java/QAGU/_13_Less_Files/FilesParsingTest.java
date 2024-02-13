package QAGU._13_Less_Files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesParsingTest {

    ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    void pdfParseTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadFile = $("a[href='junit-user-guide-5.10.2.pdf']").download();
        PDF content = new PDF(downloadFile);
        assertThat(content.author).contains("Sam Brannen");
        // калькулятор в дебаге
    }

    @Test
    void xlsParseTest() throws Exception {

        try (InputStream resourceAsStream = cl.getResourceAsStream("excel.xls")) {
            XLS content = new XLS(resourceAsStream);
            //assertThat(content.excel.getSheetAt(0).getRow(1).getCell(2)).c;
                    //Фамилия, имя, отчество
            System.out.println("");
        }
    }
}


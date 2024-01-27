// Examples
//https://github.com/SeleniumHQ/seleniumhq.github.io/tree/trunk/examples/java/src/test/java/dev/selenium

package Selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class Selenium_doc {

    WebDriver wb = null;


    @Test
    void fileUpload(){
        By driver;
        WebElement elementFileInput = wb.findElement(By.cssSelector("input[type=file]"));
        File uploadFile = new File("");
        elementFileInput.sendKeys(uploadFile.getAbsolutePath());
        wb.findElement(By.id("file-submit")).click();
    }


}

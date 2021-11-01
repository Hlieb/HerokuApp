package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile {

    @Test
    public void uploadFileTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Glieb\\IdeaProjects\\HerokuApp\\target\\Снимок.PNG");
        driver.findElement(By.id("file-submit")).click();
        WebElement finalText = driver.findElement(By.id("uploaded-files"));
        finalText.getText();
        Assert.assertEquals(finalText.getText(),"Снимок.PNG","Error");
        driver.quit();
    }
}

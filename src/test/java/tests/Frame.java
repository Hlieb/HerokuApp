package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Frame {

    @Test
    public void frameTextTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("iFrame")).click();
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        WebElement getText = driver.findElement(By.id("tinymce"));
        Assert.assertEquals(getText.getText(),"Your content goes here.", "Error");
        driver.quit();
    }
}

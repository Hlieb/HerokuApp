package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {
    @Test
    public void TypoTestNumbers() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement type = driver.findElement(By.xpath("//*[@type='number']"));
        type.sendKeys("1111");
        Assert.assertEquals(type.getAttribute("value"), "1111", "error");
    }

    @Test
    public void TypoAlfabetNumbers() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement type = driver.findElement(By.xpath("//*[@type='number']"));
        type.sendKeys("aaaa");
        Assert.assertEquals(type.getAttribute("value"), "aaaa", "Can't enter an alfabet");
    }

    @Test
    public void Strilochky() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement type = driver.findElement(By.xpath("//*[@type='number']"));
        type.sendKeys("1111");
        type.sendKeys(Keys.DOWN);
        type.sendKeys(Keys.DOWN);
        type.sendKeys(Keys.UP);
        Assert.assertEquals(type.getAttribute("value"), "1110", "error");
    }
}

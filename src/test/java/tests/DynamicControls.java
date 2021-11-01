package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicControls {

    @Test
    public void checkBoxTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[@autocomplete='off']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        List<WebElement> checkbox = driver.findElements(By.xpath("//*[@type='checkbox']"));
        Assert.assertEquals(checkbox.size(),0,"Error");
        driver.quit();
    }

    @Test
    public void inputIsDisabledTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement input = driver.findElement(By.xpath("//*[@type='text']"));
        input.isEnabled();
        Assert.assertFalse(input.isEnabled(),"Error");
    }

    @Test
    public void inputIsEnabledTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[@onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        WebElement input = driver.findElement(By.xpath("//*[@type='text']"));
        input.sendKeys("aaaaa");
        Assert.assertEquals(input.getAttribute("value"),"aaaaa","Error");
    }
}

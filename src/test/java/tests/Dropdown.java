package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dropdown {

    @Test
    public void SelectFirstOptionDropdownTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.id("dropdown")).click();
        WebElement option1 = driver.findElement(By.xpath("//*[@value='1']"));
        option1.click();
        option1.getText();
        Assert.assertEquals(option1.getText(), "Option 1");

    }

    @Test
    public void SelectSecondOptionDropdownTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.id("dropdown")).click();
        WebElement option2 = driver.findElement(By.xpath("//*[@value='2']"));
        option2.click();
        option2.getText();
        Assert.assertEquals(option2.getText(), "Option 2");
    }
}

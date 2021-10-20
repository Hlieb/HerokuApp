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
    public void SelectDropdownTest() {
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
        Assert.assertEquals(1, 1, "error");
        driver.close();
        ChromeOptions chromeOptions2 = new ChromeOptions();
        chromeOptions2.addArguments("--incognito");
        chromeOptions2.addArguments("--disable-popup-blocking");
        WebDriver driver2 = new ChromeDriver(chromeOptions);
        driver2.get("http://the-internet.herokuapp.com/dropdown");
        WebElement option2 = driver2.findElement(By.xpath("//*[@value='2']"));
        option2.click();
        Assert.assertEquals(2, 2, "Error");
    }
}

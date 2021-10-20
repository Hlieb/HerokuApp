package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes {

    @Test
    public void CheckboxesTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        boolean checkboxCheck = driver.findElement(By.cssSelector("[type = checkbox]")).isSelected();
        Assert.assertFalse(checkboxCheck, "Error");
        driver.findElement(By.cssSelector("[type = checkbox]")).click();
        Assert.assertTrue(true,"Error");
        driver.findElement(By.xpath("//*[@type = 'checkbox'][2]")).isSelected();
        Assert.assertTrue(true,"Error");
        driver.findElement(By.xpath("//*[@type = 'checkbox'][2]")).click();
        Assert.assertTrue(true,"Error");
    }
}

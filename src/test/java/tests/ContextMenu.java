package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ContextMenu {

    @Test
    public void rightClickOnTheElementTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"You selected a context menu","Error");
        driver.quit();
    }

    @Test
    public void alertExit(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.quit();
    }
}

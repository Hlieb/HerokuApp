package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Typo {
    @Test
    public void TypoTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/typos");
        driver.findElement(By.xpath("//*[@id='content']/div/p[2]"));
        WebElement typo =  driver.findElement(By.xpath("//*[@id='content']/div/p[2]"));
        //System.out.println(typo.getText()); для себя посмотреть какой текст находит елемент
        Assert.assertEquals(typo.getText(),"Sometimes you'll see a typo, other times you won't.", "Error");
    }
}

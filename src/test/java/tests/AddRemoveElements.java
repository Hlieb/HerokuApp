package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddRemoveElements {

@Test
    public void AddRemoveElementsTest() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--incognito");
    chromeOptions.addArguments("--disable-popup-blocking");
    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.manage().window().fullscreen();
    driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    WebElement clickAddButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
    clickAddButton.click();
    clickAddButton.click();
    WebElement deleteButton = driver.findElement(By.xpath("//*[@class='added-manually']"));
    deleteButton.click();
    int addElements = driver.findElements(By.xpath("//*[@onclick='addElement()']")).size();
    System.out.println("'Add' elements: " + addElements);
    int deleteElements = driver.findElements(By.xpath("//*[@class='added-manually']")).size();
    System.out.println("'Delete' elements: " + deleteElements);
    int allElements = addElements + deleteElements;
    System.out.println("All elements: " + allElements);


}

}

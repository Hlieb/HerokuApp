import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PresidentTest {

    @Test
    public void FindElementLinkTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("C:\\Users\\Glieb\\IdeaProjects\\HerokuApp\\src\\main\\Test\\java\\President.html");
        driver.findElement(By.partialLinkText("Самые честные новости")).click();
    }

    @Test
    public void FindElementTableTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("C:\\Users\\Glieb\\IdeaProjects\\HerokuApp\\src\\main\\Test\\java\\President.html");
        String text = driver.findElement(By.id("table")).getText();
        Assert.assertEquals(text,"2010 2015 2020\n79,5% 83,4% 80,1%", "error");
        driver.quit();
    }

    @Test
    public void FindElementCheckBoxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("C:\\Users\\Glieb\\IdeaProjects\\HerokuApp\\src\\main\\Test\\java\\President.html");
        WebElement click = driver.findElement(By.id("Great"));
        click.click();
        click.isSelected();
        Assert.assertEquals(click.isSelected(), true, "Error");
        driver.quit();
    }

    @Test
    public void FindElementInputTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("C:\\Users\\Glieb\\IdeaProjects\\HerokuApp\\src\\main\\Test\\java\\President.html");
        WebElement text = driver.findElement(By.xpath("//*[@type='text']"));
        text.sendKeys("99%");
        text.getAttribute("value");
        Assert.assertEquals(text.getAttribute("value"), "99%", "Error");
        driver.quit();
    }

    @Test
    public void FindElementSelectTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("C:\\Users\\Glieb\\IdeaProjects\\HerokuApp\\src\\main\\Test\\java\\President.html");
        WebElement selector = driver.findElement(By.xpath("//*[@value='akaSimja']"));
        selector.click();
        Assert.assertEquals(selector.getText(), "Янукович В.Ф.", "Erroe");
        driver.quit();
    }
}
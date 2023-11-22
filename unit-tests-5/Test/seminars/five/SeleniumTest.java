package seminars.five;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    @Test
    void findSeleniumTest() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        List<WebElement> searchUrls = driver.findElements(By.cssSelector("div"));

        boolean isFound = false;
        for (WebElement elem : searchUrls) {
            if (elem.getText().contains("https://www.selenium.dev")) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound);
        driver.quit();
    }

    @Test
    void sauceDemoTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "D:/repo/Unit/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");


        WebElement loginBox = driver.findElement(By.name("user-name"));
        loginBox.sendKeys("standard_user");

        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("secret_sauce");

        WebElement button = driver.findElement(By.id("login-button"));
        button.click();

        WebElement product = driver.findElement(By.className("title"));

        assertTrue(product.getText().contains("Products"));

        Thread.sleep(10000);
        driver.quit();
    }
}

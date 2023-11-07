import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;


public class EuroTest {
    private WebDriver driver;
    private String baseUrl, search, size, type, width, height;


    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        Map<String, Object> profile = new HashMap<>();
        Map<String, Object> contentSettings = new HashMap<>();

        contentSettings.put("cookies", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver();
        baseUrl = "https://www.ebay.de/";
        search = "//input[@type='text']";
        size = "//input [@aria-label=\"16\"]";
        type = "//input [@aria-label=\"Winterreifen\"]";
        width = "//input [@aria-label=\"60\"]";
        height = "//input [@aria-label=\"215\"]";

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void euroTest() {
        driver.get(baseUrl);
        driver.manage().window().maximize(); // открываем на полный экран

        WebElement searchInput = driver.findElement(By.xpath(search));
        searchInput.sendKeys("Reifen", Keys.ENTER);
        searchInput = driver.findElement(By.xpath(size));
        searchInput.click();
        searchInput = driver.findElement(By.xpath(width));
        searchInput.click();
        searchInput = driver.findElement(By.xpath(type));
        searchInput.click();
        searchInput = driver.findElement(By.xpath(height));
        searchInput.click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

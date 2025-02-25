package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Browserlib {
    private WebDriver driver;

    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String quickbaseUrl = ConfigReader.getProperty("quickbaseurl");
        if (quickbaseUrl != null && !quickbaseUrl.isEmpty()) {
            driver.get(quickbaseUrl);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }


    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null; // Ensure cleanup
        }
    }
}
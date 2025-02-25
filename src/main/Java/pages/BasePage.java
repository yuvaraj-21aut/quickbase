package pages;
import Util.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
    public void projectmanagementapp() throws InterruptedException {
        String quickbaseUrl = ConfigReader.getProperty("quickbaseurl");
        System.out.println("Navigating to: " + quickbaseUrl);
        driver.get(quickbaseUrl); // ✅ Open URL before clicking elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='quickbaseSignin']")));
        signInButton.click();
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='loginid'])[1]")));
        emailField.sendKeys("yuvaraja8921@gmail.com");
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='password'])[1]")));
        passwordField.sendKeys("Quickbase@25");
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@name='SignIn'])[1]")));
        submitButton.click();
        WebElement dashboardButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='iconWithTextIconContainer css-yc1slu e1nk7ekd0']")));
        dashboardButton.click();
        System.out.println("Login successful!");
    }
    }

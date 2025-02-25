package test;

import Util.Browserlib;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.AddNotePage;
import pages.BasePage;
import pages.HomePage;
import pages.OwntablePage;

public class BaseTest {
    protected WebDriver driver;
    protected Browserlib browserlib;
    protected BasePage basePage;
    protected HomePage homePage;
    protected AddNotePage addNotePage;
    protected OwntablePage owntablePage;

    @BeforeMethod
    @Parameters("browser")
    public void setUpTest(@Optional("chrome") String browser) throws InterruptedException {
        browserlib = new Browserlib(); // ✅ Initialize browserlib before calling setup
        browserlib.setup(browser);
        driver = browserlib.getDriver();
        homePage = new HomePage(driver);
        addNotePage = new AddNotePage(driver);
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        owntablePage = new OwntablePage(driver);
    }
}

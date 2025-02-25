package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = " (//div[@class='css-wyc9zy'])[3]")
    WebElement notesTablebutton;

    @FindBy(xpath = "//a[@id='stdAddRecButton']")
    WebElement newnotebutton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void newrole() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        notesTablebutton.click();
        newnotebutton.click();
    }
}

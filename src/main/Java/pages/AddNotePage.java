package pages;

import Util.CheckBoxUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddNotePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@data-testid='text-field']")
    WebElement newroleNametextbox;

    @FindBy(xpath = "//input[@label='Email']")
    WebElement AddnoteEmailtextbox;

    @FindBy(xpath = "//button[@data-test-id='save-record-button']")
    WebElement Savebutton;

    @FindBy(xpath = "//div[contains(text(),'Notes Table')]")
    WebElement Notestablebutton;

    @FindBy(xpath = "//label[@for='checkboxForActionCell-hybrid-table-report_1739365229515_-4_2685']")
    WebElement Selectfirstvaluecheckbox;

    @FindBy(xpath = " //button[normalize-space()='Delete']")
    WebElement Delebutton;

    @FindBy(xpath = "//button[normalize-space()='Yes delete']")
    WebElement Confirmdeletebutton;

    public AddNotePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Addnote(String randomemail, String random) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        newroleNametextbox.sendKeys(randomemail);
        AddnoteEmailtextbox.sendKeys(random);
        Savebutton.click();
    }

    public void Notestablenote() {
        Notestablebutton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void Selectchecbox() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CheckBoxUtils.selectCheckBox(Selectfirstvaluecheckbox);
        Assert.assertTrue(CheckBoxUtils.isCheckBoxSelected(Selectfirstvaluecheckbox), "Checkbox should be selected");
    }

    public void Deletebutton(){
        Delebutton.click();
        Confirmdeletebutton.click();
    }
}
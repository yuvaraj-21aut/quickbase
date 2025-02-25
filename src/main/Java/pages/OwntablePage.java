package pages;

import Util.RandomString;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OwntablePage  {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[@aria-label='New table']")
    WebElement newtable;

    @FindBy(xpath = "(//div[@class='css-12qjni8'])[1]")
    WebElement fromscratch;

    @FindBy(xpath = "//div[@class='itemPickerV2__input']/input[@type='text']")
    WebElement tablenamebox;


    @FindBy(xpath = " //input[@data-test-id='SingleRecordInput']")
    WebElement singlerecordbox;

    @FindBy(xpath = "//button[@data-test-id='dialogOkButton']")
    WebElement createtablebutton;

    @FindBy(xpath = "(//button[@id='newFieldsButton'])")
    WebElement newfields;

    @FindBy(xpath = "(//div[normalize-space()='Add a label'])[1]")
    WebElement addalabeltextbox;

    @FindBy(xpath = "(//button[normalize-space()='Add fields'])[1]")
    WebElement addfieldsbutton;


    public OwntablePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        PageFactory.initElements(driver, this);
    }

    public void NewTable(String random) {
        try {
            String randomStr = RandomString.generateRandomString(5);
            // Click "New Table" button
            wait.until(ExpectedConditions.elementToBeClickable(newtable)).click();
            // Click "From Scratch" option
            wait.until(ExpectedConditions.elementToBeClickable(fromscratch)).click();

            // Wait for tablenamebox to be visible
            WebElement tableNameBox = wait.until(ExpectedConditions.visibilityOf(tablenamebox));

            // Re-locate tablenamebox to avoid stale element issues
            tableNameBox.sendKeys(randomStr);

            wait.until(ExpectedConditions.visibilityOf(singlerecordbox)).sendKeys(randomStr);

            wait.until(ExpectedConditions.elementToBeClickable(createtablebutton)).click();
            driver.navigate().refresh();
            newfields.click();
            wait.wait(30);
            wait.until(ExpectedConditions.visibilityOf(addalabeltextbox)).sendKeys(randomStr);
            addfieldsbutton.click();

        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Element Exception: Retrying...");
            NewTable(random); // Recursively retry once
        } catch (ElementNotInteractableException e) {
            System.out.println("Element Not Interactable: Scrolling & Retrying...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tablenamebox);
            tablenamebox.click();
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

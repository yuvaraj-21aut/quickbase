package test.tests;


import Util.RandomString;
import org.testng.annotations.*;
import test.BaseTest;
import java.time.Duration;


public class NotesTableTest extends BaseTest {

    @Test
    @Parameters({"email", "random"})
    public void testNotestable(@Optional("default@test.com") String email,
                               @Optional("DefaultValue") String random) throws InterruptedException {
        String randomStr = RandomString.generateRandomString(5);
        System.out.println("Generated Random String: " + randomStr);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        basePage.projectmanagementapp();
        homePage.newrole();
        String  randomemail =randomStr + "@test.com";
        System.out.println("Generated Random Email: " + randomemail);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        addNotePage.Addnote(randomemail, random);
        addNotePage.Notestablenote();
        addNotePage.Selectchecbox();
        addNotePage.Deletebutton();
    }


    @AfterMethod
    public void tearDownTest() {
        browserlib.tearDown();
    }
}
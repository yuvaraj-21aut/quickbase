package test.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.BaseTest;

import java.time.Duration;

public class NewTableTest  extends BaseTest {

    @Test
    @Parameters({"random"})
    public void testNewtable (@Optional("DefaultValue")String random) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        basePage.projectmanagementapp();
        owntablePage.NewTable(random);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownTest() {
        browserlib.tearDown();
    }
}

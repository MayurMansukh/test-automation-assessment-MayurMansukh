package testCases;

import BASE.Base;
import utils.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataDriven;

import java.io.IOException;

@Listeners(CustomListener.class)
public class LoginTest extends Base {

    @Test
    public void loginTest() throws IOException {
        DataDriven test = new DataDriven();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.admin_login(test.excelData1(),test.excelData2());
        Assert.assertEquals(driver.getCurrentUrl(),"https://icehrm-open.gamonoid.com/login.php?f=1");
    }
}

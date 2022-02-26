package testCases;

import BASE.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends Base {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.admin_login("user1","demouserpwd");
        Assert.assertEquals(driver.getCurrentUrl(),"https://icehrm-open.gamonoid.com/?g=modules&n=dashboard&m=module_Personal_Information");
    }
}

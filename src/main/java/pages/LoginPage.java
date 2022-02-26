package pages;

import BASE.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {
    public WebDriver driver;

    @FindBy(id = "username")
    WebElement email_txt;

    @FindBy(id = "password")
    WebElement password_txt;

    @FindBy(xpath = "//*[@id=\"loginForm\"]/div[4]/button")
    WebElement login_btn;//

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.getLogger(LoginPage.class.getName()).warn("Test started");
    }

    public boolean admin_login(String id, String pass) {
        email_txt.sendKeys(id);
        logger.info("Entering username");
        password_txt.sendKeys(pass);
        logger.info("Entering Password");
        login_btn.click();
        logger.info("Logged in");
        return true;
    }
}

package BASE;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.ConfigReader;
import utils.TakeScreenshot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static Logger logger = Logger.getLogger(Base.class);
    ATUTestRecorder recorder;



    @BeforeTest
    public void load_log4j(){
        PropertyConfigurator.configure("log4j.properties");
    }

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) throws ATUTestRecorderException {
        TakeScreenshot obj = new TakeScreenshot();
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
        Date date = new Date();
        recorder = new ATUTestRecorder("C:\\Users\\mayurmansukh\\OneDrive - Instarem PTE Ltd\\Desktop\\Automation-Assessment\\Recording","TestVideo-"+dateFormat.format(date),false);
        recorder.start();
        ConfigReader config =new ConfigReader();
        WebDriverManager.chromedriver().setup();
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(config.get_link());

    }

    @AfterTest
    public void teardown() throws ATUTestRecorderException {
        driver.close();
        recorder.stop();;

    }
}

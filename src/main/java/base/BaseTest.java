package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public String baseUrl = "https://trello.com/";

    public static WebDriver driver ;
    WebDriverManager wdm;

    @BeforeSuite
    public void initializeDriver()  {


        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);*/
        wdm = WebDriverManager.chromedriver().browserInDocker()
                .enableVnc().enableRecording();
        driver = wdm.create();
        driver.get(baseUrl);
    }

    @AfterSuite
    public void closeDriver() {
       // driver.quit();
        wdm.quit();
    }
}
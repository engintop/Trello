package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePageUtil;
import util.Log;

public class LoginPage extends BasePageUtil {


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public By LOGIN_EMAIL = By.id("user");
    public By LOGIN_EMAIL_BTN = By.id("login");
    public By LOGIN_PASSWORD = By.id("password");
    public By LOGIN_SUBMIT_BTN = By.id("login-submit");
    public By LOGIN_BTN = By.xpath("//a[@data-uuid=\"MJFtCCgVhXrVl7v9HA7EH_login\"]");


    public void login(String email , String password){

        click(LOGIN_BTN);
        sendKeys(LOGIN_EMAIL , email);
        click(LOGIN_EMAIL_BTN);
        sendKeys(LOGIN_PASSWORD,password);
        click(LOGIN_SUBMIT_BTN);
    }
}
package util;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePageUtil {

    protected WebDriverWait wait;
    protected WebDriver driver;

    public By HOMEPAGE_ICON = By.className("m2N684FcksCyfT");


    public BasePageUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
    }

    public void clickHomePageIcon (){
        waitUntilElementVisible(HOMEPAGE_ICON);
        click(HOMEPAGE_ICON);
    }

    public String getText(By element){
        return driver.findElement(element).getText();
    }

    public void click(By element) {
        waitUntilElementVisible(element);
        driver.findElement(element).click();
        Log.info("Clicked " + element);
    }

    public void sendKeys(By element, String text) {
        waitUntilElementVisible(element);
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(text);
        Log.info("Set " + text + " to " + element);
    }

    public void waitSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }

    public void waitUntilElementVisible(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clickWithIndex(By element, int index) {
        waitUntilElementVisible(element);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element)).get(index).click();
        Log.info("Clicked " + element + " at " + index);
    }


}
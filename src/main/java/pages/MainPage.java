package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.BasePageUtil;
import util.Log;

public class MainPage extends BasePageUtil {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public By HEADER_CREATE_BTN = By.className("YVxoA9yoN2HeNo");
    public By HEADER_CREATE_BOARD = By.className("R2Zt2qKgQJtkYY");
    public By SOLID_THEMES = By.className("ckPe00OAd2wM9L");
    //public By SPECIAL_THEMES = By.className("ckPe00OAd2wM9L SIv9KBzGYcp2++");
    public By BOARDNAME = By.xpath("//label[@class=\"Yb0we30YG32Gdb\"]//input");
    public By CREATE_BOARD_BTN = By.xpath("//button[@data-test-id=\"create-board-submit-button\"]");
    public By BOARD_NAME = By.xpath("//h1[@class=\"js-board-editing-target board-header-btn-text\"]");
    public By WORKING_PLACE_TITLES = By.xpath("//li//ul//li[@class=\"NwJPAvPw3Hp+Fl\"]");
    public By BOARD_MENU = By.xpath("//button[@aria-label=\"Show menu\"]");
    public By BOARD_MENU_MORE_BTN = By.cssSelector(".board-menu-navigation-item-link.js-open-more");
    public By CLOSE_BOARD = By.cssSelector(".board-menu-navigation-item-link.js-close-board");
    public By CLOSE_BOARD_BTN = By.cssSelector(".js-confirm");
    public By DELETE_BOARD = By.xpath("//button[@data-test-id=\"close-board-delete-board-button\"]");
    public By DELETE_BOARD_CONFIRM = By.xpath("//button[@data-test-id=\"close-board-delete-board-confirm-button\"]");
    public By CREATE_FIRST_BOARD_BTN = By.xpath("//div[@class=\"XJcdodNWGb85aH\"]//button");
    public By USER_ICON = By.cssSelector(".yRPuNUIoZpQWwj");
    public By ACCOUNT_OPTIONS = By.xpath("//span[@class=\"_4NKF+QtJz6p9X2\"]");
    public By LOGOUT_CONFIRM = By.xpath("//button[@id=\"logout-submit\"]");
    public By LOGIN_BTN = By.xpath("//a[@data-uuid=\"MJFtCCgVhXrVl7v9HA7EH_login\"]");




    public MainPage clickCreateBtn(){
        click(HEADER_CREATE_BTN);
        return this;

    }

    public MainPage createBoardFromHeaderMenu (String boardName){
        clickWithIndex(HEADER_CREATE_BOARD,0);
        clickWithIndex(SOLID_THEMES,2);
        sendKeys(BOARDNAME, boardName);
        click(CREATE_BOARD_BTN);
        waitUntilElementVisible(BOARD_NAME);
        Assert.assertEquals(getText(BOARD_NAME),boardName);
        return this;

    }

    public MainPage createBoardFromBoardsMenu (String boardName){
        clickWithIndex(WORKING_PLACE_TITLES,0);
        click(CREATE_FIRST_BOARD_BTN);
        clickWithIndex(SOLID_THEMES,2);
        sendKeys(BOARDNAME, boardName);
        click(CREATE_BOARD_BTN);
        waitUntilElementVisible(BOARD_NAME);
        Assert.assertEquals(getText(BOARD_NAME),boardName);
        return this;

    }


    public MainPage deleteBoard(String boardName){
        clickHomePageIcon();
        clickWithIndex(WORKING_PLACE_TITLES,0);
        By BOARD = By.xpath("//div[@title=\""+boardName+"\"]//div");
        if(driver.findElement(BOARD).isDisplayed()){
            waitSeconds(2);
            click(BOARD);
            click(BOARD_MENU);
            click(BOARD_MENU_MORE_BTN);
            click(CLOSE_BOARD);
            click(CLOSE_BOARD_BTN);
            click(DELETE_BOARD);
            click(DELETE_BOARD_CONFIRM);
            waitUntilElementVisible(CREATE_FIRST_BOARD_BTN);
            Assert.assertEquals(getText(CREATE_FIRST_BOARD_BTN),"Create your first board");
        }
        else
            Log.info("Board already deleted or not created yet");
        return this;
    }

    public MainPage logout(){
        click(USER_ICON);
        clickWithIndex(ACCOUNT_OPTIONS,7);
        click(LOGOUT_CONFIRM);
        waitUntilElementVisible(LOGIN_BTN);
        return this;
    }



}
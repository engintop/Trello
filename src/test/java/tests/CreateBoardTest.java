package tests;

import base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import util.Log;

public class CreateBoardTest extends BaseTest {

    final String EMAIL = "engin.top@hotmail.com";
    final String PASSWORD = "knabtests123";
    final String BOARD_NAME = "TestBoardName1";

    LoginPage loginPage;
    MainPage mainPage;

    @BeforeTest
    public void initialize(){
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @BeforeMethod
    public void login(){
        Log.info("Step 1 : Login with valid account");
        loginPage
                .login(EMAIL,PASSWORD);
    }

    @Test(priority=1 , description = "Create Board From Header Menu")
    public void createBoardFromHeaderButton() {
        Log.startLog("Create Board From Header Menu");
        Log.info("Step 2 : Create board from header menu");
        mainPage
                .clickCreateBtn()
                .createBoardFromHeaderMenu(BOARD_NAME);
    }

    @Test(priority=2 , description = "Create Board From Boards Option")
    public void createBoardFromBoardsButton() {
        Log.endLog("Create Board From Header Menu");
        Log.info("Step 2 : Create board from boards option");
        mainPage
                .clickCreateBtn()
                .createBoardFromBoardsMenu(BOARD_NAME);
    }


    @AfterMethod
    public void cleanup(){
        Log.info("Clean up starting...");
        mainPage
                .deleteBoard(BOARD_NAME)
                .logout();
    }
}


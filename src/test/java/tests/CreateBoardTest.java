package tests;

import base.BaseTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

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
        loginPage
                .login(EMAIL,PASSWORD);
    }

    @Test(priority=1)
    public void createBoardFromHeaderButton() {
        mainPage
                .clickCreateBtn()
                .createBoardFromHeaderMenu(BOARD_NAME);
    }

    @Test(priority=2)
    public void createBoardFromBoardsButton() {
        mainPage
                .clickCreateBtn()
                .createBoardFromBoardsMenu(BOARD_NAME);
    }


    @AfterMethod
    public void cleanup(ITestResult result){
        mainPage
                .deleteBoard(BOARD_NAME)
                .logout();
    }
}


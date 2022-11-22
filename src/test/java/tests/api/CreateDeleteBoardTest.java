package tests.api;

import api.CreateDeleteBoard;
import base.BaseTestApi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateDeleteBoardTest extends BaseTestApi {


    final String KEY = "772b7082320893b97c3786e512524a83";
    final String TOKEN = "d19f0c9b96d72a48e72cb0f93514064923190eac04415c4d4b6b453deabced36";
    final String BOARD_NAME = "API_TEST_BOARD";

    CreateDeleteBoard cdb;
    String boardId ;

    @BeforeMethod
    public void initialize(){
        cdb = new CreateDeleteBoard();
    }

    @Test(priority=1)
    public void createBoardByName() {
        boardId = cdb.createBoard(BOARD_NAME,KEY,TOKEN);
    }

    @AfterMethod
    public void cleanup(){
        cdb.deleteBoard(boardId,KEY,TOKEN);
    }
}

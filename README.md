# Trello
# test-automation-create-delete-board
Java Trello project for test automation covering UI and API testing.

# How to run tests
After import the project on your local. You can run with using maven commands. You can write the following command on the terminal.
"mvn clean test -Dsurefire.suiteXmlFiles=RunTest.xml"


# Test Cases

# UI 
1. Create board from header menu (Create button)
2. Create board from boards option
# API
1. Create and delete board. (Include 2 request api)


# Plan to develop
1. For informaiton security , we can create config file to store cridentials and API tokens. In addition , we can encrypt and decrypt the config data which we get and set on the automation tests.
2. For the web automation side , we can develop the deletion function such as search the board name in a loop. If the account has more than 2 board , test will get fail for now.
3. We can add allure report to project. it will provide rerun function when test get fail.
4. We Can create runner job for scheduling tests on gitHub platform. (.yml file is ready to run).

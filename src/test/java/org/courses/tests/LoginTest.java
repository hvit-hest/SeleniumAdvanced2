package org.courses.tests;

import org.courses.pages.AdminPage;
import org.courses.testdata.LoginData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class LoginTest {

    public WebDriver myPersonalDriver;
    private AdminPage adminPage;
    private String sysProperty = "webdriver.chrome.driver";
    private String pathToDriver = "C://PersonalDrivers//chromedriver.exe";

    @BeforeTest
    public void beforeTest() {
        System.setProperty(sysProperty, pathToDriver);
        myPersonalDriver = new ChromeDriver();
        myPersonalDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(dataProviderClass = LoginData.class, dataProvider = "dataforlogin")
    public void tryAdminLogin(boolean testType, String accountName, String accountPwd) {
        adminPage = new AdminPage(myPersonalDriver);
        adminPage.open();
        if (adminPage.isLoginFormOpen())
            adminPage.login(accountName, accountPwd);
        else {
            adminPage.logout();
            adminPage.login(accountName, accountPwd);
        }


        if (!testType)
            /*Is login failed? It has to be...
              Add more negative test data (later)
             */
            assertTrue(adminPage.isLoginFormOpen());
        else {
            //Is login succeed? It has to be...
            assertTrue(adminPage.isAdminPageOpen());
        }
    }

    @AfterTest
    public void afterTest() {
        //Close the driver
        myPersonalDriver.close();
        myPersonalDriver.quit();
    }
}

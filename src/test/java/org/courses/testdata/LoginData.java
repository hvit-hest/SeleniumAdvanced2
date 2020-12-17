package org.courses.testdata;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name="dataforlogin")
    public static Object [][] createDataForLogin() {
        return new Object[][] {
                { true, "admin", "admin"},
                { false, "", ""},
                { false, "admin", ""},
        };
    }

}

package lesson_5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGExample {
    private int number;
    private final String USER_NAME = "Zoidberg";
    private final String USER_PASSWORD = "doctor";

    @Test(groups = "regress")
    public void simple_calc_test(){
        Assert.assertEquals(2 + 2, 5, "Wrong number");
    }

    @Test(groups = "noregress")
    public void simple_calc_test2(){
        Assert.assertEquals(2 + 3, 5, "Wrong number");
    }

    @Test(description = "simple param test")
    @Parameters({"name", "password"})
    public void parameterized_test(String name, String password){
        Assert.assertEquals(USER_NAME, name, "Wrong user name");
        Assert.assertEquals(USER_PASSWORD, password, "Wrong user password");
    }

    @Test(dataProvider = "credits")
    public void data_provider_test(String name, String password){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(USER_NAME, name, "Wrong user name");
        softAssert.assertEquals(USER_PASSWORD, password, "Wrong user password");
        softAssert.assertAll();
    }

    @DataProvider(name = "credits")
    public static Object[][] creditProvider(){
        return new Object[][]{
                {"Zoidberg","doctor"},
                {"Zoidberg","capo"},
                {"Leela","capo"}
        };
    }
}

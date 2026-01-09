package Utilities.LoyalFriendCare.lylTest.ikinci20;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;

public class US035TestAutomation {


    @Test
    public void test01(){
        System.out.println("US029 Test 01 Çalıştı");

        DimensonsUtils.setUpFullScreen("chrome","https://practicetestautomation.com/practice/");
    }

    @AfterMethod
    public void tearDown(){
        Utilities.utilities.DimensonsUtils.tearDown();
    }

    // https://testautomationpractice.blogspot.com/
}

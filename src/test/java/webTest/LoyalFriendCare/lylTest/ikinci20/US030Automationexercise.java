package webTest.LoyalFriendCare.lylTest.ikinci20;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import webTest.utilities.DimensonsUtils;

public class US030Automationexercise {


    @Test
    public void test01(){
        System.out.println("US029 Test 01 Çalıştı");

        DimensonsUtils.setUpFullScreen("chrome","automationexercise");
    }

    @AfterMethod
    public void tearDown(){
        webTest.utilities.DimensonsUtils.tearDown();
    }

}

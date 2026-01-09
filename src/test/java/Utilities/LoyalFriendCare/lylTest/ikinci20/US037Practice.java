package Utilities.LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;
import Utilities.utilities.ReusableMethods;

public class US037Practice {

    @Test
    public void test01(){
        System.out.println("US029 Test 01 Çalıştı");

      Page page= DimensonsUtils.setUpFullScreen("chrome","https://testautomationpractice.blogspot.com/");

        Locator targetElement = page.locator("//*[@id=\"country\"]");

        ReusableMethods.scrollToElementCenter(page, targetElement);

        page.selectOption("//*[@id=\"country\"]","japan");

        ReusableMethods.bekle(12);


    }

    @AfterMethod
    public void tearDown(){
        Utilities.utilities.DimensonsUtils.tearDown();
    }

    // https://testautomationpractice.blogspot.com/
}

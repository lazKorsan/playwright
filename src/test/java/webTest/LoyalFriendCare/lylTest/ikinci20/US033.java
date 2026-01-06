package webTest.LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import webTest.utilities.DimensonsUtils;

public class US033 {

    @Test
    public void test01(){
        System.out.println("US029 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome","herokuapp");

        page.locator("//*[@href='/checkboxes']").click();

        page.locator("//*[@id=\"checkboxes\"]/input[2]").click();

        page.locator("//*[@id=\"checkboxes\"]/input[1]").click();

    }

    @AfterMethod
    public void tearDown(){
        webTest.utilities.DimensonsUtils.tearDown();
    }
}

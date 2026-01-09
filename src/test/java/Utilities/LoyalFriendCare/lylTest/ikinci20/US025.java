package Utilities.LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;

public class US025 {

    @Test
    public void test01(){
        System.out.println("US025 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUp("chrome", "fullScreen", "google");

        page.type("//*[@id=\"APjFqb\"]","google");
        page.keyboard().press("Enter");

    }
}

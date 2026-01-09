package Utilities.LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;

public class US045clickMethod {

    @Test
    public void test01(){
        System.out.println("US045 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome", "loyalfriend");
        page.click("//*[@id=\"menu\"]/ul/li[2]/span/a");


        page.pause();
    }
}

package webTest.LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import webTest.utilities.DimensonsUtils;

public class US055 {

    @Test
    public void test01(){
        System.out.println("US055 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome","https://www.w3schools.com/html/html_links.asp");
    }
}

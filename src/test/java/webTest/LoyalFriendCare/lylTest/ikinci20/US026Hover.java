package webTest.LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import webTest.utilities.DimensonsUtils;
import webTest.utilities.ReusableMethods;

public class US026Hover {

    @Test
    public void test01(){
        System.out.println("US026 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUp("chrome", "fullScreen", "testotomasyonu");

        page.type("//*[@id=\"header_sticky\"]/header/div[2]/div/div[2]/form/label","Shoes");
        page.keyboard().press("Enter");

        page.hover("//*[@id=\"shopping-list\"]/div/ul/li[1]/div/a/img");

        ReusableMethods.bekle(3);

        DimensonsUtils.tearDown();

    }
}

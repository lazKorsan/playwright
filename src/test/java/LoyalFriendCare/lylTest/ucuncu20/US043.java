package LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;

public class US043 {

    @Test
    public void test01(){
        System.out.println("US043 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome", "loyalfriend");

        System.out.println(page.getByText("Our veterinary services are").innerText());
        page.pause();




    }

}

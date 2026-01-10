package LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;

public class US044playwrightdev {

    @Test
    public void test01(){
        System.out.println("US044 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome", "https://playwright.dev/");
    }

}

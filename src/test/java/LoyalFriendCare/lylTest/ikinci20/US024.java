package LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;

public class US024 {

    @Test
    public void test01(){

        Page page = DimensonsUtils.setUp("firefox", "fullScreen", "loyalfriend");

    }
}

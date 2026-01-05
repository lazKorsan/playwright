package webTest.LoyalFriendCare.lylTest.ilk20;

import org.testng.annotations.Test;
import webTest.utilities.BaseTest;
import webTest.utilities.ReusableMethods;

public class US019 extends BaseTest {

    @Test
    public void tc01() {
        page.navigate("https://qa.loyalfriendcare.com/en/login");
        System.out.println("Page title: " + page.title());

        ReusableMethods.bekle(13);
    }
}

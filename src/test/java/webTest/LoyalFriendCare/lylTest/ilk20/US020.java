package webTest.LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.Browser;
import org.testng.annotations.Test;
import webTest.utilities.BaseTest;
import webTest.utilities.ReusableMethods;
import webTest.utilities.ViewportManager;

public class US020 extends BaseTest {
    @Test
    public void tc01(){
        ViewportManager.setMaximized(new Browser.NewContextOptions());
        page.navigate("https://querycart.com/#/home");
        System.out.println("Page title: " + page.title());
        ReusableMethods.bekle(22223);

    }
}

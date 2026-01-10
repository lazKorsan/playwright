package LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.Browser;
import org.testng.annotations.Test;
import Utilities.utilities.ViewportManager;

public class US017 {
    @Test
    public void tc01(){

        Browser.NewContextOptions options = new Browser.NewContextOptions();

        ViewportManager.setMaximized(options);



    }
}

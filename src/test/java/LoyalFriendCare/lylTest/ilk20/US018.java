package LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.Browser;
import org.testng.annotations.Test;
import Utilities.utilities.ViewportManager;



public class US018 {

    @Test
    public void tc01(){

     // US011.browserOpen("https://qa.loyalfriendcare.com/en/login");

      US016.maximezedBrowser();


    }

    @Test
    public void tc02(){
       ViewportManager.setMaximized(new Browser.NewContextOptions());
    }

}

package Utilities.LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;
import Utilities.utilities.ReusableMethods;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class US054verify {
    
    @Test
    public void test01(){
        System.out.println("US054 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome","https://www.ebay.com/");

        Locator signInButton = page.locator("//*[@id=\"gh\"]/nav/div[1]/span[1]/span/a");

        ReusableMethods.verify(() -> assertThat(signInButton).isVisible());
        
        ReusableMethods.verify(() -> assertThat(signInButton).isEnabled());
    }
}

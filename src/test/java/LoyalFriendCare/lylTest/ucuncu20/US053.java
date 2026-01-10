package LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class US053 {

   @Test
    public void test01(){
        System.out.println("US053 Test 01 Çalıştı");

       Page page = DimensonsUtils.setUpFullScreen("chrome","https://www.ebay.com/");

       Locator signInButton = page.locator("//*[@id=\"gh\"]/nav/div[1]/span[1]/span/a");
       
       verify(() -> assertThat(signInButton).isVisible());

       verify(() -> assertThat(signInButton).isEnabled());

       signInButton.click();
    }

    public static void verify(Runnable assertion) {
        try {
            assertion.run();
            System.out.println("true");
        } catch (Throwable e) {
            System.out.println("false");
            throw e;
        }
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("US053 Test 01 Sonlandı");
    }
}

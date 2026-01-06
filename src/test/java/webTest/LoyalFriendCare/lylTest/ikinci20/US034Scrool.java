package webTest.LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import webTest.utilities.DimensonsUtils;
import webTest.utilities.ReusableMethods;

public class US034Scrool {

    @Test
    public void test01(){
        System.out.println("US029 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome","LOYALFRİEND");

        ReusableMethods.scrollToBottom(page);

        ReusableMethods.bekle(4);

        ReusableMethods.scrollToTop(page);

        ReusableMethods.bekle(4);
        
        // String olarak verilen xpath'i Locator nesnesine çeviriyoruz
        Locator targetElement = page.locator("//*[@id=\"page\"]/main/div/div[2]/div[5]/a/figure/img");
        
        // Metodu doğru parametrelerle çağırıyoruz
        ReusableMethods.scrollToElementCenter(page, targetElement);
        
        ReusableMethods.bekle(2);
    }

    @AfterMethod
    public void tearDown(){
        webTest.utilities.DimensonsUtils.tearDown();
    }
}

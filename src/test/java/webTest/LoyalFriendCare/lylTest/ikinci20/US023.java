package webTest.LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import webTest.utilities.DimensonsUtils;

public class US023 {

    @Test
    public void testFullScreenNavigation() {
        // Full screen chrome ile Loyalfriend
        Page page = DimensonsUtils.setUp("chrome", "fullScreen", "loyalfriend");
        DimensonsUtils.bekle(5);

        // Title kontrolü
        String title = page.title();
        System.out.println("Sayfa Başlığı: " + title);

        // Ekran görüntüsü
        DimensonsUtils.takeScreenshot("loyalfriend_home.png");

        DimensonsUtils.tearDown();
    }
}

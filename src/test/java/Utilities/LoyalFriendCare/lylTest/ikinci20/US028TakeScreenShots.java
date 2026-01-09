package Utilities.LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;
import Utilities.utilities.TakeScreenShotsMultiFunctional;

import java.util.HashMap;
import java.util.Map;

public class US028TakeScreenShots {

    @Test
    public void test01(){
        System.out.println("US028 Test 01 Çalıştı");

        // Sayfayı aç
        Page page = DimensonsUtils.setUpFullScreen("chrome","loyalfriend");

        // Kırmızı çerçeveye alınacak elementler
        Map<Locator, String> redList = new HashMap<>();
        redList.put(page.locator("//*[@id='menu']/ul/li[1]/span/a"), "Home");
        redList.put(page.locator("//*[@id='menu']/ul/li[2]/span/a"), "About Us");

        // Yeşil çerçeveye alınacak elementler
        Map<Locator, String> greenList = new HashMap<>();
        greenList.put(page.locator("//*[@id='menu']/ul/li[4]/span/a"), "Doctors");
        greenList.put(page.locator("//*[@id='menu']/ul/li[5]/span/a"), "Medicines");

        // Gelişmiş ekran görüntüsünü al
        TakeScreenShotsMultiFunctional.takeAdvancedScreenshot(page, "MenuElementsTest", greenList, redList);

        // Test bitiminde tarayıcıyı kapatmak iyi bir pratiktir, ancak DimensonsUtils içinde yönetiliyorsa gerek olmayabilir.
        // page.close();
    }
}

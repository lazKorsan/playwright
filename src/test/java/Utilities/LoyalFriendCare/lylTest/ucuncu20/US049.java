package Utilities.LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;

public class US049 {

    @Test
    public void test01(){
        System.out.println("US0049 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome", "loyalfriend");

        Locator aboutusButton = page.locator("(//*[@target='_self'])[2]");
        aboutusButton.isVisible();
        System.out.println(aboutusButton.isVisible());
        aboutusButton.isEnabled();
        System.out.println(aboutusButton.isEnabled());

        System.out.println(aboutusButton.innerText());

        System.out.println(aboutusButton.textContent());

        System.out.println(aboutusButton.innerHTML());

        System.out.println("//<!--todo -->");
        System.out.println("target attribute degeri: " + aboutusButton.getAttribute("target"));

        System.out.println("href attribute degeri: "+aboutusButton.getAttribute("href"));


        System.out.println("//<!--todo -->");

        aboutusButton.click();
    }
}

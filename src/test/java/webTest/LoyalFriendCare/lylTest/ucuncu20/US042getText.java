package webTest.LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import webTest.utilities.DimensonsUtils;

public class US042getText {

    @Test
    public void test01(){
        System.out.println("US042 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome", "loyalfriend");

        Locator homeButton = page.locator("(//*[@target='_self'])[3]");

        homeButton.isVisible();
        System.out.println(homeButton.isVisible());

        homeButton.isEnabled();
        System.out.println(homeButton.isEnabled());

        System.out.println(homeButton.innerText());

        System.out.println(homeButton.textContent());

        System.out.println(homeButton.innerHTML());

        System.out.println("//<!--todo -->");

        System.out.println("target attribute degeri: " + homeButton.getAttribute("target"));

        System.out.println("href attribute degeri: "+homeButton.getAttribute("href"));

        System.out.println("//<!--todo -->");



    }
}

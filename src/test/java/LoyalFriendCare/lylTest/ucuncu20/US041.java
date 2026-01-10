package LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;

public class US041 {

    @Test
    public void test01() {

        System.out.println("US041 Test 01 Çalıştı");

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

        System.out.println(homeButton.getAttribute("target"));

        System.out.println(homeButton.getAttribute("href"));

        System.out.println("//<!--todo -->");

        System.out.println(homeButton.getAttribute("class"));

        System.out.println(homeButton.getAttribute("id"));

        System.out.println(homeButton.getAttribute("title"));

        System.out.println(homeButton.getAttribute("aria-label"));

        homeButton.click();






    }

}

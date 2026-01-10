package LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;
import Utilities.utilities.ReusableMethods;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class US058Actions {

    @Test
    public void test01() {
        System.out.println("US058 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome", "https://www.ebay.com/");

        Locator searchBox = page.getByPlaceholder("Search for anything");

        searchBox.fill("bycicle");


        searchBox.fill("melodi");
        searchBox.press("Enter");
        //page.keyboard().press("Enter");


        ReusableMethods.bekle(12);
    }

    @Test
    public void test02() {
        System.out.println("US058 Test 02 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome", "https://www.ebay.com/");

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("register")).click();

        ReusableMethods.verify(() -> assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("register"))).isVisible());



    }
}

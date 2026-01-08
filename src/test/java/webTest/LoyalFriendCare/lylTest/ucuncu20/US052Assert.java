package webTest.LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;
import webTest.utilities.DimensonsUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class US052Assert {

    @Test
    public void test01() {
        System.out.println("US0049 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome", "loyalfriend");

        Locator aboutusButton = page.locator("//*[@id=\"menu\"]/ul/li[2]/span/a");

        assert aboutusButton.isVisible();

        PlaywrightAssertions.assertThat(page).hasURL("https://qa.loyalfriendcare.com/en");


    }

}

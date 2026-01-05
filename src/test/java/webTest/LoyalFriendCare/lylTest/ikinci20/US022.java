package webTest.LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import webTest.LoyalFriendCare.Pages.LoyalFriendCarePages;
import webTest.LoyalFriendCare.beginnerMethods.BeforeAfter;
import webTest.utilities.ReusableMethods;
import webTest.utilities.ViewportManager;

import java.awt.*;
import java.util.Arrays;

import static webTest.LoyalFriendCare.beginnerMethods.LoginMethod.mail;
import static webTest.LoyalFriendCare.beginnerMethods.LoginMethod.password;

public class US022 {

    @Test
    public void tc01(){

        try (Playwright playwright = Playwright.create()) {
            // 1. Tarayıcıyı fiziksel olarak tam ekran başlat
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(Arrays.asList("--start-maximized")));

            // 2. Viewport'u NULL yaparak içeriğin pencereye tam sığmasını sağla
            // Bu adım, sağda kalan login kutusunun görünmesini sağlar.
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null));

            Page page = context.newPage();
            page.navigate("https://qa.loyalfriendcare.com");

            ReusableMethods.bekle(7);
        }

    }

}

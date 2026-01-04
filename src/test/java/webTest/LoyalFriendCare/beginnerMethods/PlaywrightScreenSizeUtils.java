package webTest.LoyalFriendCare.beginnerMethods;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType;
import webTest.utilities.ReusableMethods;

import java.util.Arrays;

public class PlaywrightScreenSizeUtils {

    public static void setMaximeze(){

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

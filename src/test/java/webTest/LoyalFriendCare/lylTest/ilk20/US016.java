package webTest.LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import webTest.utilities.ReusableMethods;

import java.util.Arrays;

public class US016 {





    @Test
    public static void maximezedBrowser() {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(Arrays.asList("--start-maximized")));


            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null));

            Page page = context.newPage();
            page.navigate("https://qa.loyalfriendcare.com");

            ReusableMethods.bekle(7);
        }



    }

    @Test
    public static void navizittifericonilardeytinktintirili() {
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

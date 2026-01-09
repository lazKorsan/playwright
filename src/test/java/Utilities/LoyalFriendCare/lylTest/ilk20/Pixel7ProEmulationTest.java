package Utilities.LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Pixel7ProEmulationTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));  // Görünür olsun diye headless false

            // Pixel 7 Pro device descriptors (2025 itibariyle güncel değerler)
            Browser.NewContextOptions options = new Browser.NewContextOptions()
                    .setViewportSize(412, 915)                  // Pixel 7 Pro viewport
                    .setDeviceScaleFactor(2.75)                 // Pixel density
                    .setIsMobile(true)
                    .setHasTouch(true)
                    .setUserAgent("Mozilla/5.0 (Linux; Android 14; Pixel 7 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.6099.199 Mobile Safari/537.36");

            // İsteğe bağlı: Landscape modu için
            // .setViewportSize(915, 412)

            BrowserContext context = browser.newContext(options);
            Page page = context.newPage();
            page.navigate("https://www.google.com");



            // Bekle ve etkileşim ekle (örnek)
            page.waitForTimeout(5000);

            // Screenshot al
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("google-pixel7pro.png")));

            context.close();
        }
    }
}
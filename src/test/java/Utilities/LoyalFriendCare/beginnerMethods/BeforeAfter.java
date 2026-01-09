package Utilities.LoyalFriendCare.beginnerMethods;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import Utilities.utilities.ConfigLoader;

public class BeforeAfter {

    public static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    // Bu metot, Playwright, Browser ve Page nesnelerini başlatıp Page'i döndürür.
    // Test sınıflarında bu Page nesnesi üzerinden işlemler yapılabilir.
    public static Page openLoyalFriendCarePage() {
        // Eğer zaten açık bir session varsa onu kapatıp yenisini açabiliriz veya mevcut olanı döndürebiliriz.
        // Şimdilik her çağrıldığında yeni bir session başlatıyoruz.
        if (playwright == null) {
            playwright = Playwright.create();
        }
        
        String browserName = ConfigLoader.getInstance().getBrowser();

        switch (browserName.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chromium":
            case "chrome":
            default:
                browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                break;
        }

        // Viewport ayarını null yaparak tarayıcı penceresinin boyutuna uyum sağlamasını (responsive) sağlıyoruz.
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        page = context.newPage();
        
        // ConfigLoader'dan URL'i alıp sayfayı açıyoruz
        page.navigate(ConfigLoader.getInstance().getLoyalUrl());
        
        return page;
    }

    public static void closeTest() {
        if (page != null) {
            page.close();
            page = null;
        }
        if (context != null) {
            context.close();
            context = null;
        }
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }
}

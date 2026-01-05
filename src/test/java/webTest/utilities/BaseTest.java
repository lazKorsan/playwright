package webTest.utilities;

import com.microsoft.playwright.*;
import org.testng.annotations.*;
import webTest.utilities.ViewportManager;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    @Parameters({"deviceType"}) // XML dosyasından cihaz tipini alabiliriz
    public void setup(@Optional("DESKTOP") String deviceType) {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // Options nesnesini oluşturuyoruz
        Browser.NewContextOptions options = new Browser.NewContextOptions();

        // ViewportManager kullanımı
        if (deviceType.equalsIgnoreCase("ANDROID")) {
            ViewportManager.setAndroidSize(options);
        } else {
            ViewportManager.setMaximized(options);
        }

        context = browser.newContext(options);
        page = context.newPage();
    }

    @AfterMethod
    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}

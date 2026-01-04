package webTest.LoyalFriendCare.lylTest;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import webTest.utilities.ReusableMethods;

import java.awt.*;
import java.util.Arrays;

public class US016 {

    @Test
    public void testViewSizeDimensions() {

        //Dimension screenSize = new Dimension();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int hight = screenSize.height;
        Playwright playwright = Playwright.create();


        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));


        Page page = browser.newPage();

        page.navigate("https://qa.loyalfriendcare.com/en/login");

        page.setViewportSize(width, hight);

        ReusableMethods.bekle(7);

    }

    @Test
    public void testviewmanmialiataitiions() {

        // 1. Ekranın gerçek piksel boyutlarını Toolkit ile alın
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        Playwright playwright = Playwright.create();

        // 2. Tarayıcıyı tam ekran (maximized) başlatmak için argüman ekleyin
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(Arrays.asList("--start-maximized"))); // Tarayıcı penceresini büyütür

        // 3. Viewport'u null yaparak sayfanın tüm pencereyi kaplamasını sağlayın
        // Veya manuel piksel değeri atayın
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(width, height)); // Aldığınız piksel değerlerini buraya aktarın

        Page page = context.newPage();
        page.navigate("qa.loyalfriendcare.com");

        // Bekleme metodu
        // ReusableMethods.bekle(7);

    }

    @Test
    public void maximezedBrowser() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double witdh = screenSize.getWidth();
        double hight = screenSize.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize((int) witdh, (int) hight));

        Page page = context.newPage();
        page.navigate("https://qa.loyalfriendcare.com/en/login");

        ReusableMethods.bekle(7);

    }

    @Test
    public void navizittifericonilardeytinktintirili() {
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

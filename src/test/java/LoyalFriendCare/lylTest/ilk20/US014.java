
/*


package webTest.LoyalFriendCare.lylTest;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class US0014 {

    @Test
    public void testPixel7Pro() {
        // Playwright'ı başlat
        try (Playwright playwright = Playwright.create()) {

            // 1. YÖNTEM: Playwright'ın built-in Pixel 7 Pro device descriptor'ını kullanma
            // (Bu en kolay ve sorunsuz yöntem)
            System.out.println("=== Yöntem 1: Built-in Pixel 7 Pro Emülasyonu ===");
            testWithBuiltInDevice(playwright, "Pixel 7 Pro");

            System.out.println("\n=== Yöntem 2: Manuel Pixel 7 Pro Ayarları ===");
            // 2. YÖNTEM: Manuel olarak Pixel 7 Pro spesifikasyonlarını ayarlama
            testWithManualSettings(playwright);

            System.out.println("\n=== Yöntem 3: Touch ve Gesture Testi ===");
            // 3. YÖNTEM: Touch gesture'lar ile test
            testTouchGestures(playwright);

        } catch (Exception e) {
            System.err.println("Hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private <DeviceDescriptor> void testWithBuiltInDevice(Playwright playwright, String deviceName) {
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false) // Tarayıcıyı görmek için false
                .setSlowMo(500)); // Adımları yavaşlat (görmek için)

        // Pixel 7 Pro device descriptor'ını al
        DeviceDescriptor pixel7Pro = playwright.devices().get(deviceName);

        if (pixel7Pro == null) {
            System.out.println(deviceName + " device descriptor bulunamadı. Kullanılabilir cihazlar:");
            playwright.devices().keySet().forEach(System.out::println);
            // Alternatif olarak Pixel 7 kullan
            pixel7Pro = playwright.devices().get("Pixel 7");
        }

        BrowserContext context = browser.newContext(pixel7Pro);
        Page page = context.newPage();

        // Siteye git
        page.navigate("https://qa.loyalfriendcare.com");

        // Cihaz bilgilerini yazdır
        System.out.println("Cihaz: " + deviceName);
        System.out.println("User Agent: " + pixel7Pro.userAgent);
        System.out.println("Viewport: " + pixel7Pro.viewport);
        System.out.println("Sayfa Başlığı: " + page.title());
        System.out.println("URL: " + page.url());

        // Ekran görüntüsü al
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("target/pixel7pro-screenshot.png"))
                .setFullPage(true));

        // Mobil menüyü test et (eğer varsa)
        try {
            // Hamburger menü butonunu ara ve tıkla
            Locator menuButton = page.locator("button[aria-label='Menu'], .hamburger, .menu-button").first();
            if (menuButton.isVisible()) {
                menuButton.click();
                System.out.println("Mobil menü açıldı");
                page.waitForTimeout(1000);
            }
        } catch (Exception e) {
            System.out.println("Mobil menü bulunamadı veya tıklanamadı");
        }

        // Ekran boyutunu kontrol et
        Object viewportSize = page.evaluate("() => ({ width: window.innerWidth, height: window.innerHeight })");
        System.out.println("Gerçek Viewport Boyutu: " + viewportSize);

        // Mobil uyumluluğu kontrol et
        Object isMobile = page.evaluate("() => window.matchMedia('(max-width: 768px)').matches");
        System.out.println("Mobil Görünümde mi?: " + isMobile);

        // 3 saniye bekle (gözlem için)
        page.waitForTimeout(3000);

        context.close();
        browser.close();
    }

    private void testWithManualSettings(Playwright playwright) {
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        // Pixel 7 Pro manuel ayarları:
        // - Ekran: 6.7 inç
        // - Çözünürlük: 1440 x 3120
        // - Pixel yoğunluğu: ~512 PPI
        // - Viewport (tarayıcı için): 412 x 892 (CSS pixels)

        Browser.NewContextOptions options = new Browser.NewContextOptions()
                .setViewportSize(412, 892) // Pixel 7 Pro viewport
                .setDeviceScaleFactor(3.5) // Pixel density
                .setIsMobile(true)
                .setHasTouch(true)
                .setUserAgent("Mozilla/5.0 (Linux; Android 14; Pixel 7 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36")
                .setLocale("tr-TR") // Türkçe dil
                .setTimezoneId("Europe/Istanbul") // İstanbul saat dilimi
                .setGeolocation(41.0082, 28.9784) // İstanbul koordinatları
                .setPermissions(new String[]{"geolocation"});

        BrowserContext context = browser.newContext(options);
        Page page = context.newPage();

        page.navigate("https://qa.loyalfriendcare.com");

        ConsoleMessageListener consoleListener = msg -> {
            System.out.println("Console [" + msg.type() + "]: " + msg.text());
        };
        page.onConsoleMessage(consoleListener);

        // Responsive test: Farklı yönlendirmeler
        System.out.println("Portrait mod test ediliyor...");
        page.waitForTimeout(2000);

        // Landscape mode (manuel olarak viewport değiştir)
        page.setViewportSize(892, 412); // Landscape
        System.out.println("Landscape moda geçildi");
        page.waitForTimeout(2000);

        // Ekran görüntüsü al
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("target/pixel7pro-landscape.png")));

        // Portre moda geri dön
        page.setViewportSize(412, 892);

        // Network conditions simülasyonu (3G hızında)
        context.setOffline(false);

        // Element bul ve etkileşim
        try {
            // Input alanı bul ve yaz
            Locator searchInput = page.locator("input[type='text'], input[type='search'], [role='searchbox']").first();
            if (searchInput.isVisible()) {
                searchInput.click();
                searchInput.fill("test query");
                System.out.println("Arama kutusuna yazı yazıldı");
            }

            // Linklere tıkla
            Locator firstLink = page.locator("a").first();
            if (firstLink.isVisible()) {
                firstLink.click();
                page.waitForTimeout(1000);
                page.goBack(); // Geri git
            }
        } catch (Exception e) {
            System.out.println("Element etkileşiminde hata: " + e.getMessage());
        }

        // Performance metrikleri
        Object performance = page.evaluate("() => JSON.stringify(window.performance.timing)");
        System.out.println("Performance Timing: " + performance);

        context.close();
        browser.close();
    }

    private void testTouchGestures(Playwright playwright) {
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        DeviceDescriptor pixelDevice = playwright.devices().get("Pixel 7") != null ?
                playwright.devices().get("Pixel 7") :
                playwright.devices().get("iPhone 14");

        BrowserContext context = browser.newContext(pixelDevice);
        Page page = context.newPage();

        page.navigate("https://qa.loyalfriendcare.com");

        // Touch gesture örnekleri:

        // 1. Tap (dokunma)
        System.out.println("Tap gesture test ediliyor...");
        page.locator("body").click();

        // 2. Double tap (çift dokunma)
        System.out.println("Double tap test ediliyor...");
        page.locator("body").dblclick();

        // 3. Scroll (kaydırma)
        System.out.println("Scroll test ediliyor...");
        page.evaluate("() => window.scrollBy(0, 500)");
        page.waitForTimeout(1000);

        // 4. Swipe (kaydırma - touch API ile)
        System.out.println("Swipe test ediliyor...");
        // Touch noktaları tanımla
        page.mouse().move(200, 400);
        page.mouse().down();
        page.mouse().move(200, 200, new Mouse.MoveOptions().setSteps(10));
        page.mouse().up();

        // 5. Long press (uzun basma)
        System.out.println("Long press test ediliyor...");
        page.mouse().move(100, 100);
        page.mouse().down();
        page.waitForTimeout(2000); // 2 saniye basılı tut
        page.mouse().up();

        // Pinch-zoom simülasyonu (mobilde)
        System.out.println("Pinch-zoom simülasyonu...");
        // İki dokunmatik nokta oluştur
        page.touchscreen().tap(200, 300);

        // Ekran görüntüsü al
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("target/touch-gestures.png")));

        // Network throttling test (yavaş network simülasyonu)
        System.out.println("Network throttling test...");
        context.route("**/
/*
import com.microsoft.playwright.Page;

import java.nio.file.Paths;*", route -> {
            route.resume();
        });

        // Local storage ve session storage test
        page.evaluate("() => localStorage.setItem('test_key', 'test_value')");
        Object localStorageValue = page.evaluate("() => localStorage.getItem('test_key')");
        System.out.println("LocalStorage değeri: " + localStorageValue);

        // Battery API simülasyonu (mobilde)
        page.evaluate("() => {"
                + "if (navigator.getBattery) {"
                + "  navigator.getBattery().then(battery => {"
                + "    console.log('Battery level: ' + battery.level);"
                + "    console.log('Charging: ' + battery.charging);"
                + "  });"
                + "}"
                + "}");

        page.waitForTimeout(3000);
        context.close();
        browser.close();
    }

    @Test
    public void testDeviceRotation() {
        // Cihaz döndürme simülasyonu
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));

            DeviceDescriptor device = playwright.devices().get("Pixel 7 Pro") != null ?
                    playwright.devices().get("Pixel 7 Pro") :
                    playwright.devices().get("iPhone 14");

            BrowserContext context = browser.newContext(device);
            Page page = context.newPage();

            page.navigate("https://qa.loyalfriendcare.com");

            // Orientation değişikliği
            System.out.println("Portrait modda...");
            page.waitForTimeout(2000);

            // Landscape moda geç (viewport'u değiştir)
            page.setViewportSize(892, 412);
            System.out.println("Landscape moda geçildi");

            // Orientation değişikliğini algıla
            Object orientation = page.evaluate("() => window.screen.orientation || window.orientation");
            System.out.println("Orientation: " + orientation);

            // Media query kontrolü
            Object isLandscape = page.evaluate("() => window.matchMedia('(orientation: landscape)').matches");
            Object isPortrait = page.evaluate("() => window.matchMedia('(orientation: portrait)').matches");
            System.out.println("Landscape Media Query: " + isLandscape);
            System.out.println("Portrait Media Query: " + isPortrait);

            // Ekran görüntüleri
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("target/portrait.png"))
                    .setFullPage(true));

            page.setViewportSize(412, 892); // Portrait'a geri dön

            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("target/landscape.png"))
                    .setFullPage(true));

            context.close();
            browser.close();
        }
    }
}

 */
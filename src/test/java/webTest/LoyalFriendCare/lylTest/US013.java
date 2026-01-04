/*



package webTest.LoyalFriendCare.lylTest;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;


import java.util.List;

public class US013 {

    @Test
    public void android() {
        // Playwright'ı başlat
        try (Playwright playwright = Playwright.create()) {

            // Android cihazları listele (ADB açık olmalı ve emülatör çalışıyor olmalı)
            // Not: Playwright'ın Android desteği deneysel (experimental) olabilir ve bazı sürümlerde
            // Android sınıfı doğrudan erişilebilir olmayabilir.
            // Ancak 1.44.0 sürümünde desteklenmektedir.

            // Eğer AndroidDevice sınıfı bulunamıyorsa, Playwright'ın doğru import edildiğinden emin olun.
            // Genellikle com.microsoft.playwright.AndroidDevice şeklindedir.

            List<AndroidDevice> devices = playwright.android().devices();

            if (devices.isEmpty()) {
                throw new RuntimeException("Hiçbir Android cihaz bulunamadı! Emülatörün açık olduğundan ve 'adb devices' komutunda göründüğünden emin olun.");
            }

            // İlk bulunan cihaza bağlan
            AndroidDevice device = devices.get(0);
            System.out.println("Bağlanılan Cihaz Model: " + device.model());

            // Cihazda Chrome tarayıcısını başlat
            // Not: Emülatörde Chrome yüklü ve güncel olmalıdır.
            BrowserContext context = device.launchBrowser();

            // Yeni bir sekme aç
            Page page = context.newPage();

            // Telefondaki Chrome'da siteye git
            page.navigate("https://qa.loyalfriendcare.com");
            System.out.println("Sayfa Başlığı: " + page.title());

            // Biraz bekle (Gözlemlemek için)
            page.waitForTimeout(3000);

            // Fiziksel 'Home' tuşuna bas (Uygulamayı arka plana atar)
            device.input().press("Home");

            // Tarayıcıyı kapat
            context.close();

            // Cihaz bağlantısını kapat (Opsiyonel, try-with-resources playwright'ı kapatır ama cihazı serbest bırakmak iyidir)
            device.close();
        }
    }
}


 */

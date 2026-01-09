package Utilities.LoyalFriendCare.beginnerMethods;

import com.microsoft.playwright.Browser;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Playwright için ekran boyutu ve cihaz görünüm ayarlarını yöneten yardımcı sınıf.
 */
public class PlaywrightScreenSizeUtils {

    /**
     * Masaüstü için tam ekran (Maximized) ayarlarını uygular.
     * Viewport'u NULL yaparak içeriğin tarayıcıya tam sığmasını sağlar.
     */
    public static void setMaximized(Browser.NewContextOptions options) {
        // Viewport'u null yapmak, Playwright'ın pencere boyutuna
        // otomatik uyum sağlamasını sağlar (Login kutusunun gizlenmesini önler).
        options.setViewportSize(null);
    }

    /**
     * Standart Android cihaz boyutlarını ve mobil özelliklerini uygular.
     */
    public static void setAndroidSize(Browser.NewContextOptions options) {
        // Genel kabul görmüş Android (Pixel/Galaxy) viewport boyutları
        options.setViewportSize(360, 800)
                .setIsMobile(true)
                .setHasTouch(true)
                .setDeviceScaleFactor(2.0); // Daha net bir mobil görünüm için
    }

    /**
     * Bilgisayarın ekran çözünürlüğünü dinamik olarak alıp uygular.
     */
    public static void setPhysicalScreenSize(Browser.NewContextOptions options) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        options.setViewportSize(width, height);
    }

    /**
     * Özel piksel değerleri ile ekran boyutunu ayarlar.
     */
    public static void setCustomSize(Browser.NewContextOptions options, int width, int height) {
        options.setViewportSize(width, height);
    }
}

package webTest.utilities;

import com.microsoft.playwright.Page;

public class ReusableMethods {

    /**
     * Belirtilen saniye kadar bekler.
     * Java'nın Thread.sleep() metodunu kullanır.
     * Test otomasyonunda hard wait önerilmez ancak debug veya zorunlu hallerde kullanılabilir.
     *
     * @param saniye Beklenecek süre (saniye cinsinden)
     */
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Playwright'ın kendi bekleme mekanizmasını kullanarak bekler.
     * Bu yöntem, tarayıcı üzerinde işlem yaparken daha güvenli olabilir.
     *
     * @param page   Playwright Page nesnesi
     * @param saniye Beklenecek süre (saniye cinsinden)
     */
    public static void bekle(Page page, double saniye) {
        page.waitForTimeout(saniye * 1000);
    }
}

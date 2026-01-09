package Utilities.LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;

public class US047TryCatch {

    @Test
    public void test01() {
        System.out.println("US047 Try-Catch Testi Başladı");

        Page page = null;

        try {
            // Tarayıcıyı başlat
            page = DimensonsUtils.setUpFullScreen("chrome", "loyalfriend");
            
            // Sayfanın yüklenmesini bekle
            page.waitForLoadState();

            String homeXPath = "//*[@id='menu']/ul/li[1]/span/a";
            String departmentsXPath = "//*[@id='menu']/ul/li[3]/span/a";
            String medicinesXPath = "//*[@id='menu']/ul/li[5]/span/a";

            // Home butonunun görünürlüğünü kontrol et
            boolean isHomeVisible = false;
            try {
                isHomeVisible = page.isVisible(homeXPath);
                System.out.println("Home Butonu Görünür mü? : " + isHomeVisible);
            } catch (Exception e) {
                System.err.println("Home butonu kontrol edilirken hata oluştu: " + e.getMessage());
            }

            if (isHomeVisible) {
                try {
                    System.out.println("DURUM: Home butonu GÖRÜNÜR. Departments butonuna tıklanacak.");
                    page.locator(departmentsXPath).highlight();
                    page.click(departmentsXPath);
                    System.out.println("BAŞARILI: Departments butonuna tıklandı.");
                } catch (PlaywrightException e) {
                    System.err.println("HATA: Departments butonuna tıklanamadı! Sebep: " + e.getMessage());
                    // Alternatif bir işlem veya ekran görüntüsü alma buraya eklenebilir
                }
            } else {
                try {
                    System.out.println("DURUM: Home butonu GÖRÜNÜR DEĞİL. Medicines butonuna tıklanacak.");
                    page.locator(medicinesXPath).highlight();
                    page.click(medicinesXPath);
                    System.out.println("BAŞARILI: Medicines butonuna tıklandı.");
                } catch (PlaywrightException e) {
                    System.err.println("HATA: Medicines butonuna tıklanamadı! Sebep: " + e.getMessage());
                }
            }

            // Sonucu görmek için kısa bir bekleme
            page.waitForTimeout(3000);

        } catch (Exception e) {
            System.err.println("GENEL TEST HATASI: Beklenmeyen bir durum oluştu. " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Test bitiminde (hata olsa bile) temizlik işlemleri
            System.out.println("Test tamamlandı, kaynaklar temizleniyor...");
            if (page != null) {
                // page.close(); // İsteğe bağlı: DimensonsUtils içinde yönetiliyorsa gerek olmayabilir
            }
            // DimensonsUtils.tearDown(); // Eğer varsa
        }
    }
}

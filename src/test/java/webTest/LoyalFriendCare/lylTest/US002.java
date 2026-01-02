package webTest.LoyalFriendCare.lylTest;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import webTest.LoyalFriendCare.Pages.LoyalFriendCarePages;
import webTest.LoyalFriendCare.beginnerMethods.OpenLoyalfriendCare;




public class US002 {
    // LOCATE VE TIKLAMA İŞLEMLERİ


    @Test
    public void tc01(){

        Page page = OpenLoyalfriendCare.openLoyalFriendCarePage();

        // Playwright'ta XPath kullanımı:
        // Playwright XPath'i doğrudan destekler. "xpath=..." şeklinde veya doğrudan XPath yazarak kullanabilirsiniz.
        // Ancak Playwright'ın kendi selector motoru (CSS, text, vb.) genellikle daha güçlü ve okunabilirdir.
        
        // 1. Yöntem: Doğrudan XPath kullanımı (JavaScript uyumlu hale getirmeye gerek yok, Playwright halleder)
        page.locator("//a[@href='https://qa.loyalfriendcare.com/Doctors']").click();

        // 2. Yöntem: Daha modern ve okunabilir Playwright selector'leri (Önerilen)
        // page.locator("text=Doctors").click(); // Eğer buton üzerinde "Doctors" yazıyorsa
        // page.locator("a:has-text('Doctors')").click(); // İçinde "Doctors" geçen link
        
        // Bekleme (Görmek için)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterTest
    public void tearDown() {
        OpenLoyalfriendCare.closeTest();

    }
}

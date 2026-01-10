package LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import LoyalFriendCare.Pages.LoyalFriendCarePages;
import LoyalFriendCare.beginnerMethods.BeforeAfter;

public class US003 {

    // LOCATE VE PAGES KLASS İŞLEMLERİ 
    
    @Test
    public void tc01(){
        // Sayfayı aç ve Page nesnesini al
        Page page = BeforeAfter.openLoyalFriendCarePage();
        
        // Page Object sınıfını başlat
        LoyalFriendCarePages loyalFriendCarePages = new LoyalFriendCarePages(page);
        
        // Doctors linkine tıkla (getDoctorsLink() locator'ını kullanarak)
        loyalFriendCarePages.getRegisterButton().click();
        
        // Alternatif olarak action metodunu da kullanabilirsiniz:
        // loyalFriendCarePages.clickDoctors();

        // Görmek için kısa bir bekleme
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        BeforeAfter.closeTest();
    }
}

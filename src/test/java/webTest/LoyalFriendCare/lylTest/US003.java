package webTest.LoyalFriendCare.lylTest;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import webTest.LoyalFriendCare.Pages.LoyalFriendCarePages;
import webTest.LoyalFriendCare.beginnerMethods.OpenLoyalfriendCare;

public class US003 {

    // LOCATE VE PAGES KLASS İŞLEMLERİ 
    
    @Test
    public void tc01(){
        // Sayfayı aç ve Page nesnesini al
        Page page = OpenLoyalfriendCare.openLoyalFriendCarePage();
        
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
        OpenLoyalfriendCare.closeTest();
    }
}

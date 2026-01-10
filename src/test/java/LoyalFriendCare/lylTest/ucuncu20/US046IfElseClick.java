package LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;

public class US046IfElseClick {

    @Test
    public void test01(){
        System.out.println("US046 Test 01 Başladı");

        Page page = DimensonsUtils.setUpFullScreen("chrome", "loyalfriend");

        // Sayfanın tam yüklendiğinden emin olalım
        page.waitForLoadState();

        String homeXPath = "//*[@id='menu']/ul/li[1]/span/a";
        String departmentsXPath = "//*[@id='menu']/ul/li[3]/span/a";
        String medicinesXPath = "//*[@id='menu']/ul/li[5]/span/a";

        // Home butonunun görünürlüğünü kontrol et
        boolean isHomeVisible = page.isVisible(homeXPath);
        System.out.println("Home Butonu Görünür mü? : " + isHomeVisible);

        if (isHomeVisible){
            System.out.println("DURUM: Home butonu GÖRÜNÜR. Departments butonuna tıklanacak.");
            
            // Tıklanacak elementi vurgula (görsel kontrol için)
            page.locator(departmentsXPath).highlight();
            
            page.click(departmentsXPath);
            System.out.println("BAŞARILI: Departments butonuna tıklandı.");
        } else {
            System.out.println("DURUM: Home butonu GÖRÜNÜR DEĞİL. Medicines butonuna tıklanacak.");
            
            // Tıklanacak elementi vurgula
            page.locator(medicinesXPath).highlight();
            
            page.click(medicinesXPath);
            System.out.println("BAŞARILI: Medicines butonuna tıklandı.");
        }
        
        // Sonucu görmek için kısa bir bekleme
        page.waitForTimeout(3000);
    }
}

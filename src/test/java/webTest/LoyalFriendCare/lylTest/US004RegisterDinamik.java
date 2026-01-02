package webTest.LoyalFriendCare.lylTest;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import webTest.LoyalFriendCare.Pages.LoyalFriendCarePages;
import webTest.LoyalFriendCare.beginnerMethods.OpenLoyalfriendCare;
import webTest.LoyalFriendCare.beginnerMethods.RegisterMethod;
import webTest.utilities.ReusableMethods;

public class US004RegisterDinamik {

    // MAİLbOX GİRME İŞLEMLERİ
    @Test
    public void tc01(){

        Page page = OpenLoyalfriendCare.openLoyalFriendCarePage();

        LoyalFriendCarePages loyalFriendCarePages = new LoyalFriendCarePages(page);

        loyalFriendCarePages.getRegisterButton().click();

        ReusableMethods.bekle(3);
        
        String name = "lazKorsan";
        
        // Benzersiz bir email oluşturmak için
        String fakemail = name + System.currentTimeMillis() + "@gmail.com";
        String mail = fakemail;
        
        String fakePassword = "Loyal!" + System.currentTimeMillis();
        String password = fakePassword;

        System.out.println(mail);
        System.out.println(password);


        // Playwright ile form doldurma işlemleri
        // İsim alanını doldur
        loyalFriendCarePages.getNameInput().fill(name);
        
        // Email alanını doldur
        loyalFriendCarePages.getEmailInput().fill(mail);
        
        // Şifre alanını doldur
        loyalFriendCarePages.getPasswordInput().fill(password);

        page.keyboard().press("Tab");

        page.keyboard().type(password);


        
        // Kayıt ol butonuna tıkla (Bu butonu Pages sınıfına ekledim, selector'ü kontrol etmeniz gerekebilir)
       loyalFriendCarePages.getSubmitButton().click();
        
        ReusableMethods.bekle(3);
    }

    @Test
    public void tc02() {
        RegisterMethod.registerNewUser();
    }

    @AfterTest
    public void tearDown() {
        OpenLoyalfriendCare.closeTest();
    }
}

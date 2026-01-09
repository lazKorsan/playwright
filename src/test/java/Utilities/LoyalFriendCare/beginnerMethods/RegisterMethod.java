package Utilities.LoyalFriendCare.beginnerMethods;

import com.microsoft.playwright.Page;
import Utilities.LoyalFriendCare.Pages.LoyalFriendCarePages;
import Utilities.utilities.ReusableMethods;

public class RegisterMethod {
    
    // Bu metodun Page nesnesini döndürmesi iyi olur, böylece test sınıfı kaldığı yerden devam edebilir.
    public static Page registerNewUser(){
        
        Page page = BeforeAfter.openLoyalFriendCarePage();
        
        // Page nesnesini constructor'a veriyoruz
        LoyalFriendCarePages loyalFriendCarePages = new LoyalFriendCarePages(page);

        loyalFriendCarePages.getRegisterButton().click();

        ReusableMethods.bekle(3);
        
        String name = "lazKorsan";
        String fakemail = name + System.currentTimeMillis() + "@gmail.com";
        String fakePassword = "Loyal!" + System.currentTimeMillis();

        // Form doldurma
        loyalFriendCarePages.getNameInput().fill(name);
        loyalFriendCarePages.getEmailInput().fill(fakemail);
        loyalFriendCarePages.getPasswordInput().fill(fakePassword);

        // Şifre tekrarı için TAB kullanımı örneği (US004'teki gibi)
        page.keyboard().press("Tab");
        page.keyboard().type(fakePassword);
        
        // Kayıt ol butonuna tıkla
        loyalFriendCarePages.getSubmitButton().click();
        
        ReusableMethods.bekle(3);
        
        return page;
    }
}

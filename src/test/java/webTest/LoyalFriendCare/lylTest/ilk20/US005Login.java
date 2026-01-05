package webTest.LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import webTest.LoyalFriendCare.Pages.LoyalFriendCarePages;
import webTest.LoyalFriendCare.beginnerMethods.LoginMethod;
import webTest.LoyalFriendCare.beginnerMethods.BeforeAfter;

public class US005Login {

    public static final String mail = "lazKorsan1767391364330@gmail.com";
    public static final String password = "Loyal!1767391364331";


    @Test
    public void tc01(){

        Page page = BeforeAfter.openLoyalFriendCarePage();

        LoyalFriendCarePages loyalFriendCarePages = new LoyalFriendCarePages(page);

        loyalFriendCarePages.getSignInButton().click();

        page.pause();

        loyalFriendCarePages.login(mail, password);

    }

    @Test
    public void tc02(){
        LoginMethod.loginUser();
    }

}

package webTest.LoyalFriendCare.beginnerMethods;

import com.microsoft.playwright.Page;
import webTest.LoyalFriendCare.Pages.LoyalFriendCarePages;

public class LoginMethod {

    public static final String mail = "lazKorsan1767391364330@gmail.com";
    public static final String password = "Loyal!1767391364331";


    public static Page loginUser(){

        Page page = OpenLoyalfriendCare.openLoyalFriendCarePage();

        LoyalFriendCarePages loyalFriendCarePages = new LoyalFriendCarePages(page);

        loyalFriendCarePages.getSignInButton().click();

        loyalFriendCarePages.login(mail, password);

        return page;

    }


}

package Utilities.LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;
import Utilities.LoyalFriendCare.Pages.LoyalFriendCarePages;

import java.awt.*;

import static Utilities.LoyalFriendCare.Pages.LoyalFriendCarePages.mail;
import static Utilities.LoyalFriendCare.Pages.LoyalFriendCarePages.password;

public class US021 {


    @Test
    public void tc01(){

        Playwright playwright = Playwright.create();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        System.out.println("Ekran Boyutu: " + width + "x" + height);

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(150));

        Page page = browser.newPage();

        page.navigate("https://qa.loyalfriendcare.com");

        LoyalFriendCarePages loyalFriendCarePages = new LoyalFriendCarePages(page);

        loyalFriendCarePages.getSignInButton().click();

        loyalFriendCarePages.login(mail, password);








    }



}

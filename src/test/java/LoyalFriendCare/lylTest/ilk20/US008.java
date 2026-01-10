package LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import LoyalFriendCare.beginnerMethods.BeforeAfter;

public class US008 {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        String url = "https://testotomasyonu.com/";
        page.navigate(url);

        System.out.println(page.title());
        System.out.println(page.url());
        BeforeAfter.closeTest();

    }
}

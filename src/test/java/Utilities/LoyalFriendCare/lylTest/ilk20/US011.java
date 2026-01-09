package Utilities.LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class US011 {

    static Playwright playwright;
    static Browser browser;
    static Page page;

    public static void browserOpen(String Url){

        Playwright playwright = Playwright.create();

        playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate(Url);

        System.out.println(page.title());

    }

    public static void testFullClose(){

        page.close();
        browser.close();
        //playwright.close();


    }

    @Test
    public void tc01(){
        browserOpen("https://qa.loyalfriendcare.com/en/login");
        testFullClose();
    }

}

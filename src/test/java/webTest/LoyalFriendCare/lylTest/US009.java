package webTest.LoyalFriendCare.lylTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class US009 {

    public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();

            page.navigate("https://qa.loyalfriendcare.com/en/login");

            System.out.println(page.title());

            page.close();
            browser.close();
            playwright.close();




        }

    }
}

package webTest.utilities;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserUtils {

    static Browser browser ;
    static Page page ;

    public static void browserOpen(String Url){

        Playwright playwright = Playwright.create();

        playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate(Url);

        System.out.println(page.title());

    }

    public static void testClose(){

        page.close();
        browser.close();


    }
}

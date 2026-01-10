package LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import Utilities.utilities.ConfigLoader;


public class US006 {

    public static void main(String[] args) {
       Playwright playwright = Playwright.create();
       Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate(ConfigLoader.getInstance().getLoyalUrl());
        page.pause();
    }

    }


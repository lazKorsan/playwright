package Utilities.LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import Utilities.utilities.ConfigLoader;

public class P01FirstTest {


    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();
            // yukarıdaki satıra kadar olan kısım brwoserı boşta açmak için kullanılıyor

            page.navigate(ConfigLoader.getInstance().getLoyalUrl());

            Thread.sleep(300000);
            
            // Test işlemleriniz...
            
            // browser.close(); // try-with-resources kullandığımız için otomatik kapanabilir veya manuel kapatabilirsiniz.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

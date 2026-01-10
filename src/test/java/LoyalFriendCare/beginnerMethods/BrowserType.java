package LoyalFriendCare.beginnerMethods;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;
import Utilities.utilities.ConfigLoader;

public class BrowserType {

    public static void main(String[] args) {
        // Main metodu da ConfigLoader kullanacak şekilde güncelleyebiliriz veya olduğu gibi bırakabiliriz.
        // Şimdilik tc01'e odaklanıyoruz.
    }

    public static void openBrowser(String url){
        try (Playwright playwright = Playwright.create()) {
            Browser browser;
            String browserName = ConfigLoader.getInstance().getBrowser();

            switch (browserName.toLowerCase()) {
                case "firefox":
                    browser = playwright.firefox().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                    break;
                case "webkit":
                    browser = playwright.webkit().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                    break;
                case "chromium":
                case "chrome":
                default:
                    browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                    break;
            }

            // Viewport (ekran çözünürlüğü) ayarını BrowserContext oluştururken yapıyoruz
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(1920, 1080));

            Page page = context.newPage();
            page.navigate(url);
            System.out.println(page.title());
            
            // Test amaçlı bekleme
            try {
                Thread.sleep(5000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public static void tc01() throws InterruptedException {
        openBrowser("https://qa.loyalfriendcare.com/en");
    }

}

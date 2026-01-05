package webTest.LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.*;

public class US012 {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            
            // Pixel 5 gibi davranan bir tarayıcı context'i oluşturuyoruz
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setUserAgent("Mozilla/5.0 (Linux; Android 11; Pixel 5; Build/RQ3A.211001.001) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Mobile Safari/537.36")
                    .setViewportSize(393, 851)
                    .setDeviceScaleFactor(3)
                    .setIsMobile(true));
            
            // Sayfayı bu mobil context üzerinden açmalıyız
            Page page = context.newPage();

            page.navigate("https://querycart.com/#/home");

            System.out.println("Page Title: " + page.title());
            
            // Görmek için kısa bir bekleme
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

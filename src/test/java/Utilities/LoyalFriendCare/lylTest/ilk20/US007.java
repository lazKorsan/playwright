package Utilities.LoyalFriendCare.lylTest.ilk20;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class US007 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            Page page = browser.newPage();

            // 1. Siteye git
            page.navigate("https://qa.loyalfriendcare.com/en");

            // 2. Giriş yap

            page.locator("xpath=//a[@href='https://qa.loyalfriendcare.com/en/login']").click();
           // page.Locator("xpath=//a[@href='https://qa.loyalfriendcare.com/en/login']").click();
            //page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In")).click();
            page.getByPlaceholder("E-Mail Address").fill("lazKorsan1767391364330@gmail.com");
            page.getByPlaceholder("Password").fill("Loyal!1767391364331");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();

            // 3. Başarılı giriş kontrolü (wait for navigation or specific element)
            page.waitForURL("**/en/account**"); // veya dashboard sayfası
            // Alternatif: Belirli bir elementi kontrol et
            assertThat(page.getByText("Welcome").or(page.getByText("My Account"))).isVisible();

            // 4. Testi ilerlet: Profil sayfasına git
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Account")).click();

            // 5. Adres defterine git
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Address Book")).click();

            // 6. Yeni adres ekle
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("New Address")).click();

            // 7. Adres formunu doldur
            page.getByPlaceholder("First Name").fill("Test");
            page.getByPlaceholder("Last Name").fill("User");
            page.getByPlaceholder("Address 1").fill("123 Test Street");
            page.getByPlaceholder("City").fill("Test City");
            page.getByPlaceholder("Post Code").fill("12345");
            page.selectOption("select[name='country_id']", "223"); // USA
            page.selectOption("select[name='zone_id']", "3623"); // California

            // 8. Adresi kaydet
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();

            // 9. Başarı mesajını kontrol et
            assertThat(page.getByText("Your address has been successfully added")).isVisible();

            // 10. Çıkış yap
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign Out")).click();

            // 11. Çıkış başarılı mı kontrol et
            assertThat(page.getByText("You have been logged off your account")).isVisible();

            System.out.println("Test başarıyla tamamlandı!");

            // Tarayıcıyı kapat (try-with-resources otomatik kapatacak)
        } catch (Exception e) {
            System.err.println("Test sırasında hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
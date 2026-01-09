package Utilities.LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;
import Utilities.utilities.ReusableMethods;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class US061SuccesTag {


    @Test
    public void test01(){
        System.out.println("US059 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome", "https://demoqa.com/checkbox");
        // Ana toggle butonuna tıkla
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Toggle")).click();

        // Tüm checkbox'ları seç
        String[] items = {"home", "desktop", "notes", "commands", "documents", "workspace",
                "react", "angular", "veu", "office", "public", "private",
                "classified", "general", "downloads", "wordFile", "excelFile"};

        for (String item : items) {
            Locator itemLocator = page.locator("//span[contains(text(),'" + item + "')]/preceding-sibling::input[@type='checkbox']");
            if (itemLocator.isVisible()) {
                itemLocator.click();
                ReusableMethods.bekle(100); // 0.1 saniye
            }
        }

        // Sonuçları dinamik olarak al
        ReusableMethods.bekle(2000); // Mesajın oluşması için

        // Tüm success mesajlarını al
        Locator successMessages = page.locator(".text-success");
        int messageCount = successMessages.count();

        System.out.println("\n=== TEST SONUÇLARI ===");
        System.out.println("Toplam seçilen öğe: " + messageCount);

        // Her birini yazdır
        for (int i = 0; i < messageCount; i++) {
            System.out.println("  " + (i+1) + ". " + successMessages.nth(i).textContent());
        }

        // Birleştirilmiş mesaj
        StringBuilder combined = new StringBuilder();
        for (int i = 0; i < messageCount; i++) {
            combined.append(successMessages.nth(i).textContent());
            if (i < messageCount - 1) combined.append(", ");
        }

        System.out.println("\nBirleştirilmiş: " + combined.toString());

        // Doğrulama
        Locator resultText = page.locator("#result");
        System.out.println("Tam mesaj: " + resultText.textContent());
        assertThat(resultText).containsText("You have selected");
    }

}

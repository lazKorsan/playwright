package Stepdefinitons;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.Given;
import webTest.utilities.DimensonsUtils;
import webTest.utilities.ReusableMethods;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SuccesSteps {

    @Given("success mesaage")
    public void successMesaage() {

        Page page = DimensonsUtils.setUpFullScreen("chrome", "https://demoqa.com/checkbox");

        Locator menuOpenButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Toggle"));
        ReusableMethods.verify(() -> assertThat(menuOpenButton).isVisible());
        ReusableMethods.verify(() -> assertThat(menuOpenButton).isEnabled());
        menuOpenButton.click();

        Locator homeText = page.locator("//*[@id=\"tree-node\"]/ol/li/span/label/span[3]");
        ReusableMethods.verify(() -> assertThat(homeText).isVisible());
        ReusableMethods.verify(() -> assertThat(homeText).isEnabled());
        System.out.println(homeText.textContent());
        homeText.click();


        Locator desktopText = page.locator("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[3]");
        ReusableMethods.verify(() -> assertThat(desktopText).isVisible());
        ReusableMethods.verify(() -> assertThat(desktopText).isEnabled());
        System.out.println(desktopText.textContent());
        desktopText.click();
        ReusableMethods.bekle((int) 0.3);
        desktopText.click();

        Locator documentText = page.locator("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[3]");
        ReusableMethods.verify(() -> assertThat(documentText).isVisible());
        ReusableMethods.verify(() -> assertThat(documentText).isEnabled());
        System.out.println(documentText.textContent());
        documentText.click();
        ReusableMethods.bekle((int) 0.3);
        documentText.click();

        Locator downloadsText = page.locator("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[3]");
        ReusableMethods.verify(() -> assertThat(downloadsText).isVisible());
        ReusableMethods.verify(() -> assertThat(downloadsText).isEnabled());
        System.out.println(downloadsText.textContent());
        downloadsText.click();
        ReusableMethods.bekle((int) 0.3);
        downloadsText.click();

        Locator startOfSuccesMassegeText = page.locator("//*[@id=\"result\"]/span[1]");
        String startMessage = startOfSuccesMassegeText.innerText();

        System.out.println(startOfSuccesMassegeText.innerText());

        // Dinamik olarak tüm success mesajlarını al
        Locator successMessages = page.locator("//span[@class='text-success']");
        int messageCount = successMessages.count();

        System.out.println("=== SEÇİLEN ÖĞELER ===");
        System.out.println("Toplam seçim: " + messageCount + " adet");

        // Her bir mesajı yazdır
        for (int i = 0; i < messageCount; i++) {
            String message = successMessages.nth(i).textContent();
            System.out.println((i + 1) + ". öğe: " + message);
        }

        // Tüm mesajları tek string'de birleştir
        StringBuilder combinedMessage = new StringBuilder();
        for (int i = 0; i < messageCount; i++) {
            combinedMessage.append(successMessages.nth(i).textContent());
            if (i < messageCount - 1) {
                combinedMessage.append(" ");
            }
        }

        System.out.println("Birleşik mesaj: " + combinedMessage.toString());

        // Doğrulama için
        Locator resultElement = page.locator("#result");
        String fullResult = resultElement.textContent();
        System.out.println("Tam mesaj: " + fullResult);

        // Mesajın doğru olup olmadığını kontrol et
        assertThat(resultElement).containsText("You have selected");

        // Birleşik mesaj: home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile
        //Tam mesaj: You have selected :homedesktopnotescommandsdocumentsworkspacereactangularveuofficepublicprivateclassifiedgeneraldownloadswordFileexcelFile

        System.out.println(startMessage+" "+combinedMessage.toString());

    }
}

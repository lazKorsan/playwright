package Stepdefinitons;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import LoyalFriendCare.lylTest.ikinci20.US040Method;
import Utilities.utilities.DimensonsUtils;

import java.text.ParseException;

public class formDoldurmaSteps {

    // Page nesnesini sınıf seviyesinde tutuyoruz ki adımlar arasında paylaşabilelim
    static Page page;

    @Given("Kullanici {string} sayfasina giderR")
    public void kullaniciSayfasinaGiderR(String url) {
        // Sayfayı başlatıp sınıf seviyesindeki değişkene atıyoruz
        page = DimensonsUtils.setUpFullScreen("chrome", url);
    }

    @Then("Kullanici formu doldurur")
    public void kullaniciFormuDoldurur() throws ParseException {
        // Başlatılmış olan page nesnesini metoda gönderiyoruz
        if (page != null) {
            US040Method.formDoldurma(page);
        } else {
            throw new RuntimeException("Page nesnesi başlatılamadı! Lütfen önce 'Given' adımını çalıştırın.");
        }
    }


}

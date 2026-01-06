package webTest.LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;
import webTest.utilities.DimensonsUtils;
import webTest.utilities.ReusableMethods;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class US039 {

    @Test
    public void test01() throws ParseException {
        System.out.println("US039 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome", "https://testautomationpractice.blogspot.com/");

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Name")).fill("lazKorsan");

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter EMail")).click();

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter EMail")).fill("lazkorsan@gmail.com");

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Phone")).click();

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Phone")).fill("0532532323");

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address:")).click();

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address:")).fill("türkey");

        Locator maleRadioButton = page.locator("//input[@id='male']");

        ReusableMethods.scrollToElementCenter(page, maleRadioButton);

        maleRadioButton.click();

        page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Sunday")).check();

        page.getByLabel("Country:").selectOption("brazil");

        page.getByLabel("Colors:").selectOption("blue");

        page.locator("div").filter(new Locator.FilterOptions().setHasText("GUI Elements Form Elements")).nth(5).click();

        page.getByLabel("Colors:").selectOption("red");

        page.getByLabel("Sorted List:").selectOption("giraffe");

        // 1. Tarihi MM/dd/yyyy formatında oluşturma (Datepicker için)
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date();
        String todayStr = dateFormat.format(today);
        System.out.println("Bugünün Tarihi (MM/dd/yyyy): " + todayStr);

        // 2. 3 gün sonrasının tarihini hesaplama
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 3); // 3 gün ekle
        Date threeDaysLater = calendar.getTime();
        String threeDaysLaterStr = dateFormat.format(threeDaysLater);
        
        // Sadece gün bilgisini al (Örn: "25") - Takvimden seçim yapmak için
        String dayOfMonth = new SimpleDateFormat("d").format(threeDaysLater);
        
        System.out.println("3 Gün Sonrası (MM/dd/yyyy): " + threeDaysLaterStr);
        System.out.println("Seçilecek Gün: " + dayOfMonth);

        // 3. HTML5 Date Input formatı (yyyy-MM-dd)
        DateFormat html5Format = new SimpleDateFormat("yyyy-MM-dd");
        String todayHtml5 = html5Format.format(today);
        String threeDaysLaterHtml5 = html5Format.format(threeDaysLater);
        System.out.println("Bugünün Tarihi (yyyy-MM-dd): " + todayHtml5);
        System.out.println("3 Gün Sonrası (yyyy-MM-dd): " + threeDaysLaterHtml5);

        // --- Datepicker Alanı ---
        page.locator("#datepicker").fill(todayStr);
        page.locator("#datepicker").press("Enter");

        // --- txtDate Alanı ---
        // Bu alan manuel girişe izin vermiyorsa (readonly ise), takvimden seçtirmemiz gerekir.
        // 1. Inputa tıkla (Takvimi aç)
        page.locator("#txtDate").click();
        
        // 2. Takvim açıldığında, hedef günü bul ve tıkla.
        // Genellikle takvimdeki günler <a> veya <td> etiketi içindedir ve text içeriği gün sayısını verir.
        // Playwright'ın getByRole veya getByText metotlarını kullanarak günü seçebiliriz.
        // Not: Eğer 3 gün sonrası bir sonraki aya denk geliyorsa, "Next" butonuna basmak gerekebilir.
        // Basit senaryo (aynı ay içinde) için:
        
        // Takvimdeki günü seç (Örn: "25" yazan linke tıkla)
        // ui-datepicker-calendar sınıfı genellikle jQuery UI datepicker'larda kullanılır.
        // Sadece görünür olan ve tam eşleşen günü seçmeye çalışıyoruz.
        page.locator(".ui-datepicker-calendar a").filter(new Locator.FilterOptions().setHasText(dayOfMonth)).first().click();
        
        // --- Start Date ve End Date Alanları ---
        page.getByPlaceholder("Start Date").fill(todayHtml5);
        page.getByPlaceholder("End Date").fill(threeDaysLaterHtml5);

        // Submit butonu
        page.locator("#post-body-1307673142697428135").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Submit")).click();
        
        // --- SONUÇLARI ALMA ---
        // Submit sonrası oluşan sonucu veya inputlardaki değerleri almak için:
        
        System.out.println("--- Test Sonuçları ---");
        
        // 1. Input alanlarındaki son değerleri okuma (.inputValue() metodu ile)
        String finalStartDate = page.getByPlaceholder("Start Date").inputValue();
        String finalEndDate = page.getByPlaceholder("End Date").inputValue();
        
        System.out.println("Girilen Başlangıç Tarihi: " + finalStartDate);
        System.out.println("Girilen Bitiş Tarihi: " + finalEndDate);
        
        Locator resultText = page.locator("(//div[@id='result'])");

        System.out.println("Sonuç: " + resultText.innerText());




    }

}

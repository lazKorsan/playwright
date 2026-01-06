package webTest.LoyalFriendCare.lylTest.ikinci20;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import webTest.utilities.DimensonsUtils;
import webTest.utilities.ReusableMethods;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class US036 {

    @Test
    public void test01() throws ParseException {
        System.out.println("US036 Test 01 Çalıştı");

        Page page= DimensonsUtils.setUpFullScreen("chrome","https://testautomationpractice.blogspot.com/");

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Name")).fill("lazKorsan");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter EMail")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter EMail")).fill("lazkorsan@gmail.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Phone")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Phone")).fill("0532532323");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address:")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address:")).fill("türkey");

        //<!-- Ok


       Locator maleRadioButton = page.locator("//input[@id='male']");

       ReusableMethods.scrollToElementCenter(page,maleRadioButton);

       maleRadioButton.click();

       //<!-- ok




        page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Sunday")).check();
        page.getByLabel("Country:").selectOption("brazil");
        page.getByLabel("Colors:").selectOption("blue");
        page.locator("div").filter(new Locator.FilterOptions().setHasText("GUI Elements Form Elements")).nth(5).click();
        page.getByLabel("Colors:").selectOption("red");
        page.getByLabel("Sorted List:").selectOption("giraffe");

        //<!-- ok

        // 1. Tarihi MM/dd/yyyy formatında oluşturma
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date();
        String todayStr = dateFormat.format(today);
        System.out.println("Bugünün Tarihi: " + todayStr);

        // 2. 3 gün sonrasının tarihini hesaplama
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 3); // 3 gün ekle
        Date threeDaysLater = calendar.getTime();
        String threeDaysLaterStr = dateFormat.format(threeDaysLater);
        System.out.println("3 Gün Sonrası: " + threeDaysLaterStr);

        // Tarihleri ilgili alanlara girme
        // Not: Datepicker genellikle manuel giriş yerine takvimden seçimi zorlayabilir,
        // ancak input alanı açıksa .fill() çalışır. Çalışmazsa .type() veya JS ile value atamak gerekebilir.
        
        // Örnek: Datepicker alanına bugünün tarihini girme
        page.locator("#datepicker").fill(todayStr);
        // Datepicker genellikle enter tuşuna basılmasını bekleyebilir
        page.locator("#datepicker").press("Enter");

        page.locator("#txtDate").click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("9").setExact(true)).click();
        page.locator("#post-body-1307673142697428135").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Submit")).click();

        // Örnek: Başka bir alana (örneğin txtDate) 3 gün sonrasını girme
        // (Burada örnek olarak txtDate kullanıldı, sayfanızdaki doğru locator'ı kullanmalısınız)
        // page.locator("#txtDate").fill(threeDaysLaterStr); 
        
        // Sizin kodunuzdaki mevcut tarih seçimi işlemleri (bunları yorum satırına alıyorum, yukarıdaki dinamik kod çalışsın diye)
        /*
        page.locator("#datepicker").dblclick();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("14")).click();
        page.locator("#txtDate").click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("22")).click();
        */
        
        // Start Date ve End Date alanlarına dinamik tarihleri girelim
        // Start Date: Bugün
        // End Date: 3 gün sonra
        // Formatın input alanının beklediği formatla (örn: yyyy-MM-dd veya MM/dd/yyyy) uyumlu olması önemlidir.
        // Genellikle HTML5 date inputları yyyy-MM-dd bekler.
        
        DateFormat html5Format = new SimpleDateFormat("yyyy-MM-dd");
        String todayHtml5 = html5Format.format(today);
        String threeDaysLaterHtml5 = html5Format.format(threeDaysLater);

        page.getByPlaceholder("Start Date").fill(todayHtml5);
        page.getByPlaceholder("End Date").fill(threeDaysLaterHtml5);

        page.locator("#post-body-1307673142697428135").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Submit")).click();

       // Locator targetElement = page.locator("//*[@id=\"country\"]");

        //ReusableMethods.scrollToElementCenter(page, targetElement);

        //page.selectOption("//*[@id=\"country\"]","japan");

        page.pause();

       // ReusableMethods.bekle(12);


    }

    @AfterMethod
    public void tearDown(){
        webTest.utilities.DimensonsUtils.tearDown();
    }

    // https://testautomationpractice.blogspot.com/
}

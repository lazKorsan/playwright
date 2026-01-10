package LoyalFriendCare.lylTest.ucuncu20;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;
import Utilities.utilities.DimensonsUtils;

public class US056Iframe {

    // https://demoqa.com/browser-windows

    @Test
    public void test01(){
        System.out.println("US056 Test 01 Çalıştı");

        Page page = DimensonsUtils.setUpFullScreen("chrome","https://demoqa.com/browser-windows");


        // abi merhaba burada bu testin ilerlemesi için yeteri kadar bilgi var mı
        // todo dan sonra playwright kendisi verdi ama testte işlemiyor
        // her test sonrasında araya 4 saniye bekleme koyarak
        // newTabButton  //button[@id='tabButton']  buna basılınca açılan pencerede yazının  xpath //h1[@id='sampleHeading']
        // yazıyı consola yazdırıp daha sonra ilk pencereye geçmek istiyorum belkide ikinci pencere kapatılabilri
        // sonrasında
        // newWindowButton  //div[@id='windowButtonWrapper']  buna basılınca yeni window açılıyor
        // açılan yeni windowdaki  yazı elementinin  xpath değeri //h1[@id='sampleHeading']
        // yazıyı ve url consola yazdırmak istiyorum . daha sonra tekrar anapencereye dönmek istiyorum

        // daha sonra newWindowMassegeButton  //button[@id='messageWindowButton']  buna basılınca poUp tatrzı mesaj çıkıyor
        // popup menude elementi locate edebliecek her hangi bir oge sanki yok gibi
        // yazı  "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."
        // <html>
        // <body>
        // <p>Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.</p>
        // </body>
        // </html>

        // gbi bir yapı var .



        // todo

        Page page1 = page.waitForPopup(() -> {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("New Tab")).click();
        });
        // "new tab click" basınca açılan sayfada url ve  "This is a sample page" yazısını consola yazdırmak istiyorum
        page1.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("This is a sample page")).click();

        // daha sonra popup menu içindeki yazıyı almka istiyorum .
        Page page2 = page.waitForPopup(() -> {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("New Window").setExact(true)).click();
        });
        page2.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("This is a sample page")).click();
        Page page3 = page.waitForPopup(() -> {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("New Window Message")).click();
        });
        page3.getByText("Knowledge increases by").click();
    }



    }


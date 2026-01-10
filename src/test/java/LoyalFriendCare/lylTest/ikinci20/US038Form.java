package LoyalFriendCare.lylTest.ikinci20;

import Utilities.BrowserUtils;
import Utilities.ReusableMethods;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class US038Form {


    @Test
    public void test01() throws ParseException {
        System.out.println("US038 Test 01 Çalıştı");

        Page page = BrowserUtils.setUpFullScreen("chrome", "https://testautomationpractice.blogspot.com/");
        //Page page = DimensonsUtils.setUpFullScreen("chrome", "https://testautomationpractice.blogspot.com/");

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Name")).fill("lazKorsan");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter EMail")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter EMail")).fill("lazkorsan@gmail.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Phone")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Phone")).fill("0532532323");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address:")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address:")).fill("türkey");

        //<!-- Ok


        Locator maleRadioButton = page.locator("//input[@id='male']");

        ReusableMethods.scrollToElementCenter(page, maleRadioButton);
        //ReusableMethods.scrollToElementCenter(page, maleRadioButton);

        maleRadioButton.click();

        //<!-- ok


        page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Sunday")).check();
        page.getByLabel("Country:").selectOption("brazil");
        page.getByLabel("Colors:").selectOption("blue");
        page.locator("div").filter(new Locator.FilterOptions().setHasText("GUI Elements Form Elements")).nth(5).click();
        page.getByLabel("Colors:").selectOption("red");
        page.getByLabel("Sorted List:").selectOption("giraffe");

        //<!-- ok

        //<!-- todo  1. Tarihi MM/dd/yyyy formatında oluşturma
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date();
        String todayStr = dateFormat.format(today);
        System.out.println("Bugünün Tarihi: " + todayStr);

        //<!-- todo 2. 3 gün sonrasının tarihini hesaplama
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 3); // 3 gün ekle
        Date threeDaysLater = calendar.getTime();
        String threeDaysLaterStr = dateFormat.format(threeDaysLater);
        System.out.println("3 Gün Sonrası: " + threeDaysLaterStr);


        Locator datapicker1 = page.locator("//input[@id='datepicker']");
        Locator datapicker2 = page.locator("//input[@id='txtDate']");
        datapicker1.fill(todayStr);
        datapicker1.press("Enter");

        page.locator("#txtDate").click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("9").setExact(true)).click();

        //datapicker2.click();
        //datapicker2.selectOption("09");
        //Utilities.ReusableMethods.bekle(12);

        page.pause();













    }

}

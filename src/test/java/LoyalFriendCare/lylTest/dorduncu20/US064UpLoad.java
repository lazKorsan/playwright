package LoyalFriendCare.lylTest.dorduncu20;

import Utilities.BrowserUtils;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class US064UpLoad {

    @Test
    public void test01(){
        System.out.println("US064 Test 01 Çalıştı");

        Page page = BrowserUtils.setUpFullScreen("chrome", "https://the-internet.herokuapp.com/upload");

        Locator chooseFilesButton = page.locator("//input[@id='file-upload']");

        String filePath = "C:\\Users\\user\\Desktop\\UpLoadications.jpeg";
        chooseFilesButton.setInputFiles(Paths.get(filePath));

        Locator upLoadButton = page.locator("//input[@id='file-submit']");
        upLoadButton.click();

        Locator upLoadFiesMessageContainer = page.locator("//*[@id='uploaded-files']");

        String expectedFilesName = "UpLoadications.jpeg";

        String actualFilesName = upLoadFiesMessageContainer.textContent();

        System.out.println("Actual uploaded file: " + actualFilesName);


        if (actualFilesName.contains(expectedFilesName)) {
            System.out.println("Test Başarılı - Dosya adı içeriyor");
        } else {
            System.out.println("Test Başarısız - Dosya adı içermiyor");
        }


    }

}

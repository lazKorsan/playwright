package Stepdefinitons;

import io.cucumber.java.en.*;
import Utilities.LoyalFriendCare.beginnerMethods.BeforeAfter;
import Utilities.utilities.BrowserUtils;

public class MyStepdefs {


    @Given("Kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String url) {
        BrowserUtils.browserOpen(url);
    }

    @When("user close to testifiying")
    public void user_close_to_testifiying() {

        BeforeAfter.closeTest();

    }



}

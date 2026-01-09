package Utilities.LoyalFriendCare.lylTest.ilk20;

import org.testng.annotations.Test;
import Utilities.LoyalFriendCare.beginnerMethods.BeforeAfter;

public class US001 {

    @Test
    public void tc01(){
        BeforeAfter.openLoyalFriendCarePage();
        BeforeAfter.closeTest();
    }
}

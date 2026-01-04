package webTest.LoyalFriendCare.lylTest;

import org.testng.annotations.Test;
import webTest.LoyalFriendCare.beginnerMethods.BeforeAfter;

public class US001 {

    @Test
    public void tc01(){
        BeforeAfter.openLoyalFriendCarePage();
        BeforeAfter.closeTest();
    }
}

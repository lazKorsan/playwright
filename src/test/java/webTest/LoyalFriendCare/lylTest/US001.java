package webTest.LoyalFriendCare.lylTest;

import org.testng.annotations.Test;
import webTest.LoyalFriendCare.beginnerMethods.OpenLoyalfriendCare;

public class US001 {

    @Test
    public void tc01(){
        OpenLoyalfriendCare.openLoyalFriendCarePage();
        OpenLoyalfriendCare.closeTest();
    }
}

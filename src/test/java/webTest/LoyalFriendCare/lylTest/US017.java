package webTest.LoyalFriendCare.lylTest;

import org.testng.annotations.Test;
import webTest.LoyalFriendCare.beginnerMethods.PlaywrightScreenSizeUtils;
import webTest.utilities.ReusableMethods;

public class US017 {
    @Test
    public void tc01(){
        PlaywrightScreenSizeUtils.setMaximeze();
        ReusableMethods.bekle(7);
    }
}

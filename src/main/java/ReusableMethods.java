import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    // ReusableMethods.java'ya ekleyin:
    public static String getAllTexts(Page page, String selector) {
        Locator elements = page.locator(selector);
        int count = elements.count();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(elements.nth(i).textContent().trim());
            if (i < count - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static List<String> getAllTextsAsList(Page page, String selector) {
        Locator elements = page.locator(selector);
        int count = elements.count();
        List<String> texts = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            texts.add(elements.nth(i).textContent().trim());
        }
        return texts;
    }
}

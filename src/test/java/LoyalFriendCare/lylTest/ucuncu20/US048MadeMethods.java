package LoyalFriendCare.lylTest.ucuncu20;

import org.testng.annotations.Test;

public class US048MadeMethods {


    @Test
    public void test01() {
        System.out.println("US048 Test 01 Çalıştı");
        // Bu test metodu, US040Method sınıfındaki formDoldurma metodunu çağırabilir.
        // Ancak US040Method, Page nesnesini parametre olarak beklediği için
        // burada bir Page nesnesi oluşturulması veya BaseTest'ten alınması gerekir.
        // Örnek olarak, DimensonsUtils kullanarak bir Page nesnesi oluşturabiliriz:
        // Page page = DimensonsUtils.setUpFullScreen("chrome", "https://testautomationpractice.blogspot.com/");
        // try {
        //     US040Method.formDoldurma(page);
        // } catch (ParseException e) {
        //     e.printStackTrace();
        // } finally {
        //     if (page != null) {
        //         page.close();
        //     }
        // }
        System.out.println("US048 Test 01 Tamamlandı");

        pageMethod();


    }

    private void pageMethod() {
    }
}

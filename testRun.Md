# Playwright – Belirli Test Classlarını Çalıştırma

Bu dosya, aşağıdaki iki test class’ını çalıştırmak için örnek komutu içerir:

- TestUS023.java
- TestUS024.java

## Test Class Yolları

- C:\Users\user\IdeaProjects\playwright96\src\test\java\webTest\LoyalFriendCare\lylTest\ikinci20\TestUS023.java
- C:\Users\user\IdeaProjects\playwright96\src\test\java\webTest\LoyalFriendCare\lylTest\ikinci20\TestUS024.java

## Maven ile Çalıştırma

Dosya isimlerini `Test` ile başlayacak şekilde güncellediğiniz için (TestUS023, TestUS024), Maven bunları artık otomatik olarak tanıyacaktır.

Aşağıdaki komutu terminalde çalıştırarak bu iki testi koşturabilirsiniz:

```bash
mvn test -Dtest=TestUS023,TestUS024
```

Eğer tek tek çalıştırmak isterseniz:

```bash
mvn test -Dtest=TestUS023
```

```bash
mvn test -Dtest=TestUS024
```


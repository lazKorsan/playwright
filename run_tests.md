# Test Çalıştırma Rehberi

Bu dosya, projedeki belirli testleri Maven komut satırı üzerinden nasıl çalıştıracağınızı açıklar.

## Hedef Testler
Aşağıdaki test sınıfları çalıştırılacaktır:
1. **TestUS023** (C:\Users\user\IdeaProjects\playwright96\src\test\java\webTest\LoyalFriendCare\lylTest\ikinci20\TestUS023.java)
2. **TestUS024** (C:\Users\user\IdeaProjects\playwright96\src\test\java\webTest\LoyalFriendCare\lylTest\ikinci20\TestUS024.java)

---

## Nasıl Çalıştırılır?

Terminali açın ve proje kök dizininde (C:\Users\user\IdeaProjects\playwright96) olduğunuzdan emin olun.

### 1. İki Testi Birlikte Çalıştırma
Her iki testi sırasıyla çalıştırmak için:

```bash
mvn test -Dtest=TestUS023,TestUS024
```

### 2. Sadece TestUS023'ü Çalıştırma

```bash
mvn test -Dtest=TestUS023
```

### 3. Sadece TestUS024'ü Çalıştırma

```bash
mvn test -Dtest=TestUS024
```

---

## Notlar
* Testleriniz `Test` ön ekiyle başladığı için (TestUS023, TestUS024), Maven bunları otomatik olarak algılar.
* Eğer testler çalışmazsa, önce projeyi temizleyip derlemeyi deneyin:
  ```bash
  mvn clean compile
  ```

```bash
mvn test -Dtest=TestUS024
```

  

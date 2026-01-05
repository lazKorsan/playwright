/*
const { test, expect } = require('@playwright/test');
const { _android } = require('playwright');

// Playwright Test ile Android cihazda gerçek Chrome testi
test.describe('Pixel 7 Pro - Gerçek Android Chrome Testi', () => {
  let device;
  let context;
  let page;

  // Test öncesi: Android emülatörü bağla ve Chrome'u başlat
  test.beforeAll(async () => {
    // Bağlı olan Android cihaz/emülatörleri listeler (Pixel 7 Pro çalışır durumda olmalı)
    const devices = await _android.devices();

    // İlk bağlı cihazı al (genelde tek emulator olur)
    // Eğer birden fazla cihaz varsa, model adına göre filtreleyebilirsin
    device = devices.find(d => d.model().includes('Pixel 7 Pro')) || devices[0];

    if (!device) {
      throw new Error('Bağlı bir Android emülatörü bulunamadı. Lütfen Pixel 7 Pro emülatörünü başlatın.');
    }

    console.log(`Bağlanan cihaz: ${device.model()} (Serial: ${device.serial()})`);

    // Eski Chrome süreçlerini temizle (daha stabil başlar)
    await device.shell('am force-stop com.android.chrome');

    // Gerçek Chrome tarayıcısını başlat (paket: com.android.chrome)
    context = await device.launchBrowser({
      // İsteğe bağlı: Başlatma argümanları
      // args: ['--no-sandbox'],
    });

    // Yeni bir sayfa aç
    page = await context.newPage();
  });

  // Test sonrası: Temizle
  test.afterAll(async () => {
    if (context) await context.close();
    if (device) await device.close();
  });

  test('Google ana sayfası açılmalı ve başlık doğru olmalı', async () => {
    // Google'a git
    await page.goto('https://www.google.com', {
      waitUntil: 'domcontentloaded', // Daha hızlı
    });

    // Başlığı kontrol et
    await expect(page).toHaveTitle(/Google/);

    // Arama kutusunun göründüğünü doğrula
    const searchInput = page.locator('textarea[name="q"], input[name="q"]');
    await expect(searchInput).toBeVisible();

    // Ekran görüntüsü al (test raporuna eklenir)
    await page.screenshot({
      path: 'screenshots/google-pixel7pro.png',
      fullPage: true,
    });

    console.log('Google.com başarıyla açıldı ve ekran görüntüsü alındı.');
  });

  // İstersen ek testler ekleyebilirsin
  test('Arama yap ve sonuçları kontrol et', async () => {
    await page.goto('https://www.google.com');

    const searchInput = page.locator('textarea[name="q"]');
    await searchInput.fill('Playwright Android');
    await searchInput.press('Enter');

    // Sonuçların yüklenmesini bekle
    await page.waitForSelector('h3'); // Google sonuç başlıkları

    // İlk sonuçta "Playwright" kelimesi geçiyor mu?
    const firstResult = page.locator('h3').first();
    await expect(firstResult).toContainText('Playwright', { ignoreCase: true });

    await page.screenshot({
      path: 'screenshots/search-results-pixel7pro.png',
    });
  });
});
 */

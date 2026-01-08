



describe('Google Ana Sayfa Testi', () => {
  it('Google sayfasını açmalı ve başlığı kontrol etmeli', () => {
    // Google'a git
    cy.visit('https://www.google.com');

    // Sayfa başlığının 'Google' içerdiğini doğrula
    cy.title().should('include', 'Google');

    // Arama kutusunun görünür olduğunu doğrula
    // Google'ın arama input'u genellikle 'textarea[name="q"]' veya 'input[name="q"]' şeklindedir
    cy.get('[name="q"]').should('be.visible');
  });
});

// npx cypress open

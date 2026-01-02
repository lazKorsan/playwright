package webTest.LoyalFriendCare.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoyalFriendCarePages {
    private final Page page;

    // --- Locators ---
    private final String loginLink = "text=Log in"; 
    private final String emailInput = "input[name='email']"; 
    private final String passwordInput = "input[name='password']";
    private final String loginButton = "button:has-text('Log in')";
    
    // Registration Form Locators
    private final String nameInput = "input[name='name']"; 
    private final String registerSubmitButton = "button:has-text('Register')"; 
    
    // Doctors butonu için güncellenmiş XPath
    private final String doctorsLink = "xpath=//*[@id='menu']/ul/li[4]/span/a";

    private final String signInButton = "xpath=//a[@href='https://qa.loyalfriendcare.com/en/login']";
    private final String registerButton = "xpath=//a[@href='https://qa.loyalfriendcare.com/en/register']";
    private final String submitButton ="xpath=//button[@class='btn btn-primary btn-cons m-t-10']";
    private final String signInButton2="xpath=//button[@class='btn btn-primary btn-cons m-t-10']";


    // --- Constructor ---
    public LoyalFriendCarePages(Page page) {
        this.page = page;
    }

    // --- Helper Methods for Assertions and Logging ---
    // Kod tekrarını önlemek için kontrol mantığını bu metodlarda topladım.
    
    private Locator returnButtonWithChecks(String selector, String elementName) {
        Locator locator = page.locator(selector);
        
        // Konsola durumunu yazdırıyoruz
        System.out.println(elementName + " Görünür mü? : " + locator.isVisible());
        System.out.println(elementName + " Tıklanabilir mi? : " + locator.isEnabled());

        // Playwright Assertion'ları ile doğrulama
        assertThat(locator).isVisible();
        assertThat(locator).isEnabled();
        
        return locator;
    }

    private Locator returnInputWithChecks(String selector, String elementName) {
        Locator locator = page.locator(selector);
        
        // Konsola durumunu yazdırıyoruz
        System.out.println(elementName + " Görünür mü? : " + locator.isVisible());
        System.out.println(elementName + " Tıklanabilir mi? : " + locator.isEnabled());
        System.out.println(elementName + " Düzenlenebilir mi? : " + locator.isEditable());

        // Playwright Assertion'ları ile doğrulama
        assertThat(locator).isVisible();
        assertThat(locator).isEnabled();
        assertThat(locator).isEditable();
        
        return locator;
    }

    // --- Getter Methods ---

    public Locator getSubmitButton() {
        return returnButtonWithChecks(submitButton, "Submit Button");
    }

    public Locator getLoginLink() {
        return returnButtonWithChecks(loginLink, "Login Link");
    }

    public Locator getEmailInput() {
        return returnInputWithChecks(emailInput, "Email Input");
    }

    public Locator getPasswordInput() {
        return returnInputWithChecks(passwordInput, "Password Input");
    }

    public Locator getLoginButton() {
        return returnButtonWithChecks(loginButton, "Login Button");
    }

    public Locator getDoctorsLink() {
        return returnButtonWithChecks(doctorsLink, "Doctors Link");
    }

    public Locator getSignInButton(){
        return returnButtonWithChecks(signInButton, "Sign In Button");
    }
    
    public Locator getNameInput() {
        return returnInputWithChecks(nameInput, "Name Input");
    }
    
    public Locator getRegisterSubmitButton() {
        return returnButtonWithChecks(registerSubmitButton, "Register Submit Button");
    }

    public Locator getRegisterButton(){
        return returnButtonWithChecks(registerButton, "Register Button");
    }

    // --- Action Methods ---
    public void clickLogin() {
        getLoginLink().click();
    }
    
    public void clickDoctors() {
        getDoctorsLink().click();
    }

    public void login(String email, String password) {
        getEmailInput().fill(email);
        getPasswordInput().fill(password);
        getSubmitButton().click();
    }
    
    public void register(String name, String email, String password) {
        getNameInput().fill(name);
        getEmailInput().fill(email);
        getPasswordInput().fill(password);
        getRegisterSubmitButton().click();
    }
}

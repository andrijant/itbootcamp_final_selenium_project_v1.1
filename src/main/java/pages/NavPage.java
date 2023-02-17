package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {

    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //  Home link
    public WebElement getHomeLink() {
        return driver.findElement(
                By.xpath("//div[@class='v-toolbar__items']/a[1]"));
    }

    //  About link
    public WebElement getAboutLink() {
        return driver.findElement(By.cssSelector(".btnProfile"));
    }

    //  My profile link
    public WebElement getMyProfileLink() {
        return driver.findElement(By.cssSelector(".btnProfile"));
    }

    //  Login link
    public WebElement getLoginLink() {
        return driver.findElement(By.xpath("//*[contains(@class,'btnLogin')][1]"));
    }

    //  Admin button
    public WebElement getAdminButton() {
        return driver.findElement(By.cssSelector(".btnAdmin"));
    }

    //  Cities link -> Admin
    public WebElement getAdminCitiesLink() {
        return driver.findElement(By.cssSelector(".btnAdminCities"));
    }

    //  Users link -> Admin
    public WebElement getAdminUsersLink() {
        return driver.findElement(By.cssSelector(".btnAdminUsers"));
    }

    //  Sign up link
    public WebElement getSignUpLink() {
        return driver.findElement(By.xpath("//a[contains(@class,'btnLogin')][2]"));
    }

    //  Login button
    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

    //  Logout button
    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector(".btnLogout"));
    }

    //  Language button
    public WebElement getLanguageButton() {
        return driver.findElement(By.cssSelector(".btnLocaleActivation"));
    }

    //  EN language button
    public WebElement getEnLanguageButton() {
        return driver.findElement(By.cssSelector(".btnEN"));
    }

    //  ES language button
    public WebElement getEsLanguageButton() {
        return driver.findElement(By.cssSelector(".btnES"));
    }

    //  FR language button
    public WebElement getFrLanguageButton() {
        return driver.findElement(By.cssSelector(".btnFR"));
    }

    //  CN language button
    public WebElement getCnLanguageButton() {
        return driver.findElement(By.cssSelector(".btnCN"));
    }

    //  UA language button
    public WebElement getUaLanguageButton() {
        return driver.findElement(By.cssSelector(".btnUA"));
    }

    //  Current page URL
    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    //  Navigate to page
    public void navigateToPage(String baseUrl, String url) {
        driver.navigate().to(baseUrl + url);
    }

    //  Get header text
    public String headerText() {
        return driver.findElement(By.cssSelector("h1")).getText();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLoginLink(){
        return driver.findElement(By.xpath("//*[contains(@class,'btnLogin')][1]"));
    }
    public WebElement getEmailInputField(){
        return driver.findElement(By.cssSelector("#email"));
    }

    public WebElement getPasswordInputField(){
        return driver.findElement(By.cssSelector("#password"));
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

    public void waitForErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error")));
    }

    public String getErrorMessage(){
        return  driver.findElement(By.cssSelector(".error li")).getText();
    }

    public WebElement logoutButton(){
        return driver.findElement(By.cssSelector(".btnLogout "));
    }

    public void waitLogoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnLogout ")));
    }
}

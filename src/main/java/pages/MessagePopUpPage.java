package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


//  Visibility of pop up message
    public void waitForErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error")));
    }
//  Error message text
    public String getErrorMessage(){
        return  driver.findElement(By.cssSelector(".error li")).getText();
    }
//  Close button
    public WebElement getCloseButton(){
        return driver.findElement(By.cssSelector(".btnLogout "));
    }
//  Visibility of Logout button
    public void waitForLogoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnLogout ")));
    }

}

//●	metodu koja ceka da pop up bude vidljiv
//●	Elemente koji u sebi sadrze tekstove poruke
//●	Close dugme
//
//●	metodu koja ceka da se verify your account dijalog pojavi
//●	metodu koja vraca zaglavlje iz verify your account
// dijaloga koji sadrzi tekst IMPORTANT: Verify your account
//
//●	Close dugme iz verify account dijaloga
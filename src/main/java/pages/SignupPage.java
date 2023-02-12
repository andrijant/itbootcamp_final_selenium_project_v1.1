package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

//    Name input field
    public WebElement getNameInputField(){
        return driver.findElement(By.name("name"));
    }
//    Email input field
    public WebElement getEmailInputField(){
        return driver.findElement(By.name("email"));
    }
//    Password input field
    public WebElement getPasswordInputField(){
        return driver.findElement(By.name("password"));
    }
//    Confirm password input field  confirmPassword
    public WebElement getConfirmPasswordInputField(){
        return driver.findElement(By.name("confirmPassword"));
    }
//    Sign me up button
    public WebElement getSignMeUpButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
}

//●	Polje za unos imena
//●	Polje za unos emaila
//●	Polje za unos lozinke
//●	Polje za potvrdi lozinku
//●	Sign me up dugme
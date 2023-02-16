package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

//    Email input field
    public WebElement getMyProfileEmailInputField(){
        return driver.findElement(By.cssSelector("#email"));
    }
//    Name input field
    public WebElement getMyProfileNameInputField(){
        return driver.findElement(By.cssSelector("#name"));
    }
//    City input field
    public WebElement getMyProfileCityInputField(){
        return driver.findElement(By.cssSelector("#city"));
    }
//    Country input field
    public WebElement getMyProfileCountryInputField(){
        return driver.findElement(By.cssSelector("#country"));
    }
//    Twitter input field
    public WebElement getMyProfileTwitterInputField(){
        return driver.findElement(By.cssSelector("#urlTwitter"));
    }
//    GitHub input field
    public WebElement getMyProfileGitHubInputField(){
        return driver.findElement(By.cssSelector("#urlGitHub"));
    }
//    Phone input field
    public WebElement getMyProfilePhoneInputField(){
        return driver.findElement(By.cssSelector("#phone"));
    }


}

//Kreirati Profile Page sa svim neophodnim metodama za realizaciju
// profile testova.
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //  Visibility of pop up message
    public void waitForPopUpMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@role='status']")));
    }

    //  Pop up login message text
    public String getLoginPopUpMessage() {
        return driver.findElement(
                By.xpath("//*[@role='status']//li")).getText();
    }

    //  Visibility of pop up admin message
    public void waitForAdminPopUpMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".success")));
    }

    //  Pop up admin message text
    public String getAdminPopUpMessage() {
        return driver.findElement(
                By.cssSelector(".success div")).getText();
    }

    //  Visibility of Logout button
    public void waitForLogoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".btnLogout ")));
    }

    //  Verify account message title
    public WebElement getVerifyAccountMessageTitle() {
        return driver.findElement(By.cssSelector(".dlgVerifyAccount"));
    }

    //  Verify account message close button
    public WebElement getVerifyAccountMessageCloseButton() {
        return driver.findElement(By.cssSelector(".btnClose"));
    }
}

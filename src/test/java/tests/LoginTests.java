package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test(priority = 1)
    @Description("Test #1: Visits the login page")
    public void visitLoginPage(){
        loginPage.getLoginLink().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Invalid URL");
    }

    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checkInputTypes(){
        loginPage.getLoginLink().click();

        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"), "email",
                "Invalid type of email input field");
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"), "password",
                "Invalid type of password input field");
    }

    @Test(priority = 3)
    @Description("Test #3: Displays errors when user does not exist")
    public void displaysErrorsWhenUserDoesNotExist(){
        loginPage.getLoginLink().click();

        loginPage.getEmailInputField().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInputField().sendKeys("password123");

        loginPage.getLoginButton().click();
        loginPage.waitForErrorMessage();

        Assert.assertEquals(loginPage.getErrorMessage(), "User does not exists",
                "Error message is not visible");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Invalid URL");
    }

    @Test(priority = 4)
    @Description("Test #4: Displays errors when password is wrong")
    public void displaysErrorsWhenPasswordDoesNotExist(){
        loginPage.getLoginLink().click();

        loginPage.getEmailInputField().sendKeys("admin@admin.com");
        loginPage.getPasswordInputField().sendKeys("password123");

        loginPage.getLoginButton().click();
        loginPage.waitForErrorMessage();

        Assert.assertEquals(loginPage.getErrorMessage(), "Wrong password",
                "Error message is not visible");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Invalid URL");
    }

    @Test(priority = 5)
    @Description("Test #5: Login with valid credentials")
    public void loginWithValidCredentials() throws InterruptedException {
        loginPage.getLoginLink().click();

        loginPage.getEmailInputField().sendKeys("admin@admin.com");
        loginPage.getPasswordInputField().sendKeys("12345");
        Thread.sleep(2000);
        loginPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "Invalid URL");
    }

    @Test(priority = 6)
    @Description("Test #6: Logout")
    public void logout(){
        loginPage.waitLogoutButton();
        loginPage.logoutButton().click();
    }
}

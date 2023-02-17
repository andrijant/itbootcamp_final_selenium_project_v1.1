package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test #1: Visits the login page")
    public void visitLoginPage() throws InterruptedException {
        navPage.getLanguageButton().click();
        navPage.getEnLanguageButton().click();
        navPage.getLoginLink().click();
        Thread.sleep(2000);
        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/login"),
                "Invalid /login URL");
    }

    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checkInputTypes() {
        navPage.getLoginLink().click();

        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"), "email",
                "Invalid type of email input field");
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"), "password",
                "Invalid type of password input field");
    }

    @Test(priority = 3)
    @Description("Test #3: Displays errors when user does not exist")
    public void displaysErrorsWhenUserDoesNotExist() {
        navPage.getLoginLink().click();

        loginPage.getEmailInputField().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInputField().sendKeys("password123");

        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpMessage();

        Assert.assertEquals(messagePopUpPage.getLoginPopUpMessage(),
                "User does not exists",
                "The message does not contain 'User does not exists'");

        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/login"),
                "Invalid /login URL");
    }

    @Test(priority = 4)
    @Description("Test #4: Displays errors when password is wrong")
    public void displaysErrorsWhenPasswordDoesNotExist() throws InterruptedException {
        navPage.getLoginLink().click();

        loginPage.getEmailInputField().sendKeys(loginEmail);
        loginPage.getPasswordInputField().sendKeys("password123");

        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpMessage();
        Thread.sleep(1000);
        Assert.assertEquals(messagePopUpPage.getLoginPopUpMessage(),
                "Wrong password",
                "The message does not contain 'Wrong password'");

        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/login"),
                "Invalid /login URL");
    }

    @Test(priority = 5)
    @Description("Test #5: Login with valid credentials")
    public void loginWithValidCredentials() throws InterruptedException {
        navPage.getLoginLink().click();

        loginPage.getEmailInputField().sendKeys(loginEmail);
        loginPage.getPasswordInputField().sendKeys(loginPassword);
        Thread.sleep(2000);
        loginPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/home"),
                "Invalid /home URL");
    }

    @Test(priority = 6)
    @Description("Test #6: Logout")
    public void logout() {
        messagePopUpPage.waitForLogoutButton();
        navPage.getLogoutButton().click();
    }
}

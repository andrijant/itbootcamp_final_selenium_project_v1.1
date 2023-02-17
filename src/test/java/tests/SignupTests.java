package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test #1: Visits the signup page")
    public void visitTheSignupPage() throws InterruptedException {
        navPage.getSignUpLink().click();
        Thread.sleep(2000);
        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/signup"),
                "Invalid /signup URL");
    }

    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checkInputTypes() throws InterruptedException {
        navPage.getSignUpLink().click();
        Thread.sleep(2000);
        Assert.assertEquals(signupPage.getEmailInputField().getAttribute("type"),
                "email",
                "Invalid email input type");
        Assert.assertEquals(signupPage.getPasswordInputField().getAttribute("type"),
                "password",
                "Invalid password input type");
        Assert.assertEquals(signupPage.getConfirmPasswordInputField().getAttribute("type"),
                "password",
                "Invalid confirm password input type");
    }

    @Test(priority = 3)
    @Description("Test #3: Displays errors when user already exists")
    public void displayErrorWhenUserAlreadyExist() throws InterruptedException {
        navPage.getSignUpLink().click();
        Thread.sleep(2000);
        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/signup"),
                "Invalid /signup URL");

        signupPage.getNameInputField().sendKeys("Another User");
        signupPage.getEmailInputField().sendKeys(loginEmail);
        signupPage.getPasswordInputField().sendKeys(loginPassword);
        signupPage.getConfirmPasswordInputField().sendKeys(loginPassword);
        signupPage.getSignMeUpButton().click();

        messagePopUpPage.waitForPopUpMessage();
        Assert.assertEquals(messagePopUpPage.getLoginPopUpMessage(),
                "E-mail already exists",
                "The message does not contain 'E-mail already exists'");

        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/signup"),
                "Invalid /signup URL");
    }

    @Test(priority = 4)
    @Description("Test #4: Signup")
    public void signup() throws InterruptedException {
        navPage.getSignUpLink().click();
        Thread.sleep(2000);

        signupPage.getNameInputField().sendKeys(myName);
        signupPage.getEmailInputField().sendKeys("andrija@itbootcamp.rs");
        signupPage.getPasswordInputField().sendKeys(loginPassword);
        signupPage.getConfirmPasswordInputField().sendKeys(loginPassword);
        signupPage.getSignMeUpButton().click();
        Thread.sleep(2000);

        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/home"),
                "Invalid URL");
        Assert.assertTrue(messagePopUpPage.getVerifyAccountMessageTitle().getText()
                        .contains("IMPORTANT: Verify your account"),
                "The message does not contain 'IMPORTANT: Verify your account'");
        messagePopUpPage.getVerifyAccountMessageCloseButton().click();

        navPage.getLogoutButton().click();
    }
}

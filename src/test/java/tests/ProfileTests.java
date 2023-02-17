package tests;

import jdk.jfr.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test #1: Visits the profile page")
    public void visitsTheProfilePage() throws InterruptedException {

        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys(loginEmail);
        loginPage.getPasswordInputField().sendKeys(loginPassword);
        Thread.sleep(1000);
        loginPage.getLoginButton().click();
        Thread.sleep(1000);
        navPage.getMyProfileLink().click();
        Thread.sleep(2000);
        Assert.assertTrue(profilePage.getMyProfileEmailInputField()
                        .getAttribute("value")
                        .contains(loginEmail),
                "Attribute 'value' does not contain " + loginEmail);
        navPage.getLogoutButton().click();
    }

    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checkInputTypes() throws InterruptedException {

        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys(loginEmail);
        loginPage.getPasswordInputField().sendKeys(loginPassword);
        Thread.sleep(1000);
        loginPage.getLoginButton().click();
        Thread.sleep(1000);
        navPage.getMyProfileLink().click();
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String attrDisabled = (String) js.executeScript("return arguments[0].getAttribute('disabled');",
                profilePage.getMyProfileEmailInputField());
        Assert.assertTrue(profilePage.getMyProfileEmailInputField()
                        .getAttribute("type")
                        .contains("email"),
                "Attribute 'type' does not contain 'email'");
        Assert.assertEquals(attrDisabled, "disabled",
                "Attribute 'disabled' does not contain 'disabled'");
        Assert.assertTrue(profilePage.getMyProfileNameInputField()
                        .getAttribute("type")
                        .contains("text"),
                "Attribute 'type' does not contain 'text'");
        Assert.assertTrue(profilePage.getMyProfileCityInputField()
                        .getAttribute("type")
                        .contains("text"),
                "Attribute 'type' does not contain 'text'");
        Assert.assertTrue(profilePage.getMyProfileCountryInputField()
                        .getAttribute("type")
                        .contains("text"),
                "Attribute 'type' does not contain 'text'");
        Assert.assertTrue(profilePage.getMyProfileTwitterInputField()
                        .getAttribute("type")
                        .contains("url"),
                "Attribute 'type' does not contain 'url'");
        Assert.assertTrue(profilePage.getMyProfileGitHubInputField()
                        .getAttribute("type")
                        .contains("url"),
                "Attribute 'type' does not contain 'url'");
        Assert.assertTrue(profilePage.getMyProfilePhoneInputField()
                        .getAttribute("type")
                        .contains("tel"),
                "Attribute 'type' does not contain 'tel'");
        navPage.getLogoutButton().click();
    }

    @Test(priority = 3)
    @Description("Test #3: Edits profile")
    public void editProfile() throws InterruptedException {

        navPage.getLoginLink().click();
        loginPage.getEmailInputField().sendKeys(loginEmail);
        loginPage.getPasswordInputField().sendKeys(loginPassword);
        Thread.sleep(1000);
        loginPage.getLoginButton().click();
        Thread.sleep(1000);
        navPage.getMyProfileLink().click();
        Thread.sleep(1000);

        profilePage.getMyProfileNameInputField().sendKeys(Keys.CONTROL + "a");
        profilePage.getMyProfileNameInputField().sendKeys(Keys.BACK_SPACE);
        profilePage.getMyProfileNameInputField().sendKeys(myName);

        profilePage.getMyProfilePhoneInputField().sendKeys(Keys.CONTROL + "a");
        profilePage.getMyProfilePhoneInputField().sendKeys(Keys.BACK_SPACE);
        profilePage.getMyProfilePhoneInputField().sendKeys(phone);

        profilePage.getMyProfileCityInputField().sendKeys(Keys.CONTROL + "a");
        profilePage.getMyProfileCityInputField().sendKeys(Keys.BACK_SPACE);
        profilePage.getMyProfileCityInputField().sendKeys(city + Keys.TAB);

        profilePage.getMyProfileCountryInputField().sendKeys(Keys.CONTROL + "a");
        profilePage.getMyProfileCountryInputField().sendKeys(Keys.BACK_SPACE);
        profilePage.getMyProfileCountryInputField().sendKeys(country);

        profilePage.getMyProfileTwitterInputField().sendKeys(Keys.CONTROL + "a");
        profilePage.getMyProfileTwitterInputField().sendKeys(Keys.BACK_SPACE);
        profilePage.getMyProfileTwitterInputField().sendKeys(twitter);

        profilePage.getMyProfileGitHubInputField().sendKeys(Keys.CONTROL + "a");
        profilePage.getMyProfileGitHubInputField().sendKeys(Keys.BACK_SPACE);
        profilePage.getMyProfileGitHubInputField().sendKeys(github);

        Thread.sleep(1000);
        citiesPage.getSaveButton().click();

        Thread.sleep(3000);
        Assert.assertTrue(messagePopUpPage.getAdminPopUpMessage()
                        .contains("Profile saved successfuly"),
                "The message does not contain 'Profile saved successfuly'");

        Assert.assertTrue(profilePage.getMyProfileNameInputField()
                        .getAttribute("value")
                        .contains(myName),
                "Email input field does not contain " + myName);
        Assert.assertTrue(profilePage.getMyProfileCityInputField()
                        .getAttribute("value")
                        .contains(city),
                "Email input field does not contain " + city);
        Assert.assertTrue(profilePage.getMyProfileCountryInputField()
                        .getAttribute("value")
                        .contains(country),
                "Email input field does not contain " + country);
        Assert.assertTrue(profilePage.getMyProfileTwitterInputField()
                        .getAttribute("value")
                        .contains(twitter),
                "Email input field does not contain " + twitter);
        Assert.assertTrue(profilePage.getMyProfileGitHubInputField()
                        .getAttribute("value")
                        .contains(github),
                "Email input field does not contain " + github);
        Assert.assertTrue(profilePage.getMyProfilePhoneInputField()
                        .getAttribute("value")
                        .contains(phone),
                "Email input field does not contain " + phone);

        navPage.getLogoutButton().click();
    }
}

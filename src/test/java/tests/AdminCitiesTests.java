package tests;

import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {
    @Test(priority = 1)
    @Description("Test #1: Visits the admin cities page and list cities")
    public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {
        navPage.getLoginLink().click();

        loginPage.getEmailInputField().sendKeys(loginEmail);
        loginPage.getPasswordInputField().sendKeys(loginPassword);
        Thread.sleep(2000);
        loginPage.getLoginButton().click();

        navPage.getAdminButton().click();
        navPage.getAdminCitiesLink().click();

        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/admin/cities"),
                "Invalid /admin/cities URL");
    }

    @Test(priority = 2)
    @Description("Test #2: Checks input types for create/edit new city")
    public void checkInputTypeForCreateEditNewCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getAdminCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForVisibilityOfNewItemPopUp();
        Thread.sleep(2000);
        Assert.assertEquals(citiesPage.getNewItemInputField().getAttribute("type"),
                "text",
                "Invalid search input type");
    }

    @Test(priority = 3)
    @Description("Test #3: Create new city")
    public void createNewCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getAdminCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForVisibilityOfNewItemPopUp();
        citiesPage.getNewItemInputField().sendKeys(city);
        citiesPage.getSaveButton().click();

        messagePopUpPage.waitForAdminPopUpMessage();
        Thread.sleep(500);
        Assert.assertTrue(messagePopUpPage.getAdminPopUpMessage()
                        .contains("Saved successfully"),
                "The message does not contain 'Saved successfully'");
    }

    @Test(priority = 4)
    @Description("Test #4: Edit city")
    public void editCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getAdminCitiesLink().click();
        citiesPage.getSearchInput().sendKeys(city);
        citiesPage.waitForVisibilityOfTableRows(1);
        citiesPage.getEditButtonFromTableRow(1).click();
        citiesPage.getNewItemInputField().sendKeys(Keys.CONTROL + "a");
        citiesPage.getNewItemInputField().sendKeys(Keys.BACK_SPACE);
        citiesPage.getNewItemInputField().sendKeys(city + " Edited");
        citiesPage.getSaveButton().click();

        messagePopUpPage.waitForAdminPopUpMessage();
        Thread.sleep(500);
        Assert.assertTrue(messagePopUpPage.getAdminPopUpMessage()
                        .contains("Saved successfully"),
                "The message does not contain 'Saved successfully'");
    }

    @Test(priority = 5)
    @Description("Test #5: Search city")
    public void searchCity() {
        navPage.getAdminButton().click();
        navPage.getAdminCitiesLink().click();

        citiesPage.waitForVisibilityOfTableRows(1);
        Assert.assertTrue(citiesPage.getTableCell(1, 2)
                        .getText().contains(city),
                "The message does not contain " + city + " name");
    }

    @Test(priority = 6)
    @Description("Test #6: Delete city")
    public void deleteCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getAdminCitiesLink().click();
        citiesPage.getSearchInput().sendKeys(city);
        citiesPage.waitForVisibilityOfTableRows(1);
        Assert.assertTrue(citiesPage.getTableCell(1, 2)
                        .getText().contains(city),
                "Invalid city name");
        citiesPage.getDeleteButtonFromTableRow(1).click();
        citiesPage.waitForVisibilityOfDeleteItemPopUp();
        citiesPage.waitForVisibilityOfTableRows(1);
        citiesPage.getDeleteDialogueButton().click();
        messagePopUpPage.waitForAdminPopUpMessage();
        Assert.assertTrue(messagePopUpPage.getAdminPopUpMessage()
                        .contains("Deleted successfully"),
                "The message does not contain 'Deleted successfully'");
    }
}

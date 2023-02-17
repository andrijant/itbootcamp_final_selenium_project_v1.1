package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test #1: Forbids visits to home url if not authenticated")
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        navPage.navigateToPage(baseUrl, "/home");
        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/login"),
                "Invalid /login URL");
    }

    @Test(priority = 2)
    @Description("Test #2: Forbids visits to profile url if not authenticated")
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        navPage.navigateToPage(baseUrl, "/profile");
        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/login"),
                "Invalid /login URL");
    }

    @Test(priority = 3)
    @Description("Test #3: Forbids visits to admin cities url if not authenticated")
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        navPage.navigateToPage(baseUrl, "/admin/cities");
        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/login"),
                "Invalid /login URL");
    }

    @Test(priority = 4)
    @Description("Test #4: Forbids visits to admin users url if not authenticated")
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        navPage.navigateToPage(baseUrl, "/admin/users");
        Assert.assertTrue(navPage.getCurrentPageUrl().contains("/login"),
                "Invalid /login URL");
    }
}


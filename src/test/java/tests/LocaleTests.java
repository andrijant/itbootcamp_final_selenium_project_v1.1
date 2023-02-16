package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {

    @Test(priority = 1)
    @Description("Test #1: Set locale to ES")
    public void setLocaleToES() {
        navPage.getLanguageButton().click();
        navPage.getEsLanguageButton().click();
        Assert.assertTrue(navPage.headerText().contains("Página de aterrizaje"),
                "The header does not contain 'Página de aterrizaje'");
    }

    @Test(priority = 2)
    @Description("Test #2: Set locale to EN")
    public void setLocaleToEN() {
        navPage.getLanguageButton().click();
        navPage.getEnLanguageButton().click();
        Assert.assertTrue(navPage.headerText().contains("Landing"),
                "The header does not contain 'Landing'");
    }

    @Test(priority = 3)
    @Description("Test #3: Set locale to CN")
    public void setLocaleToCN() {
        navPage.getLanguageButton().click();
        navPage.getCnLanguageButton().click();
        Assert.assertTrue(navPage.headerText().contains("首页"),
                "The header does not contain '首页'");
    }

    @Test(priority = 4)
    @Description("Test #4: Set locale to FR")
    public void setLocaleToFR() {
        navPage.getLanguageButton().click();
        navPage.getFrLanguageButton().click();
        Assert.assertTrue(navPage.headerText().contains("Page d'atterrissage"),
                "The header does not contain 'Page d'atterrissage'");
    }
}
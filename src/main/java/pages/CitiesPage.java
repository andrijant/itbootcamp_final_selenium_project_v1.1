package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

//    New Item button
    public WebElement getNewItemButton(){
        return driver.findElement(By.cssSelector(".btnNewItem"));
    }
//    Search input
    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }
//    Visibility of new/edit item dialogue
    public void waitForVisibilityOfNewItemPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".dlgNewEditItem")
        ));
    }
//    Visibility of delete item dialogue
//    Visibility of delete item dialogue
//    Save button
    public WebElement getSaveButton(){
        return driver.findElement(By.cssSelector(".btnSave"));
    }

}

//●	dugme New Item
//●	input za pretragu
//●	metodu koja ceka da se dijalog za editovanje i kreiranje pojavi
//●	metodu koja ceka da se dijalog za brisanje pojavi
//●	save dugme iz dijalog za editovanje i kreiranje
//●	delete dugme iz dijaloga za brisanje

//●	metodu koja ceka da se u tabeli pojavi odredjeni broj redova.
// Metoda kao parametar prima broj redova. Ako se metoda pozove sa parametrom 5,
// to znaci da metoda ceka da se u tabeli pojavi 5 redova.

//●	metodu koja vraca celiju iz odredjenog reda.
// Metoda kao parametre prima red i kolonu a vraca td iz tabele.
// Npr: ukoliko se metoda pozove row=2, cell=3 tada metoda vraca trecu celiju iz 2 reda.

//●	metodu koja vraca edit dugme trazenog reda.
// Metoda kao parametar prima red a vraca dugme.
// Npr ako se metoda pozove row=3, metoda vraca edit dugme iz treceg reda tabele

//●	metodu koja vraca delete dugme trazenog reda.
// Metoda kao parametar prima red a vraca dugme.
// Npr ako se metoda pozove row=3, metoda vraca delete dugme iz treceg reda tabele
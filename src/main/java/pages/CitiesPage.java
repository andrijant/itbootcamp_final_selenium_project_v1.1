package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //    New Item button
    public WebElement getNewItemButton() {
        return driver.findElement(By.cssSelector(".btnNewItem"));
    }

    //    New Item input field
    public WebElement getNewItemInputField() {
        return driver.findElement(
                By.id("name"));
    }

    //    Search input
    public WebElement getSearchInput() {
        return driver.findElement(By.id("search"));
    }

    //    Visibility of new/edit item dialogue
    public void waitForVisibilityOfNewItemPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".dlgNewEditItem")
        ));
    }

    //    Visibility of delete item dialogue
    public void waitForVisibilityOfDeleteItemPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".warning")
        ));
    }

    //    Save dialogue button
    public WebElement getSaveButton() {
        return driver.findElement(By.cssSelector(".btnSave"));
    }

    //    Delete dialogue button
    public WebElement getDeleteDialogueButton() {
        return driver.findElement(
                By.cssSelector("button.red--text.text--lighten3"));
    }

    //    Visibility of table rows
    public void waitForVisibilityOfTableRows(int numberOfRows) {
        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.xpath("//table/tbody/tr"), numberOfRows));
    }

    //    Table cell
    public WebElement getTableCell(int tableRow, int tableCell) {
        return driver.findElement(
                By.xpath("//table/tbody/tr[" + tableRow + "]/td[" + tableCell + "]"));
    }

    //    Edit button from table row
    public WebElement getEditButtonFromTableRow(int tableRow) {
        return driver.findElement(
                By.xpath("//table/tbody/tr[" + tableRow + "]//button[@id='edit']"));
    }

    //    Delete button from table row
    public WebElement getDeleteButtonFromTableRow(int tableRow) {
        return driver.findElement(
                By.xpath("//table/tbody/tr[" + tableRow + "]//button[@id='delete']"));
    }
}

package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(login);
        WebElement pass = driver.findElement(By.id("passwd"));
        pass.sendKeys(login);
        WebElement submit = driver.findElement(By.name("submitLogin"));
        submit.click();
        waitForContentLoad();
    }

    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        WebElement catalogElement = driver.findElement(By.id("subtab-AdminCatalog"));
        catalogElement.click();
        waitForContentLoad();
        //TODO: create catalog steps
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("//*[@id = 'ajax_running']")));

        // wait.until(...);
        // ...
    }



}

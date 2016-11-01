package TestFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FirefoxBrowser {

    public static WebDriver browser;
    private static WebDriverWait delay;
    public enum elementType{
        css,xpath
    }

    /**
     * Launches an instance of the Firefox browser
     */
    public void launchBrowser() {
        browser  = new FirefoxDriver();
        browser.manage().window().maximize();
    }

    /**
     * Navigates to the desired URL
     * @param url URL string
     */
    public void goToURL(String url){
        browser.navigate().to(url);
    }

    /**
     * Closes the instance of the Firefox browser
     */
    public void closeBrowser(){
        browser.quit();
    }

    /**
     * Verifies the title on the current page
     * @param title Title string to be verified
     */
    public void verifyTitle(String title) {
        Assert.assertTrue(browser.getTitle().contains(title),"Title is not"+title);
    }

    /**
     * Waits for the element to become visible until a maximum of 10 seconds.
     * @param type Specify the element type to wait for (CSS/xPath)
     * @param element String of the CSS/xPath selector
     */
    public void waitForElementToBeVisible(elementType type, String element) {
        delay  = new WebDriverWait(browser,10);
        switch (type) {

            case css:
                delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
                break;
            case xpath:
                delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
                break;
        }
    }

    /**
     * Waits for the element to become clickable until a maximum of 10 seconds.
     * @param type Specify the element type to wait for (CSS/xPath)
     * @param element String of the CSS/xPath selector
     */
    public void waitForElementToBeClickable(elementType type, String element) {
        delay  = new WebDriverWait(browser,10);
        switch (type) {

            case css:
                delay.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
                break;
            case xpath:
                delay.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
                break;
        }
    }

    /**
     * Enters the desired username on the login page
     * @param username String of the username to be entered
     */
    public void enterUsername(String username){
        browser.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys(username);
    }

    /**
     * Enters the desired password on the login page
     * @param password String of the password to be entered
     */
    public void enterPassword(String password){
        browser.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys(password);
    }

    /**
     * Performs the click action on the "Login with Active Directory" button
     */
    public void clickLoginWithAD(){
        browser.findElement(By.cssSelector("div[ng-click=\"vm.goToADSignIn()\"]")).click();
    }

    /**
     * Performs the click action on the "Login" button
     */
    public void clickLogin(){
        browser.findElement(By.cssSelector("div[ng-click=\"vm.login()\"]")).click();
    }

    /**
     * Performs the click action on the "Dashboard" tab button
     */
    public void clickDashboardButton(){
        browser.findElement(By.cssSelector("a[href=\"#/dashboard\"]")).click();
    }

    /**
     * Performs the click action on the "Ingestion" tab button
     */
    public void clickIngestionButton(){
        waitForElementToBeClickable(elementType.css,"a[href=\"#/ingestion\"]");
        browser.findElement(By.cssSelector("a[href=\"#/ingestion\"]")).click();
    }

    /**
     * Performs the click action on the "Index" tab button
     */
    public void clickIndexButton(){
        browser.findElement(By.cssSelector("a[href=\"#/indexing\"]")).click();
    }

    /**
     * Performs the click action on the "eDiscovery" tab button
     */
    public void clickEDiscoveryButton(){
        browser.findElement(By.cssSelector("a[href=\"#/ediscovery\"]")).click();
    }


    public void clickDispositionButton(){
        browser.findElement(By.cssSelector("a[href=\"#/disposition\"]")).click();
    }

    /**
     * Performs the click action on the "Disposition" tab button
     */
    public void clickSetupButton(){
        browser.findElement(By.cssSelector("a[href=\"#/setup\"]")).click();
    }

    /**
     * Performs the click action on the "Logs" tab button
     */
    public void clickLogsButton(){
        browser.findElement(By.cssSelector("a[href=\"#/log\"]")).click();
    }

    public WebDriver getDriver(){
        return browser;
    }
}

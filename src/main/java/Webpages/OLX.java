package Webpages;

import org.openqa.selenium.By;

/**
 * Created by Alin on 10/28/2016.
 */
public class OLX extends Driver{
    Driver please = new Driver();
    public void login(String username, String password){
        please.waitForElementToBeClickable(elementType.css,"span[class=\"link inlblk\"]");
        browser.findElement(By.cssSelector("span[class=\"link inlblk\"]")).click();

        please.waitForElementToBeClickable(elementType.css,"input[id=\"userEmail\"]");
        browser.findElement(By.cssSelector("input[id=\"userEmail\"]")).sendKeys(username);

        please.waitForElementToBeClickable(elementType.css,"input[id=\"userPass\"]");
        browser.findElement(By.cssSelector("input[id=\"userPass\"]")).sendKeys(password);

        please.waitForElementToBeClickable(elementType.css,"button[id=\"se_userLogin\"]");
        browser.findElement(By.cssSelector("button[id=\"se_userLogin\"]")).click();
    }
}

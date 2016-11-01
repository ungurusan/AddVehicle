package TestFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Alin on 10/19/2016.
 */
public class Ingestion extends FirefoxBrowser {


    FirefoxBrowser please = new FirefoxBrowser();
//Manage Cabinets
    /**
     * Performs the click action on the "Manage cabinets" button on the left side menu
     */
    public void manageCabinets(){
        please.waitForElementToBeClickable(elementType.xpath, "//span[text()=\"Manage cabinets\"]");
        browser.findElement(By.xpath("//span[text()=\"Manage cabinets\"]")).click();
    }

    /**
     * Performs the click action on the "Refresh" button in the "Manage Cabinets" page
     */
    public void refreshCabinetGrid(){
        browser.findElement(By.cssSelector("div[title=\"Refresh the cabinets grid\"]")).click();
    }

    /**
     * Performs the click action on the "Edit Cabinet" icon corresponding to the desired row
     * @param text String from the row to perform actions on
     */
    public void editCabinet(String text){
        List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row ng-scope\"]"));
        for (WebElement row:tableList){
            String object = row.getText();
            if(object.contains(text)){
                row.findElement(By.cssSelector("i[class=\"fa fa-pencil\"]")).click();
                break;
            }
        }
    }

    /**
     * Performs the click action on the "Save" button in the "Edit Cabinet" menu
     */
    public void editCabinetSave(){
        please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[2]");
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[2]")).click();
    }

    /**
     * Performs the click action on the "Save" button in the "Edit Cabinet" menu
     */
    public void editCabinetCancel(){
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[1]/div")).click();
    }

    /**
     * Performs the click action on the "Clear Cabinet" icon corresponding to the desired row
     * @param text String from the row to perform actions on
     */
    public void clearCabinet(String text){
        List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row ng-scope\"]"));
        for (WebElement row:tableList){
            String object = row.getText();
            if(object.contains(text)){
                row.findElement(By.cssSelector("i[class=\"fa fa-eraser\"]")).click();
                break;
            }
        }
    }

    /**
     * Performs the click action on the "No" button in the "Clear confirmation" menu
     */
    public void clearCabinetNo(){
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[1]/edit-panel/div/div/div/div[4]/div/div[1]/div")).click();
    }

    /**
     * Performs the click action on the "No" button in the "Clear confirmation" menu
     */
    public void clearCabinetYes(){
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[1]/edit-panel/div/div/div/div[4]/div/div[2]/div")).click();
    }

    /**
     * Performs the click action on the "Delete Cabinet" icon corresponding to the desired row
     * @param text String from the row to perform actions on
     */
    public void deleteCabinet(String text){
        List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row ng-scope\"]"));
        for (WebElement row:tableList){
            String object = row.getText();
            if(object.contains(text)){
                row.findElement(By.cssSelector("i[class=\"fa fa-times\"]")).click();
                break;
            }
        }
    }

    /**
     * Performs the click action on the "No" button in the "Delete confirmation" menu
     */
    public void deleteCabinetNo(){
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[2]/edit-panel/div/div/div/div[4]/div/div[1]/div")).click();
    }

    /**
     * Performs the click action on the "Yes" button in the "Delete confirmation" menu
     */
    public void deleteCabinetYes(){
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[2]/edit-panel/div/div/div/div[4]/div/div[2]/div")).click();
    }
    //Create New Cabinet
        /**
        * Performs the click action on the "Create New" button in the Cabinets page
        */
        public void createNewCabinet(){
            please.waitForElementToBeClickable(elementType.css,"div[title=\"Create New Cabinet\"]");
            browser.findElement(By.cssSelector("div[title=\"Create New Cabinet\"]")).click();
        }

        /**
        * Enters the name in the "Name" field on the "Add New Cabinet" menu
        * @param name String of the name to be entered
        */
        public void enterCabinetName(String name) {
            please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/input");
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/input")).sendKeys(name);
        }

        /**
        * Enters the description in the "Description" field on the "Add New Cabinet" menu
        * @param desc String of the description to be entered
        */
        public void enterCabinetDescription(String desc) {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/input")).sendKeys(desc);
        }

        /**
        * Selects the desired value from the "Cabinet Type" drop down menu
        * @param value String of the item to be selected
        */
        public void selectCabinetType(String value){
            Select select = new Select(browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/select")));
            select.selectByVisibleText(value);
        }

        /**
        * Performs the check actions in the "Create default 'index schema'?" checkbox
        * @param flag true = check, false = leave unchecked
        */
        public void checkIndexSchema(boolean flag) {
        if(!flag) {
            if (browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[8]/div[2]/div[1]/input")).isSelected()) {
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[8]/div[2]/div[1]/input")).click();
            }
        }
        else {
            if (!browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[8]/div[2]/div[1]/input")).isSelected()) {
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[8]/div[2]/div[1]/input")).click();
            }
        }

        }

        /**
        * Performs the check actions in the "Create default 'index policy'?" checkbox
        * @param flag true = check, false = leave unchecked
        */
        public void checkIndexPolicy(boolean flag) {
            if(!flag) {
                if (browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[9]/div[2]/div[1]/input")).isSelected()) {
                    browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[9]/div[2]/div[1]/input")).click();
                } else {
                }
            }
            else if (flag){
                if(browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[9]/div[2]/div[1]/input")).isSelected()){

                } else {browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[9]/div[2]/div[1]/input")).click();}
            }

        }
//Manage Index Fields
        /**
         * Performs the click action on the "Manage Index Fields" on the left side menu
         */
        public void manageIndexFields() {
            please.waitForElementToBeClickable(elementType.css,"a[href=\"#/manageMasterFields\"]");
            browser.findElement(By.cssSelector("a[href=\"#/manageMasterFields\"]")).click();
        }
    //New Index Field
        /**
        * Performs the click action on the "New Index Field" on the "Manege Index Fields" page
        */
        public void newIndexField() {
            please.waitForElementToBeClickable(elementType.css, "div[title=\"Create New Index Field\"]");
            browser.findElement(By.cssSelector("div[title=\"Create New Index Field\"]")).click();
        }

        /**
        * Selectes the desired value from the "filed Type" drop down menu
        * @param value String of the item to be selected
        */
        public void selectFieldType(String value){
            Select select = new Select(browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/select")));
            select.selectByVisibleText(value);
        }

        /**
        * Enters the desired text in the "Display Name" field on the "Add New Index Field" menu
        * @param indexdispname String of the desired display name
        */
        public void enterNewIndexFieldDisplayName(String indexdispname) {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/input")).sendKeys(indexdispname);
        }

        /**
        * Enters the desired text in the "Field Name" field on the "Add New Index Field" menu
        * @param name String of the desired field name
        */
        public void enterIndexFieldName(String name) {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/input")).sendKeys(name);
        }

        /**
        * Performs the check action on the "Searchable" checkbox in the "Add New Index Filed" menu
        * @param flag true = checked , false = leave unchecked
        */
        public void searchableCheckbox(boolean flag) {
            if(flag==false) {
                if (browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[4]/div[2]/div[1]/input")).isSelected()) {
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[4]/div[2]/div[1]/input")).click();
                } else {
                }
            }
            else if (flag==true){
                if(browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[4]/div[2]/div[1]/input")).isSelected()){

                } else {browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[4]/div[2]/div[1]/input")).click();}
            }

        }

        /**
        * Performs the check action on the "Retrivable" checkbox in the "Add New Index Filed" menu
        * @param flag true = checked , false = leave unchecked
        */
        public void retrievableCheckbox(boolean flag) {
            if(flag==false) {
                if (browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[5]/div[2]/div[1]/input")).isSelected()) {
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[5]/div[2]/div[1]/input")).click();
                } else {
                }
            }
            else if (flag==true) {
                if (browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[5]/div[2]/div[1]/input")).isSelected()) {

                } else {
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[5]/div[2]/div[1]/input")).click();
                    }
            }
        }

        /**
        * Performs the check action on the "Sortable" checkbox in the "Add New Index Filed" menu
        * @param flag true = checked , false = leave unchecked
        */
        public void sortableCheckbox(boolean flag) {
            if(flag==false) {
                if (browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[6]/div[2]/div[1]/input")).isSelected()) {
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[6]/div[2]/div[1]/input")).click();
                } else {
                }
            }
            else if (flag==true){
            if(browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[6]/div[2]/div[1]/input")).isSelected()){

            } else {browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[6]/div[2]/div[1]/input")).click();}
            }

        }

        /**
        * Performs the check action on the "Filterable" checkbox in the "Add New Index Filed" menu
        * @param flag true = checked , false = leave unchecked
        */
        public void filterableCheckbox(boolean flag) {
            if(flag==false) {
                if (browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[7]/div[2]/div[1]/input")).isSelected()) {
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[7]/div[2]/div[1]/input")).click();
                } else {
                }
            }
            else if (flag==true){
                if(browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[7]/div[2]/div[1]/input")).isSelected()){

                } else {browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[7]/div[2]/div[1]/input")).click();}
            }

        }

        /**
        * Performs the click action on the "Save" button in the "Add New Index Field" menu
        */
        public void saveIndexField() {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[2]/div")).click();
        }

        /**
        * Performs the click action on the "Cancel" button in the "Add New Index Field" menu
        */
        public void cancelNewMasterField() {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[1]/div")).click();
        }


    // Manage Cabinet Types
        /**
        * Performs the click action on the "Manage Cabinet Types" on the left side menu
        */
        public void manageCabinetTypes() {
            please.waitForElementToBeClickable(elementType.css,"a[href=\"#/manageCabinetTypes\"]");
            browser.findElement(By.cssSelector("a[href=\"#/manageCabinetTypes\"]")).click();
        }

        /**
        * Performs the click action on the "New Cabinet Type" button in the :Manage Cabinet Types" page
        */
        public void newCabinetType() {
            please.waitForElementToBeClickable(elementType.css, "div[title=\"Create new Master Field\"]");
            browser.findElement(By.cssSelector("div[title=\"Create new Master Field\"]")).click();
        }

        /**
        * Enters the desired name in the "Type" field on the "Add new Cabinet Type" menu
        */
        public void enterCabinetTypeName() {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/input")).click();
        }

        /**
        * Enters the desired description in the "Description" field on the "Add new Cabinet Type" menu
        */
        public void enterCabinetTypeDescription() {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/input")).click();
        }

        /**
        * Performs the click action on the "Index Schema Fields" field
        */
        public void searchCabinetFieldBox() {

            browser.findElement(By.xpath("//*[@id=\"name\"]")).click();
        }

        /**
        * Performs the click action on the "Cancel" button in the "Master Fields" menu
        */
        public void cancelMasterField() {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[1]/div")).click();
        }

        /**
        * Performs the click action on the "Ok" button in the "Master Fields" menu
        */
        public void okMasterField() {
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[3]/div[2]/div[1]/div/div[1]/div/div/div/div[4]/div/div/div[2]/div/i")).click();
        }

        /**
        * Add the desired fields from the "Master Fields" menu
        * @param text String of the "Display Name" for the field to be added (e.g. Attachments)
        */
        public void addSchemaFields(String text){
            List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row index-row ng-scope\"]"));
            for (WebElement row:tableList){
                String object = row.getText();
                if(object.contains(text)){
                    row.findElement(By.cssSelector("div[ng-click=\"OnAddCustodian(item)\"]")).click();
                    break;
                }
            }
        }

        /**
         * Performs the click action on the "Advanced" button on the left side menu
         */
        public void advancedMasterField() {
            please.waitForElementToBeClickable(elementType.xpath, "/html/body/div/div[2]/div[2]/div/div/div[1]/div/div/div/ul/li[2]/div/div");
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[1]/div/div/div/ul/li[2]/div/div")).click();
        }


}

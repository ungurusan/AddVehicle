package TestFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * @see TestFramework.FirefoxBrowser
 * Created by Alin on 10/21/2016.
 */
public class EDiscovery extends FirefoxBrowser {

    FirefoxBrowser please = new FirefoxBrowser();
    //----eDiscovery Section----

    /**
     * Performs the click action on the "Quick Search" options in the left side menu
     */
    public void clickQuickSearch() {
        please.waitForElementToBeClickable(elementType.css,"a[href=\"#/quicksearch\"]");
        browser.findElement(By.cssSelector("a[href=\"#/quicksearch\"]")).click();
    }

    /**
     * Performs the click action on the "Matter" option in the left side menu
     */
    public void clickMatter() {
        please.waitForElementToBeClickable(elementType.css,"a[href=\"#/matter\"]");
        browser.findElement(By.cssSelector("a[href=\"#/matter\"]")).click();
    }

    /**
     * Performs the click action on the "Production option in the left side menu
     */
    public void clickProduction() {
        please.waitForElementToBeClickable(elementType.css,"a[href=\"#/production\"]");
        browser.findElement(By.cssSelector("a[href=\"#/production\"]")).click();
    }

//----Quick Search Section----

        /**
        * Performs the click action on the delete search button that corresponds to the desired row
        * @param text String from the row where to perform the delete (e.g. Name)
        */
        public void deleteSearch(String text){
            List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row index-row ng-scope\"]"));
            for (WebElement row:tableList){
                String object = row.getText();
                if(object.contains(text)){
                    row.findElement(By.cssSelector("i[class=\"fa fa-times\"]")).click();
                    break;
                }
            }
        }

        /**
        *  Performs the click action on the "No" button in the "Delete confirmation" popup window
        */
        public void deleteSearchNo(){
        please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[1]/edit-panel/div/div/div/div[4]/div/div[1]/div");
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[1]/edit-panel/div/div/div/div[4]/div/div[1]/div")).click();
        }

        /**
        * Performs the click action on the "No" button in the "Delete confirmation" popup window
        */
        public void deleteSearchYes(){
        please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[1]/edit-panel/div/div/div/div[4]/div/div[2]/div");
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-yes-no-panel[1]/edit-panel/div/div/div/div[4]/div/div[2]/div")).click();
        }

        /**
        * Performs the click action on the "New Search Button" in the "Quick Search" section
        */
        public void newQuickSearch(){
    please.waitForElementToBeClickable(elementType.css,"div[title=\"Create new Search\"]");
    browser.findElement(By.cssSelector("div[title=\"Create new Search\"]")).click();
    }
        //----New Quick Search Section----

            /**
            * Performs the select action for the desired Index in the "Search Criteria" section
            * @param value Name of the desired item to select
            */
            public void selectIndexes(String value){
            please.waitForElementToBeClickable(elementType.css,"select[ng-model=\"vm.requestSearchData.indexId\"]");
            Select select = new Select(browser.findElement(By.cssSelector("select[ng-model=\"vm.requestSearchData.indexId\"]")));
            select.selectByVisibleText(value);
            }

            /**
            * Enter the desired search string in the "Search Criteria" section
            * @param text The string used to perform the search
            */
            public void enterSearchText(String text){
            please.waitForElementToBeClickable(elementType.css,"input[ng-model=\"ngModel[$index]\"]");
            browser.findElement(By.cssSelector("input[ng-model=\"ngModel[$index]\"]")).sendKeys(text);

            }

            /**
            * Performs the click action on the Search button in the "New Quick Search" page
            */
            public void clickSearch(){
            browser.findElement(By.cssSelector("i[class=\"fa fa-search\"]")).click();
            }

            /**
            * Performs the click action on the Save button in the "New Quick Search" page(the one with the floppy disk icon)
            */
            public void clickSave(){
            browser.findElement(By.cssSelector("i[class=\"fa fa-floppy-o\"]")).click();
            }

            /***
            * Performs the click action on the save button in the "Add New" window
            * @param from The date from when the search is performed
            * @param to The date to when the search is performed
            */
            public void enterSearchDate(String from, String to){
            please.waitForElementToBeVisible(elementType.css,"input[ng-change=\"normalizeDate0()\"]");
            browser.findElement(By.cssSelector("input[ng-change=\"normalizeDate0()\"]")).sendKeys(from);
            browser.findElement(By.cssSelector("input[ng-change=\"normalizeDate1()\"]")).sendKeys(to);
            }

            /**
             * Enters the desired text in the "Owner" field in the "Search Criteria" menu on the "New Quick Search" page
             * @param owner String to be entered in the "Owner" field
             */
            public void enterOnwer(String owner){
                        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/div[3]/div[3]/div/div/text-field/div/div/div[1]/input")).sendKeys(owner);
            }

            /**
             * Enters the desired text in the "Subdepartment" field in the "Search Criteria" menu on the "New Quick Search" page
             * @param subdepartment String to be entered in the "Subdepartment" field
             */
            public void enterSubdepartment(String subdepartment){
                        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/div[4]/div[3]/div/div/text-field/div/div/div[1]/input")).sendKeys(subdepartment);
            }

            /**
             * Enters the desired text in the "Department" field in the "Search Criteria" menu on the "New Quick Search" page
             * @param department String to be entered in the "Department" field
             */
            public void enterDepartment(String department){
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/div[5]/div[3]/div/div/text-field/div/div/div[1]/input")).sendKeys(department);
            }

            /**
            * Enters the desired text in the "EmployeeID" field in the "Search Criteria" menu on the "New Quick Search" page
            * @param id String to be entered in the "EmployeeID" field
            */
            public void enterEmployeeID(String id){
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/div[6]/div[3]/div/div/text-field/div/div/div[1]/input")).sendKeys(id);
            }

            /**
             * Performs the click action on the "Simple Search" link in the "New Quick Search" page
             */
            public void clickSimpleSearchLink(){
                please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/div[8]/div/a");
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/div[8]/div/a")).click();
            }

            /**
             * Performs the click action on the "Advanced Search" link in the "New Quick Search" page
             */
            public void clickAdvancedSearchLink(){
                please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/div[4]/div/a");
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/div[4]/div/a")).click();
            }

            /**
             * Performs the click action on the save button in the "Add New" window
             */
            public void clickSaveSearch(){
            please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/edit-panel[2]/div/div/div/div[4]/div/div[2]/div");
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/edit-panel[2]/div/div/div/div[4]/div/div[2]/div")).click();
            }

            /**
            * Enter the "Name" in the "Add New" window
            * @param name Desired name to be entered
            */
            public void enterSaveName(String name){
            please.waitForElementToBeVisible(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/edit-panel[2]/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/input");
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/edit-panel[2]/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/input")).sendKeys(name);
            }

            /**
            * Check or leave unchecked the "Create Production" checkbox
            * @param flag true=checked, false=unchecked
            */
            public void createProductionCheckbox(Boolean flag){
                    if(flag==true) {
                        please.waitForElementToBeVisible(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/edit-panel[2]/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/label");
                        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/edit-panel[2]/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/input")).click();
                    }else if(flag==false){}
                }

//----Matter section----

    /**
     * Performs the click action on the "New Matter" button in the "Matters" page
     */
    public void createNewMatter(){
                please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div");
                browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div")).click();
            }

    /**
     * Selects the desired value from the "order by" drop down menu
     * @param value String of the value to be selected
     */
    public void orderMatterBy(String value){
                please.waitForElementToBeVisible(elementType.css,"select[ng-change=\"item.valueChanged(item.ngModel)\"]");
                Select select = new Select(browser.findElement(By.cssSelector("select[ng-change=\"item.valueChanged(item.ngModel)\"]")));
                select.selectByVisibleText(value);
            }

    /**
     * Performs the click action on the desired matter in eDiscovery - Matters section, which expands it
     * @param name String of the matter to be expanded
     */
    public void expandMatter(String name){
        please.waitForElementToBeVisible(elementType.css,"div[class=\"header-layout\"]");
        List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"header-layout\"]"));
        for (WebElement row:tableList){
            String object = row.getText();
            if(object.contains(name)){
                row.findElement(By.cssSelector("div[class=\"label-header selectable\"]")).click();
                break;
            }
        }
    }

    /**
     * Performs the click action on the "New Search" button corresponding to the desired matter in eDiscovery - Matters section
     * @param name String of the matter to be expanded
     */
    public void matterNewSearch(String name){
        please.waitForElementToBeVisible(elementType.css,"div[class=\"header-layout\"]");
        List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"header-layout\"]"));
        for (WebElement row:tableList){
            String object = row.getText();
            if(object.contains(name)){
                row.findElement(By.cssSelector("div[ng-click=\"vm.newSearch(item.matter)\"]")).click();
                break;
            }
        }
    }

    /**
     * Performs the click action on the "View matter properties" button corresponding to the desired matter in eDiscovery - Matters section
     * @param name String of the matter to be expanded
     */
    public void viewMatterProperties(String name){
        please.waitForElementToBeVisible(elementType.css,"div[class=\"header-layout\"]");
        List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"header-layout\"]"));
        for (WebElement row:tableList){
            String object = row.getText();
            if(object.contains(name)){
                row.findElement(By.cssSelector("div[title=\"View matter properties\"]")).click();
                break;
            }
        }
    }

        //Edit Matter section
        /**
         * Performs the click action on the "Edit matter properties" button corresponding to the desired matter in eDiscovery - Matters section
         * @param name String of the matter to be expanded
         */
        public void editMatterProperties(String name){
            please.waitForElementToBeVisible(elementType.css,"div[class=\"header-layout\"]");
            List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"header-layout\"]"));
            for (WebElement row:tableList){
                String object = row.getText();
                if(object.contains(name)){
                    row.findElement(By.cssSelector("div[title=\"Edit matter properties\"")).click();
                    break;
                }
            }
        }

        /**
         * Clears and enters the desired text in the "Matter Name" field in the "Edit Matter" menu
         * @param text String of the text to be entered
         */
        public void editMatterName(String text){
                    please.waitForElementToBeVisible(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/input");
                    browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/input")).clear();
                    browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[1]/div[2]/div[1]/input")).sendKeys(text);
                }

        /**
         * Clears and enters the desired text in the "Matter Description" field in the "Edit Matter" menu
         * @param text String of the text to be entered
         */
        public void editMatterDescription(String text){
            please.waitForElementToBeVisible(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/input");
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/input")).clear();
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[2]/div[2]/div[1]/input")).sendKeys(text);
        }

        /**
         * Clears and enters the desired text in the "Matter Bates Mask" field in the "Edit Matter" menu
         * @param text String of the text to be entered
         */
        public void editMatterBatesMask(String text){
            please.waitForElementToBeVisible(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[5]/div[2]/div[1]/input");
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[5]/div[2]/div[1]/input")).clear();
            browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[5]/div[2]/div[1]/input")).sendKeys(text);
        }

        /**
         * Selects the desired value from the "Bates Location" drop down menu in the "Edit Matter" menu
         * @param text Value to be selected frm the drop-down menu
         */
        public void editMatterBatesLocation(String text){
            please.waitForElementToBeVisible(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[6]/div[2]/div[1]/select");
            Select select = new Select(browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[6]/div[2]/div[1]/select")));
            select.selectByVisibleText(text);
        }

        /**
         * Selects the desired value from the "Bates Color" drop down menu in the "Edit Matter" menu
         * @param text Value to be selected frm the drop-down menu
         */
        public void editMatterBatesColor(String text){
            please.waitForElementToBeVisible(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[7]/div[2]/div[1]/select");
            Select select = new Select(browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[7]/div[2]/div[1]/select")));
            select.selectByVisibleText(text);
        }

        /**
         * Selects the desired value from the "Bates Font" drop down menu in the "Edit Matter" menu
         * @param text Value to be selected frm the drop-down menu
         */
        public void editMatterBatesFont(String text){
            please.waitForElementToBeVisible(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[8]/div[2]/div[1]/select");
            Select select = new Select(browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[8]/div[2]/div[1]/select")));
            select.selectByVisibleText(text);
        }

        /**
         * Performs the check action for the "Bates" checkbox in the "Edit Matter" menu
         * @param flag true = checked , false = leave unchecked
         */
        public void editMatterCheckBates(Boolean flag){
            if(!flag) {
                if (browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[4]/div[2]/div[1]/input")).isSelected()) {
                    browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[4]/div[2]/div[1]/input")).click();
                }
            }
            else {
                if (!browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[4]/div[2]/div[1]/input")).isSelected()) {
                    browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[3]/div/div/div/form/div/div[4]/div[2]/div[1]/input")).click();
                }
            }

        }
            //User Rights
            public void clickUserRights(){
                please.waitForElementToBeVisible(elementType.css,"input[class=\"search-input\"]");
                browser.findElement(By.cssSelector("input[class=\"search-input\"]")).click();
            }

        /**
         * Performs the click action on the "Save" button in the "Edit Matter" menu
         */
        public void editMatterSave(){
                    please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[2]/div/span");
                    browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[2]/div/span")).click();
                }

        /**
         * Performs the click action on the "Save" button in the "Edit Matter" menu
         */
        public void editMatterCancel(){
        please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[1]/div/span");
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/edit-panel/div/div/div/div[4]/div/div[1]/div/span")).click();
    }

    /**
     * Performs the click action on the "Delete matter" button corresponding to the desired matter in eDiscovery - Matters section
     * @param name String of the matter to be expanded
     */
    public void deleteMatter(String name){
                please.waitForElementToBeVisible(elementType.css,"div[class=\"header-layout\"]");
                List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"header-layout\"]"));
                for (WebElement row:tableList){
                    String object = row.getText();
                    if(object.contains(name)){
                        row.findElement(By.cssSelector("div[title=\"Delete matter\"")).click();
                        break;
                    }
                }
            }

//----Production section----

    /**
     * Performs the click action on the "New Production" button in the Production - Ediscovery section
     */
    public void clickNewProduction(){
        please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div");
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div")).click();
    }

    /**
     * Performs the click action on the "Refresh" button in the Production - Ediscovery section
     */
    public void clickRefreshProduction(){
        please.waitForElementToBeClickable(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div");
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/div")).click();
    }

    /**
     * Expands the desired production row
     * @param name String of the production to be expanded
     */
    public void expandProduction(String name){
        please.waitForElementToBeVisible(elementType.css,"div[class=\"header-layout\"]");
        List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"header-layout\"]"));
        for (WebElement row:tableList){
            String object = row.getText();
            if(object.contains(name)){
                row.findElement(By.cssSelector("div[class=\"label-header selectable\"]")).click();
                break;
            }
        }
    }

        //----Actions for the expanded production----

        /**
         * Performs the click action on the "Lock Production" button if the production is expanded
         * @param name String from the row where to perform the action
         */
        public void expandProductionLockProduction(String name){
            please.waitForElementToBeVisible(elementType.css,"div[class=\"data-table-row ng-scope\"]");
            List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row ng-scope\"]"));
            for (WebElement row:tableList){
                String object = row.getText();
                if(object.contains(name)){
                    row.findElement(By.cssSelector("div[ng-click=\"vm.closeProduction(productionItem.production)\"]")).click();
                    break;
                }
            }
        }

        /**
         * Performs the click action on the "Build Production" button if the production is expanded
         * @param name String from the row where to perform the action
         */
        public void expandProductionBuildProduction(String name){
            please.waitForElementToBeVisible(elementType.css,"div[class=\"data-table-row ng-scope\"]");
            List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row ng-scope\"]"));
            for (WebElement row:tableList){
                String object = row.getText();
                if(object.contains(name)){
                    row.findElement(By.cssSelector("i[class=\"fa fa-cubes\"]")).click();
                    break;
                }
            }
        }

        /**
         * Performs the click action on the "Edit Production" button if the production is expanded
         * @param name String from the row where to perform the action
         */
        public void expandProductionEditProduction(String name){
            please.waitForElementToBeVisible(elementType.css,"div[class=\"data-table-row ng-scope\"]");
            List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row ng-scope\"]"));
            for (WebElement row:tableList){
                String object = row.getText();
                if(object.contains(name)){
                    row.findElement(By.cssSelector("i[class=\"fa fa-pencil\"]")).click();
                    break;
                }
            }
        }

        /**
         * Performs the click action on the "Delete Production" button if the production is expanded
         * @param name String from the row where to perform the action
         */
        public void expandProductionDeleteProduction(String name){
        please.waitForElementToBeVisible(elementType.css,"div[class=\"data-table-row ng-scope\"]");
        List<WebElement> tableList = browser.findElements(By.cssSelector("div[class=\"data-table-row ng-scope\"]"));
        for (WebElement row:tableList){
            String object = row.getText();
            if(object.contains(name)){
                row.findElement(By.cssSelector("i[class=\"fa fa-times\"]")).click();
                break;
            }
        }
    }

//----Custodians section----
    /**
     * Performs the click action on the "Custodians" option in the left side menu
     */
    public void clickCustodians() {
        please.waitForElementToBeClickable(elementType.css,"a[href=\"#/custodians\"]");
        browser.findElement(By.cssSelector("a[href=\"#/custodians\"]")).click();
    }

    /**
     * Enters the text to be searched for in the Custodians - eDiscovery page
     * @param text String of the text to be searched
     */
    public void enterCustodianSearchText(String text){
        please.waitForElementToBeVisible(elementType.css,"input[ng-model=\"vm.searchValue\"]");
        browser.findElement(By.cssSelector("input[ng-model=\"vm.searchValue\"]")).sendKeys(text);
    }

    /**
     * Selects the desired value from the "Search In" drop down menu in the Custodians - eDiscovery page
     * @param value String of the value to be searched
     */
    public void selectSearchIn(String value){
        please.waitForElementToBeClickable(elementType.css,"select[ng-model=\"vm.searchIn\"]");
        Select select = new Select(browser.findElement(By.cssSelector("select[ng-model=\"vm.searchIn\"]")));
        select.selectByVisibleText(value);
    }

    /**
     * Performs the click action on the "Refresh" button in the Custodians - eDiscovery page
     */
    public void clickRefreshCustodians(){
        please.waitForElementToBeClickable(elementType.css,"div[ng-click=\"vm.refresh()\"]");
        browser.findElement(By.cssSelector("div[ng-click=\"vm.refresh()\"]")).click();
    }

    /**
     * Performs the check actions on the "Distribution only" checkbox in the Custodians - eDiscovery page
     */
    public void checkDistributionOnly(){
        please.waitForElementToBeVisible(elementType.xpath,"/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[3]/label/input");
        browser.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[3]/label/input")).click();
    }
}

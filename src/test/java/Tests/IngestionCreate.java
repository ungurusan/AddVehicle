package Tests;

import TestFramework.Constants;
import TestFramework.FirefoxBrowser;
import TestFramework.Ingestion;
import org.testng.annotations.Test;

public class IngestionCreate extends TestConfig {

    @Test
    public void testNewCabinet(){

        Ingestion driver = new Ingestion();
        driver.goToURL(Constants.url);
        driver.clickIngestionButton();
        driver.manageCabinetTypes();
        driver.createNewCabinet();
        driver.enterCabinetName("Automation 4");
        driver.enterCabinetDescription("Automation Cabinet");
        driver.selectCabinetType("Cabinet Name Auto 4");
        driver.checkIndexPolicy(false);
        driver.checkIndexSchema(false);
        driver.editCabinetSave();


    }
}

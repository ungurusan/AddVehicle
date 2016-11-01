package Tests;

import TestFramework.EDiscovery;
import org.testng.annotations.Test;

public class TestTest extends TestConfig {

    @Test
    public void loginTest(){

        EDiscovery driver = new EDiscovery();
        driver.clickSave();
    }
}

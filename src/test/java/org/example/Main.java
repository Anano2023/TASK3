package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {
    private WebDriver driver;
    private final String LINK = "https://cloud.google.com/";
    private PricingCalculator pCalc;
    private ComputeEngine cEngine;
    private Summary summary;

    @BeforeClass
    public void setup(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        driver = new EdgeDriver(options);
        driver.get(LINK);

        pCalc = new PricingCalculator(driver);
        cEngine = new ComputeEngine(driver);
        summary = new Summary(driver);

    }
    @Test(priority = 1)
    public void navigateToCreateComputeEngine() throws InterruptedException {
        pCalc.searchText("Google Cloud Platform Pricing Calculator");
        pCalc.clickOnPricingCalcLink();
        pCalc.clickOnAddToEstemateBtn();
        pCalc.clickOnComputeEngine();

        cEngine.numberOfInstances();
        cEngine.selectDropdownSystem();
        cEngine.provisioningModel();
        cEngine.machineType();
        cEngine.addGpus();
        String totalPrice = summary.verifyTotalPrice();
        Assert.assertFalse(totalPrice.isEmpty(), "Total price is not displayed or is empty.");
        cEngine.shareEstimateBtn();
        Thread.sleep(3000);
    }
        @Test(priority = 2)
        public void testEstSummary() throws InterruptedException {
        summary.openEstSummary();
        Assert.assertTrue(summary.verifyEstSummary(3).contains("n1-standard-8, vCPUs: 8, RAM: 30 GB"));
        Assert.assertTrue(summary.verifyEstSummary(5).contains("NVIDIA V100"));
        Assert.assertTrue(summary.verifyEstSummary(6).contains("1"));
        Assert.assertTrue(summary.verifyEstSummary(7).contains("2x375 GB"));
        Assert.assertTrue(summary.verifyEstSummary(11).contains("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)"));
        Assert.assertTrue(summary.verifyEstSummary(12).contains("Regular"));
        Assert.assertTrue(summary.verifyEstSummary(19).contains("1 year"));
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

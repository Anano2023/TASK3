package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {
    private WebDriver webDriver;
    private final String LINK = "https://cloud.google.com/";
    PricingCalculator pCalc;
    ComputeEngine cEngine;

    @BeforeClass
    public void setup(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        webDriver = new EdgeDriver(options);
        webDriver.get(LINK);

        pCalc = new PricingCalculator(webDriver);
        cEngine = new ComputeEngine(webDriver);
    }
    @Test
    public void navigateToCreateComputeEngine() throws InterruptedException {
// Form data has different fields and there is no possibility to fulfill the exercise
        pCalc.clickPricingTab();
        pCalc.clickOnPricingCalc();
        pCalc.clickOnAddToEstamateBtn();
        pCalc.clickOnComputeEngine();
//        cEngine.numberOfInstances();
//        cEngine.selectDropdownSystem();
    }


}

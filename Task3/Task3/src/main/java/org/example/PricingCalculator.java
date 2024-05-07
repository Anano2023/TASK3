package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PricingCalculator
{
    WebDriver driver;
    public PricingCalculator(WebDriver driver){
        this.driver = driver;
    }
    public void clickPricingTab(){
    driver.findElement(By.linkText("Pricing")).click();
    }

    public void clickOnPricingCalc(){
        driver.findElement(By.xpath("//a[@href='https://cloud.google.com/products/calculator/' and @track-type='nav']")).click();
    }
    public void clickOnAddToEstamateBtn() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-idom-class='xhASFc']")).click();
        Thread.sleep(2000);
    }
    public void clickOnComputeEngine(){
        driver.findElement(By.className("aHij0b-aGsRMb")).click();
    }
}

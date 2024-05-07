package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculator
{
    private final WebDriver driver;
    private final WebDriverWait wait;

    public PricingCalculator(WebDriver driver){
        this.driver = driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void searchText(String text){
    WebElement sb = driver.findElement(By.className("YSM5S"));
    sb.click();
    WebElement sInput =driver.findElement(By.className("qdOxv-fmcmS-wGMbrd"));
    sInput.sendKeys(text);
    driver.findElement(By.cssSelector(".PETVs-OWXEXe-UbuQg")).click();

    //Perform click action
        Actions actions = new Actions(driver);
        int xCoordinate = 100; // Example x-coordinate
        int yCoordinate = 200; // Example y-coordinate
        actions.moveByOffset(xCoordinate, yCoordinate).click().perform();
    }

    public void clickOnPricingCalcLink(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://cloud.google.com/products/calculator']"))).click();
    }
    public void clickOnAddToEstamateBtn() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-idom-class='xhASFc']")).click();
        Thread.sleep(2000);
    }
    public void clickOnComputeEngine(){
        driver.findElement(By.className("aHij0b-aGsRMb")).click();
    }
}

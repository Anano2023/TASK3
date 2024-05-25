package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComputeEngine {
   private final WebDriver driver;
   private final WebDriverWait wait;
   @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[position()=4]")
   private WebElement selectDropdownSystemList;
   @FindBy(xpath = "//li[@data-value='free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license']")
   private WebElement operatingSystem;
   @FindBy(xpath = "//label[@for='regular']")
   private WebElement modelRegular;
   @FindBy(xpath = "(//div[@jsname='wSASue']/div/div)[position()=5]")
   private WebElement mFamily;
   @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[position()=5]")
   private WebElement chooseGeneralPurpose;
   @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[position()=6]")
    private WebElement seriesDropdown;
    @FindBy(xpath = "//ul[@aria-label='Series']/li[span[contains(., 'N1')]]")
    private WebElement chooseSeries;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[position()=7]")
    private WebElement machineType;
    @FindBy(xpath = "//ul[@aria-label='Machine type']/li[span[contains(., 'n1-standard-8')]]")
    private WebElement chooseMachineType;
    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement gpuBtn;
    @FindBy(xpath = "//div[@data-field-type='158']")
    private WebElement gpuModel;
    @FindBy(xpath = "//li[span[contains(., 'NVIDIA V100')]]")
    private WebElement nvidiaV100;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[position()=9]")
    private WebElement gpuNumberDropdown;
    @FindBy(xpath = "//ul[@aria-label='Number of GPUs']//li[span[contains(.,'1')]]")
    private WebElement chooseGpuNumber;
    @FindBy(xpath = "(//div[@jsname='oYxtQd']/div[@class='VfPpkd-aPP78e'])[position()=10]")
    private WebElement ssd;
    @FindBy(xpath = "//ul[@aria-label='Local SSD']//li[span[contains(.,'2x375 GB')]]")
    private WebElement ssdOption;
    @FindBy(xpath = "//label[@for='1-year']")
    private WebElement usage;
    @FindBy(xpath = "//button[@aria-label='Open Share Estimate dialog']")
    private WebElement shareButton;

    public ComputeEngine(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    public void numberOfInstances(){
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".QiFlid > .BfUoNb > div:nth-child(3) .wX4xVc-Bz112c-RLmnJb")));
        for(int i=0; i<3; i++){
            el.click();
        }
    }
    public void selectDropdownSystem()
    {
        selectDropdownSystemList.click();
        wait.until(ExpectedConditions.visibilityOf(operatingSystem)).click();
    }
    public void provisioningModel(){
        modelRegular.click();
    }
    public void machineType(){
        wait.until(ExpectedConditions.visibilityOf(mFamily)).click();
        wait.until(ExpectedConditions.visibilityOf(chooseGeneralPurpose)).click();

        seriesDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(chooseSeries)).click();

        machineType.click();
        wait.until(ExpectedConditions.visibilityOf(chooseMachineType)).click();
    }
    public void addGpus(){
        gpuBtn.click();
        wait.until(ExpectedConditions.visibilityOf(gpuModel)).click();
        wait.until(ExpectedConditions.visibilityOf(nvidiaV100)).click();
        gpuNumberDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(chooseGpuNumber)).click();
        ssd.click();
        wait.until(ExpectedConditions.elementToBeClickable(ssdOption)).click();
        usage.click();
    }
    public void shareEstimateBtn(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
    // Scroll down the page by a specific pixel value (e.g., 500 pixels)
        js.executeScript("window.scrollBy(0, 150)");
        js.executeScript("arguments[0].click();", shareButton);
        wait.until(ExpectedConditions.visibilityOf(shareButton)).click();
    }
}

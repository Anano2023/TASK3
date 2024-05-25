package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Summary {
    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(linkText = "Open estimate summary")
    private WebElement openLinkEstSummary;
    @FindBy(xpath = "//div[@class='fbc2ib']/label")
    private WebElement totalPriceElement;
    public Summary(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }
    public String verifyTotalPrice(){
        return wait.until(ExpectedConditions.visibilityOf(totalPriceElement)).getText();
    }
    public void openEstSummary() {
        String currentWindow = driver.getWindowHandle();

        // Click the link to open the new window
        wait.until(ExpectedConditions.elementToBeClickable(openLinkEstSummary)).click();

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new window handle
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    public String verifyEstSummary(int position){
    String xpath= String.format("(//span[@class='Kfvdz'])[position()=%d]", position);
    return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath)))).getText();
    }
}

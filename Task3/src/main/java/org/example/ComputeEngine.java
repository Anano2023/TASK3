package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComputeEngine {
    WebDriver driver;
    public ComputeEngine(WebDriver driver){
        this.driver=driver;
    }
    public void numberOfInstances(){
      WebElement numInstance= driver.findElement(By.xpath("//div[@jsaction='JIbuQc:qGgAE;']/button[@jscontroller='PIVayb'][1]"));
      numInstance.click();
    //div[contains(@jsaction, 'JIbuQc:qGgAE')][button[contains(@jslog, '198358')]]
      int count = 0;
      //initiate first click outside the loop
      numInstance.click();
      count++;
        for(int i=0; i<3; i++){
            numInstance.click();
            count++;
        }
    }

    public void selectDropdownSystem()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[@class='U4lDT']/div[@class='qUa9tb']/following-sibling::div[6]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)"))).click();


    }}

package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FlipkartProductPage {
    WebDriver driver;

    public FlipkartProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProduct(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By productLocator = By.xpath("(//a[contains(@class,'CGtC98') or contains(@class,'WKTcLC')])[" + index + "]");
        try {
            WebElement product = wait.until(ExpectedConditions.elementToBeClickable(productLocator));
            product.click();
            System.out.println("✅ Selected product #" + index);
        } catch (Exception e) {
            System.out.println("❌ Could not select product #" + index + ". Possibly structure changed.");
        }
    }
}

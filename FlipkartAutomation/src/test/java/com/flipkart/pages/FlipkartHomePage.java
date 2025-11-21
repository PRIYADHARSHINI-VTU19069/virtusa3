package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartHomePage {
    WebDriver driver;

    // Constructor
    public FlipkartHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By searchBox = By.name("q");
    By closePopup = By.xpath("//button[contains(text(),'✕')]");

    // Actions
    public void closeLoginPopup() {
        try {
            driver.findElement(closePopup).click();
            System.out.println("Popup closed.");
        } catch (Exception e) {
            System.out.println("No popup appeared.");
        }
    }

    public void searchProduct(String productName) {
        WebElement search = driver.findElement(searchBox);
        search.sendKeys(productName);
        search.submit();
        System.out.println("Searched for: " + productName);
    }
}

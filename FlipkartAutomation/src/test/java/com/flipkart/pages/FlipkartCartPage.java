package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartCartPage {
    WebDriver driver;

    public FlipkartCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCart = By.xpath("//button[contains(text(),'Add to cart')]");

    public void addToCart() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(addToCart).click();
        System.out.println("Product added to cart!");
    }
}

package com.flipkart.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.flipkart.pages.FlipkartHomePage;
import com.flipkart.pages.FlipkartProductPage;
import com.flipkart.pages.FlipkartCartPage;

import java.util.ArrayList;

public class FlipkartTests {

    @Test
    public void buyProductTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Priya\\Downloads\\136.0.7103.49 chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");

        FlipkartHomePage home = new FlipkartHomePage(driver);
        home.closeLoginPopup();
        home.searchProduct("iPhone 15");
        Thread.sleep(4000);

        FlipkartProductPage productPage = new FlipkartProductPage(driver);
        FlipkartCartPage cartPage = new FlipkartCartPage(driver);

        // Try up to 3 products
        for (int i = 1; i <= 3; i++) {
            System.out.println("🛍️ Trying product #" + i);
            productPage.selectProduct(i);

            // Switch to new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabs.size() - 1));
            Thread.sleep(3000);

            // Check if "Out of stock"
            if (driver.getPageSource().toLowerCase().contains("out of stock")) {
                System.out.println("⚠️ Product #" + i + " is out of stock. Trying next one...");
                driver.close();
                driver.switchTo().window(tabs.get(0)); // go back to search page
                Thread.sleep(2000);
            } else {
                cartPage.addToCart();
                System.out.println("✅ Product #" + i + " added to cart successfully!");
                break; // success
            }

            if (i == 3) {
                System.out.println("❌ All top 3 products are out of stock.");
            }
        }

        System.out.println("✅ Test execution completed!");
        driver.quit();
    }
}

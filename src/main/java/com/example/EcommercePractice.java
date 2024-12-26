package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommercePractice {


    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws InterruptedException {
        WebDriver dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //implicit wait for all the code.
        dr.get("https://rahulshettyacademy.com/seleniumPractise/");
        String name = dr.findElement(By.cssSelector("div[class=\"brand greenLogo\"]")).getText();
        System.out.println(name);
        Assert.assertEquals(name, "GREENKART");
        // h4[contains(text(),'Cauliflower')]
        String[] arr = { "Cucumber", "Brocolli", "Tomato" };

        List<WebElement> vegNames = dr.findElements(By.cssSelector("h4[class='product-name']"));

        // List al = Arrays.asList(arr);
        for (int i = 0; i <= vegNames.size(); i++) {
            String productNames = vegNames.get(i).getText();
            if (productNames.contains("Cucumber")) { // if product is cucumber it will get added to cart
                for (int j = 0; j < 3; j++) {
                    dr.findElements(By.xpath("//div[@class = 'stepper-input'] //a[@class='increment']")).get(i).click();
                }
                dr.findElements(By.xpath("//div[@class = 'product-action'] //button")).get(i).click();

                break;
            }

        }
        // System.out.println(vegNames);
        dr.findElement(By.xpath("//a[@class = 'cart-icon'] //img")).click();
        dr.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        Thread.sleep(2000);
        dr.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        dr.findElement(By.className("promoBtn")).click();
        //WebDriverWait wait = new WebDriverWait(dr,);
        //wait.until(ExpectedCondition.visibilityOfElementLocated(dr.findElement(By.className("promoInfo"))));
        String promoInfo = dr.findElement(By.className("promoInfo")).getText();
        System.out.println(promoInfo);
        // dr.close();
    }
}

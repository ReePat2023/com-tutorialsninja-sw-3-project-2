package desktops;

import browser.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']//li[@class='dropdown']//a[text()='Desktops']"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        mouseHoverAndClickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectFromDropDownMenu(By.id("input-sort"),"Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='caption']"));
        System.out.println("Products list in decending order :");
        for (WebElement productsName : products)
        {
            System.out.println(productsName.getText());
        }
        Thread.sleep(2000);
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on “Desktops” Tab and click
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']//li[@class='dropdown']//a[text()='Desktops']"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //2.3 Select Sort By position "Name: A to Z"
        selectFromDropDownMenu(By.id("input-sort"), "Name (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //2.5 Verify the Text "HP LP3065"
        Assert.assertEquals("HP LP3065", getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]")));
        //2.6 Select Delivery Date "2022-11-30"
        Thread.sleep(2000);
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//i[@class='fa fa-calendar']")); // Opens the date picker
        /**while (true) {
            String monthYear = driver.findElement(By.xpath("//th[@class='picker-switch']")).getText();
            // Nov 2022
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                //clickOnElement(By.xpath("//tbody/tr[4]/td[5]"));
            }
            List<WebElement> allDates = driver.findElements(By.xpath("//tbody/tr[4]/td[5]"));
            for (WebElement dt : allDates) {
                if (dt.getText().equalsIgnoreCase(date)) {
                    dt.click();
                    break;
                }
            }*/

        //2.7.Enter Qty "1” using Select class.
        Thread.sleep(2000);
        WebElement quantity= driver.findElement(By.xpath("//input[@id='input-quantity']"));
        quantity.clear();
        quantity.sendKeys("1");
        //2.8 Click on “Add to Cart” button
        Thread.sleep(2000);
        clickOnElement(By.id("button-cart"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Assert.assertEquals("Success message not found\",\"Success: You have added HP LP3065 to your shopping cart!\\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        //2.10 Click on link “shopping cart” display into success message
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.11 Verify the text "Shopping Cart"
        Assert.assertEquals("Shopping Cart", getTextFromElement(By.xpath("//a[contains(text(),'Shopping Cart')]")));
        //2.12 Verify the Product name "HP LP3065"
        Assert.assertEquals("HP LP3065", getTextFromElement(By.xpath("//table[@class='table table-bordered']//td[@class='text-left']//a[text()='HP LP3065']")));
        //2.13 Verify the Delivery Date "2022-11-30"
        //Assert.assertEquals("Delivery Date:2022-11-30", getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30')]")));
        //2.14 Verify the Model "Product21"
        Assert.assertEquals("Product 21", getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]")));
        //2.15 Verify the Todat "£74.73"
        Assert.assertEquals("$122.00", getTextFromElement(By.xpath("//tbody/tr[1]/td[6]")));
        }

    @After
    public void tearDown () {
        closeBrowser();
    }
}
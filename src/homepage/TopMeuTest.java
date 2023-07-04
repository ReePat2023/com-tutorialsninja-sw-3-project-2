package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class TopMeuTest  extends Utility{
        String baseUrl = "http://tutorialsninja.com/demo/index.php?";
        String menu ="Desktops";

        @Before
        public void setUp(){

            openBrowser(baseUrl);
        }

        //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
        public void selectMenu(String menu){
            //1.2 This method should click on the menu whatever name is passed as parameter
            clickOnElement(By.xpath("//nav[@id='menu'], '" + menu + "')]"));
            Assert.assertEquals("Correct page is not displayed", menu, driver.findElement(By.xpath("//nav[@id='menu'],'" + menu + "')]")).getText());
        }
        @Test
        public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
            //1.1 Mouse hover on “Desktops” Tab and click
            mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']//li[@class='dropdown']//a[text()='Desktops']"));
            //1.2 call selectMenu method and pass the menu = “Show All Desktops”
            mouseHoverAndClickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
            //1.3 Verify the text ‘Desktops’
            Assert.assertEquals("Desktops", getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]")));
        }
        @Test
        public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
            //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
            mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']//li[@class='dropdown']//a[text()='Desktops']"));
            //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
            mouseHoverAndClickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
            //2.3 Verify the text ‘Laptops & Notebooks’
            Assert.assertEquals("Laptops & Notebooks", getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]")));
        }
        @Test
        public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
            //3.1 Mouse hover on “Components” Tab and click
            mouseHoverOnElement(By.xpath("//li[@class='dropdown']//a[text()='Components']"));
            //3.2 call selectMenu method and pass the menu = “Show All Components”
            mouseHoverAndClickOnElement(By.xpath("//a[contains(text(),'Show AllComponents')]"));
            //3.3 Verify the text ‘Components’
            Assert.assertEquals("Components", getTextFromElement(By.xpath("//h2[contains(text(),'Components')]")));
        }

        @After
        public void tearDown(){
            closeBrowser();
        }
    }





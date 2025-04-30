package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    WebDriver driver ;

   public InventoryPage(WebDriver driver){
       this.driver = driver;
   }

    // locators
    By addtocart = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By cartItemName = By.className("inventory_item_name");

    // Actions
    public void additemtocart (){
        driver.findElement(addtocart).click();
    }
    public void opencart(){
        driver.findElement(cartIcon).click();
    }
    public String getcartitemname (){
        WebElement item = driver.findElement(cartItemName);
        return item.getText();
    }


}

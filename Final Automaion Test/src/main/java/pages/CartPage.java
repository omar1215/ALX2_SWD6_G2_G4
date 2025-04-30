package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

        // loacators
        By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
        By removeFromCartBtn = By.id("remove-sauce-labs-backpack");
        By cartIcon = By.className("shopping_cart_link");
        By cartItemName = By.className("inventory_item_name");

        // Actions
        public void additemtocart (){
            driver.findElement(addToCartBtn).click();
        }

        public void opencart() {
        driver.findElement(cartIcon).click();
        }

        public String getcartitemname() {
            return driver.findElement(cartItemName).getText();
        }

        public void removeitemfromcart() {
            driver.findElement(removeFromCartBtn).click();
        }

        public boolean isItemRemoved() {
            return driver.findElements(cartItemName).isEmpty();
        }


}


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;


public class LoginAddRemoveTest {
   protected WebDriver driver;


   @BeforeTest
   public void setup() {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
   }

    @Test
    public void successfulLoginTest() {
        driver.get("https://www.saucedemo.com");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterusername("standard_user");
        loginpage.enterPassward("secret_sauce");
        loginpage.opencartpage();

        Assert.assertTrue(loginpage.getpageurl().contains("inventory"), "Login failed");
    }

    @Test
    public void AddItemToCartTest() {
        // Login first
        driver.get("https://www.saucedemo.com");
        LoginPage login = new LoginPage(driver);
        login.enterusername("standard_user");
        login.enterPassward("secret_sauce");
        login.opencartpage();

        // Now add item to cart
        CartPage cartpage = new CartPage(driver);
        cartpage.additemtocart();
        cartpage.opencart();

        String itemname = cartpage.getcartitemname();
        Assert.assertTrue(itemname.contains("Sauce Labs Backpack"), "Item was not added to cart");
    }

    @Test
    public void removeItemFromCartTest() {
        // Step 1: Login
        driver.get("https://www.saucedemo.com");
        LoginPage login = new LoginPage(driver);
        login.enterusername("standard_user");
        login.enterPassward("secret_sauce");
        login.opencartpage();

        // Step 2: Add item to cart
        CartPage cartpage = new CartPage(driver);
        cartpage.additemtocart();
        cartpage.opencart();

        // Step 3: Remove item
        cartpage.removeitemfromcart();

        // Step 4: Verify item is removed
        Assert.assertTrue(cartpage.isItemRemoved(), "Item was not removed from the cart");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

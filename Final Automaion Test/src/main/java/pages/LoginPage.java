package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {
        WebDriver driver ;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By username = By.id("user-name");
    By passward = By.id("password");
    By loginButton = By.id("login-button");

    // Actions
    public void enterusername(String name ){
        driver.findElement(username).sendKeys(name);
    }
    public void enterPassward(String pass){
        driver.findElement(passward).sendKeys(pass);
    }
    public void opencartpage (){
       driver.findElement(loginButton).click();
    }
    public String getpageurl (){
        return driver.getCurrentUrl();
    }
}


package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {

    WebDriver driver;
    public AddToCartPage(WebDriver browser){
        driver = browser;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "span.continue.btn.btn-default.button.exclusive-medium")
    private WebElement btnContShop;

    public void clickContShopping(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnContShop));
        btnContShop.click();
    }


}

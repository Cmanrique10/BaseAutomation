package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {


    WebDriver driver;
    public ProductPage(WebDriver browser){
        driver = browser;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div.content_price.col-xs-5.col-md-12 span.price.product-price")
    private WebElement lblPrice;

    @FindBy(css = "p.alert.alert-warning")
    private WebElement lblMessage;

    @FindBy (css = "a.button.ajax_add_to_cart_button.btn.btn-default")
    private WebElement btnAddtoCart;



    public String getPrice(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(lblPrice));
        return lblPrice.getText();

    }

    public String getMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(lblMessage));
        return lblMessage.getText();

    }

    public void clickAddtoCart(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnAddtoCart));
        btnAddtoCart.click();
    }


}

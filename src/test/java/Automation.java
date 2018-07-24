import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ProductPage;
import pageobjects.SearchPage;

public class Automation {

    SearchPage search;
    ProductPage products;

    @Test
    public void Search() throws  InterruptedException{
        WebDriver browser = new ChromeDriver();
    browser.get("http://automationpractice.com/index.php");

    search = new SearchPage(browser);
    search.writeTest("blouse");


    search.clickSearch();
    search. clickListView();

    products = new ProductPage(browser);
        System.out.println(products.getPrice());



        Assert.assertEquals(products.getPrice().trim(),"$27.00","El precio es de :");

        browser.quit();
    }
}

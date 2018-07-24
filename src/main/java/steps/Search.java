package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageobjects.AddToCartPage;
import pageobjects.ProductPage;
import pageobjects.SearchPage;

public class Search {

    WebDriver driver;

    @Given("^Se carga la página de búsqueda$")
    public void seCargaLaPáginaDeBúsqueda() throws Throwable {

        driver.get("http://automationpractice.com/index.php");


    }

    @When("^Buscamos el término \"([^\"]*)\"$")
    public void buscamosElTérmino(String term) throws Throwable {
        SearchPage search = new SearchPage(driver);
        search.writeTest(term);
        search.clickSearch();

    }

    @Then("^Se muestra el mensaje \"([^\"]*)\"$")
    public void seMuestraElMensaje(String message) throws Throwable {
        ProductPage products = new ProductPage(driver);
        Assert.assertEquals(products.getMessage(), message + " \"microsoft\"", "El mensaje no es el esperado.");
    }

    @Before
    public void startUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @When("^Se añade al carrito un producto con la búsqueda de \"([^\"]*)\"$")
    public void seAñadeAlCarritoUnProductoConLaBúsquedaDe(String term) throws Throwable {
        SearchPage search = new SearchPage(driver);
        search.writeTest(term);
        search.clickSearch();

        ProductPage products = new ProductPage(driver);
        products.clickAddtoCart();

        AddToCartPage addProduct = new AddToCartPage(driver);
        addProduct.clickContShopping();

    }

    @Then("^se muestra el carro de compras \"([^\"]*)\" \"([^\"]*)\"$")
    public void seMuestraElCarroDeCompras(String quantity, String product) throws Throwable {
        SearchPage labelCart = new SearchPage(driver);

        Assert.assertEquals(labelCart.getOneProduct(),"1 Product" ,"No se muestra 1 producto");
    }
}


package applepage.test;
import applepage.page.BuyPage;
import applepage.page.CartPage;
import applepage.page.CheckoutPage;
import applepage.page.LandingPage;
import org.coronium.test.AutoTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AppleTest extends AutoTest {

    @Test
    public void AppleTest() {
        driver.manage().window().maximize();
        BuyPage buyPage = LandingPage.open()
                .clickMacPage()
                .clickMacbookPro16()
                .clickBuy();

        //Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)"); //Scroll vertically down by 1000 pixels

        String price = buyPage.getPrice(); //Get macbook pro 16" price
        CartPage cartPage = buyPage.clickSelectButton();

        //Find element button css and store in variable "Element"
        WebElement addToCartButton = driver.findElement(By.cssSelector("button[name='add-to-cart']"));

        //This will scroll the smc.page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", addToCartButton);

        CheckoutPage checkoutPage = cartPage.clickAddToCart();

    }
}

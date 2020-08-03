package org.coronium.page.applepage;

import org.coronium.page.AutoPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class CartPage extends AutoPage {

    @Name("Add to cart button")
    @FindBy( css = "button[name='add-to-cart']")
    private WebElement addToCartButton;

    @Step("Click Add to Cart button")
    public CheckoutPage clickAddToCart(){
        addToCartButton.click();
        return PageFactory.initElements(getDriver(), CheckoutPage.class);
    }
}

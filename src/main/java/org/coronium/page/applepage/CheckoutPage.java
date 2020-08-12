package org.coronium.page.applepage;

import org.coronium.page.AutoPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class CheckoutPage extends AutoPage {

    @Name("Checkout page - Price")
    @FindBy( css = "span.as-summaryheader-productprice")
    private WebElement totalPrice;

    @Step("Get total price")
    public String getTotalPrice(){
        return totalPrice.getText();
    }
}

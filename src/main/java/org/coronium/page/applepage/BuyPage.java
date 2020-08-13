package org.coronium.page.applepage;

import org.coronium.page.AutoPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class BuyPage extends AutoPage {

    @Name("Price")
    @FindBy( css = "span[data-autom='price-MVVK2']")
    private WebElement priceText;

    @Name("Select button")
    @FindBy( css = "[data-part-number='MVVK2ZP/A'] button[name='proceed']")
    private WebElement selectButton;

    @Step("Get price")
    public String getPrice(){
        return priceText.getText();
    }

    @Step("Click Select button")
    public CartPage clickSelectButton(){
        selectButton.click();
        return PageFactory.initElements(getDriver(), CartPage.class);
    }
}

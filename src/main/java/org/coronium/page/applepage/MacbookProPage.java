package org.coronium.page.applepage;

import org.coronium.page.AutoPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class MacbookProPage extends AutoPage {

    @Name("Buy button")
    @FindBy( css = "a.ac-ln-button")
    private WebElement buyButton;

    @Step("Click Buy Button")
    public BuyPage clickBuy(){
        buyButton.click();
        return PageFactory.initElements(getDriver(), BuyPage.class);
    }
}

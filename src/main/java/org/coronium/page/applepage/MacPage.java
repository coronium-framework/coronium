package org.coronium.page.applepage;

import org.coronium.page.AutoPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class MacPage extends AutoPage {

    @Name("Macbook Pro 16")
    @FindBy( css = "li.chapternav-item-macbook-pro-16 a")
    private WebElement macbookPro16;

    @Step("Click MacbookPro 16")
    public MacbookProPage clickMacbookPro16(){
        macbookPro16.click();
        return PageFactory.initElements(getDriver(), MacbookProPage.class);
    }
}

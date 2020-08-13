package org.coronium.page.applepage;

import org.coronium.page.core.ui.annotations.Visible;
import org.coronium.test.AutoTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class LandingPage extends AutoTest {

    @Visible
    @Name("Mac Tab")
    @FindBy( css = "a.ac-gn-link-mac")
    private WebElement macTab;

    @Step("Open URL")
    public static LandingPage open(){
        return PageFactory.initElements(getDriver(), LandingPage.class);
    }
    @Step("Set value to searchbox - {0}")
    public MacPage clickMacPage(){
        macTab.click();
        return PageFactory.initElements(getDriver(), MacPage.class);
    }
}

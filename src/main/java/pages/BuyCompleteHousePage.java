package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;

public class BuyCompleteHousePage extends BasePage {
    @FindBy(xpath = "//div[@class='sbrf-div-list-inner --area bp-area col-xs-12 col-sm-12 col-md-3']//span")
    private List<WebElement> itemsApplyingForHouse;

    @FindBy(xpath = "//div[contains(@class,'personal-data-warning__wrap')]/a")
    private WebElement closeWarningButton;

    public BuyCompleteHousePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void findItemInItemsApplyingForHouse(String value) {
        if (isElementPresent(closeWarningButton))
            closeWarningButton.click();
        for (WebElement i : itemsApplyingForHouse) {
            if (value.equalsIgnoreCase(i.getText())) {
                builder.moveToElement(i).click(i).perform();
                ArrayList tabs2 = new ArrayList (BaseSteps.getDriver().getWindowHandles());
                BaseSteps.getDriver().switchTo().window(String.valueOf(tabs2.get(1)));
                return;
            }
        }
    }

}

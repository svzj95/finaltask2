package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class,'header_more_nav')]/descendant::li")
    private List<WebElement> mainMenuItems;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectItem(String menu, String item) {
        int g = 0;
        for (WebElement i : mainMenuItems) {
            if (i.findElement(By.xpath("descendant::span[@class='multiline']")).getText().replaceAll("\\s", "").equalsIgnoreCase(menu.replaceAll("\\s", ""))) {
                builder.moveToElement(i).perform();
                break;
            }
            g++;
        }
        for (WebElement z : mainMenuItems.get(g).findElements(By.xpath("descendant::a[contains(@class,'alt-menu-list__link')]"))) {
            if (z.getText().equalsIgnoreCase(item)) {
                builder.click(z).perform();
                return;
            }
        }
        Assert.fail("Не найден элемент " + item);
    }

}

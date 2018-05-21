package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class BasePage {
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);

    BasePage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    Actions builder = new Actions(BaseSteps.getDriver());

    boolean isElementPresent(WebElement element) {
        try {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }


}

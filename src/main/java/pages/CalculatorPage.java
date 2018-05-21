package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import steps.BaseSteps;
import steps.MainSteps;

import java.util.List;
import java.util.regex.Pattern;

public class CalculatorPage extends BasePage {
    @FindBy(xpath = "//h1[@class='headerTitle___22vI']")
    private WebElement h1Title;

    @FindBy(xpath = "//label[contains(@class,'dcCalc_textfield_suffixIcon')]/input")
    private WebElement goalOfCreditArrowEl;

    @FindBy(xpath = "//input[@id='estateCost']")
    private WebElement estateCost;

    @FindBy(xpath = "//input[@id='initialFee']")
    private WebElement initialFee;

    @FindBy(xpath = "//input[@id='creditTerm']")
    private WebElement creditTerm;

    @FindBy(xpath = "//div[@class='dcCalc_switch-desktop']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
    private WebElement amountOfCredit;

    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    private WebElement monthlyPayment;

    @FindBy(xpath = "//span[@data-test-id='rate']")
    private WebElement rate;

    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    private WebElement requiredIncome;

    @FindBy(xpath = "//body")
    private WebElement dom;

    public CalculatorPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void checkTitle(String value){
        Assert.assertTrue(value.replaceAll("\\s", "").equalsIgnoreCase(h1Title.getText().replaceAll("\\s", "")));
    }

    private void sendKeys(WebElement element,String value) throws InterruptedException {
        element.clear();
        Thread.sleep(1000);
        element.sendKeys(value);
    }

    public String getElementXPath(WebDriver driver, WebElement element) {
        return (String)((JavascriptExecutor)driver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", element);
    }


    private void clickCheckbox(String value,String titleCheckbox) throws InterruptedException {
        for(WebElement i : checkboxes){
            if(i.findElement(By.xpath("./descendant::div[@class='dcCalc_switch-desktop__title']")).getText().equalsIgnoreCase(titleCheckbox)){
                WebElement input = i.findElement(By.xpath("./descendant::input"));
                if(value.equalsIgnoreCase("1") && !input.isSelected()){
                    builder.click(input).build().perform();
                    System.out.println(1);
                }
                else if(value.equalsIgnoreCase("0") && input.isSelected()){
                    builder.click(input).build().perform();
                    System.out.println(0);
                }
                Thread.sleep(500);
                return;
            }
        }
        Assert.fail("Не найден элемент " + titleCheckbox);
    }

    public void fillFields(String goalOfCredit, String priceOfRealEstate, String firstPay, String loanTerms, String salaryCardCheckbox, String lifeInsuranceCheckBox, String electrRegistrCheckBox, String devDiscCB) throws InterruptedException {
        Thread.sleep(2000);
        goalOfCreditArrowEl.click();
        goalOfCreditArrowEl.getCssValue(goalOfCredit);
        sendKeys(estateCost,priceOfRealEstate);
        sendKeys(initialFee,firstPay);
        sendKeys(creditTerm,loanTerms);
        clickCheckbox(salaryCardCheckbox,"Есть зарплатная карта Сбербанка");
        clickCheckbox(lifeInsuranceCheckBox,"Страхование жизни");
        clickCheckbox(electrRegistrCheckBox,"Электронная регистрация");
        clickCheckbox(devDiscCB,"Скидка от застройщика");

    }

    private void checkEquals(WebElement element, String elementStr){
        Assert.assertTrue(element.getText().contains(elementStr));

    }

    public void checkFields(String sumOfCredit, String monthlyPaymentStr, String rateStr, String requiredIncomeStr){
        checkEquals(amountOfCredit,sumOfCredit);
        checkEquals(monthlyPayment,monthlyPaymentStr);
        checkEquals(rate,rateStr);
        checkEquals(requiredIncome,requiredIncomeStr);
    }
}

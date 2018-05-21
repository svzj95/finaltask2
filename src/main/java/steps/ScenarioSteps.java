package steps;

import cucumber.api.java.en.When;

public class ScenarioSteps {
    private MainSteps mainSteps = new MainSteps();
    private BuyCompleteHouseSteps buyCompleteHouseSteps = new BuyCompleteHouseSteps();
    private CalculatorSteps calculatorSteps = new CalculatorSteps();

    @When("^В меню (.+) выбрать (.+)")
    public void selectItemInMainMenu(String menu, String item){
        mainSteps.selectItemInMainMenu(menu,item);
    }

    @When("^В разделе – Как подать заявку - нажать – (.+)")
    public void findItemInItemsApplyingForHouse(String value){
        buyCompleteHouseSteps.findItemInItemsApplyingForHouse(value);
    }

    @When("^Проверить, что на открывшейся странице есть заголовок - (.+)")
    public void checkTitle(String value){
        calculatorSteps.checkTitle(value);
    }

    @When("Цель кредита: (.+), Стоимость недвижимости – (.+), Первоначальный взнос: (.+), Срок кредитования: (.+), Зарплатная карта (.+), Страхование жизни (.+), Электронная регистрация (.+), Скидка от застройщика (.+)")
    public void fillFields(String goalOfCredit, String priceOfRealEstate, String firstPay, String loanTerms, String salaryCardCheckbox, String lifeInsuranceCheckBox, String electrRegistrCheckBox, String devDiscCB) throws InterruptedException {
        calculatorSteps.fillFields(goalOfCredit, priceOfRealEstate, firstPay, loanTerms, salaryCardCheckbox, lifeInsuranceCheckBox, electrRegistrCheckBox, devDiscCB);
    }

    @When("Проверить Cумма кредита: (.+), Ежемесячный платеж: (.+), Процентаня ставка (.+), Необходимой доход: (.+)")
    public void checkFields(String sumOfCredit, String monthlyPaymentStr, String rateStr, String requiredIncomeStr){
        calculatorSteps.checkFields(sumOfCredit, monthlyPaymentStr, rateStr, requiredIncomeStr);
    }
}

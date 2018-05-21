package steps;

import io.qameta.allure.Step;
import pages.CalculatorPage;

class CalculatorSteps {
    @Step("Проверить, что на открывшейся странице есть заголовок -  {0}")
    void checkTitle(String value){
        new CalculatorPage().checkTitle(value);
    }

    @Step("Цель кредита: {0}, Стоимость недвижимости – {1}, Первоначальный взнос: {2}, Срок кредитования: {3}, Зарплатная карта {4}, Возможно подтвердить доход {5}, Страхование жизни {6}, Электронная регистрация {7}, Скидка от застройщика {8}")
    void fillFields(String goalOfCredit, String priceOfRealEstate, String firstPay, String loanTerms, String salaryCardCheckbox, String lifeInsuranceCheckBox, String electrRegistrCheckBox, String devDiscCB) throws InterruptedException {
        new CalculatorPage().fillFields(goalOfCredit, priceOfRealEstate, firstPay, loanTerms, salaryCardCheckbox, lifeInsuranceCheckBox, electrRegistrCheckBox, devDiscCB);
    }

    @Step("Проверить Cумма кредита: {0}, Ежемесячный платеж: {1}, Процентаня ставка {3}, Необходимой доход: {2},")
    void checkFields(String sumOfCredit, String monthlyPaymentStr, String rateStr, String requiredIncomeStr){
        new CalculatorPage().checkFields(sumOfCredit, monthlyPaymentStr, rateStr, requiredIncomeStr);
    }
}

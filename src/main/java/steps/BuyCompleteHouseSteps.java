package steps;

import io.qameta.allure.Step;
import pages.BuyCompleteHousePage;

class BuyCompleteHouseSteps {
    @Step("В разделе – Как подать заявку - нажать – {0}")
    void findItemInItemsApplyingForHouse(String value){
        new BuyCompleteHousePage().findItemInItemsApplyingForHouse(value);
    }
}

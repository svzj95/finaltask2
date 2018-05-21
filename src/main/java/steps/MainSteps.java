package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {
    @Step("В меню {0} выбрать {1}")
    void selectItemInMainMenu(String menu, String item){
        new MainPage().selectItem(menu,item);
    }
}

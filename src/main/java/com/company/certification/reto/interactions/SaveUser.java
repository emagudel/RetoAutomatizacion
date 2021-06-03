package com.company.certification.reto.interactions;


import com.company.certification.reto.model.DataTest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static com.company.certification.reto.userinterface.BuyArticlesPage.LABEL_USER;


public class SaveUser implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {
        DataTest.getMap().put("userLogin", LABEL_USER.resolveFor(actor).getText());
    }

    public static SaveUser saveInformationUser() {
        return new SaveUser();
    }

}

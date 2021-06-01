package com.company.certification.reto.interactions;


import com.company.certification.reto.model.DataTest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static com.company.certification.reto.userinterface.BuyShoesPage.LABEL_DETAIL_SHOE;


public class SaveDetailShoe implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {
        DataTest.getMap()
                .put("informationDetailShoe", LABEL_DETAIL_SHOE.resolveFor(actor).getText());

    }

    public static SaveDetailShoe saveInformationBuyShoes() {
        return new SaveDetailShoe();
    }

}

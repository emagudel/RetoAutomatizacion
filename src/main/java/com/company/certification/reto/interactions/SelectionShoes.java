package com.company.certification.reto.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

import static com.company.certification.reto.model.DataTest.obtain;
import static com.company.certification.reto.userinterface.BuyShoesPage.LIST_SHOES;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectionShoes implements Interaction {

    public static SelectionShoes inAplication() {
        return instrumented(SelectionShoes.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String reference ="";
        boolean shoeFound = false;
        List<WebElementFacade> listaValores = LIST_SHOES.resolveAllFor(actor);
        for (int iterador = 0; iterador < listaValores.size(); iterador++) {
            reference = listaValores.get(iterador).getText().replace("\n","").replace(" ","");
            if(reference.equalsIgnoreCase(obtain("reference"))){
                actor.attemptsTo(Scroll.to(LIST_SHOES));
                LIST_SHOES.resolveAllFor(actor).get(iterador).click();
                shoeFound = true;
                break;
            }
        }
        if(!shoeFound){
            throw new NullPointerException("Shoe was not found");
        }
    }
}

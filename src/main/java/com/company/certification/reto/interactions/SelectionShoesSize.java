package com.company.certification.reto.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

import static com.company.certification.reto.model.DataTest.obtain;
import static com.company.certification.reto.userinterface.BuyShoesPage.LIST_SHOES_SIZE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectionShoesSize implements Interaction {

    public static SelectionShoesSize inAplication() {
        return instrumented(SelectionShoesSize.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String shoeSize ="";
        boolean sizeShoeFound = false;
        List<WebElementFacade> listaValores = LIST_SHOES_SIZE.resolveAllFor(actor);
        for (int iterador = 0; iterador < listaValores.size(); iterador++) {
            shoeSize = listaValores.get(iterador).getText().replace(" ","");
            if(shoeSize.equalsIgnoreCase(obtain("shoeSize"))){
                actor.attemptsTo(Scroll.to(LIST_SHOES_SIZE));
                LIST_SHOES_SIZE.resolveAllFor(actor).get(iterador).click();
                sizeShoeFound = true;
                break;
            }
        }
        if(!sizeShoeFound){
            throw new NullPointerException("Shoe size was not found");
        }
    }
}

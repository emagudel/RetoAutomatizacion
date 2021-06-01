package com.company.certification.reto.tasks;



import com.company.certification.reto.interactions.MoveTheMouseToTheTop;
import com.company.certification.reto.interactions.SelectionShoes;
import com.company.certification.reto.interactions.SelectionShoesSize;
import com.company.certification.reto.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.company.certification.reto.model.DataTest.obtain;
import static com.company.certification.reto.userinterface.BuyShoesPage.*;
import static com.company.certification.reto.util.manager.VerifyObject.elementVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuyShoes implements Task {

    public static BuyShoes inTheAplication() {
        return instrumented(BuyShoes.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BUTTON_LOGIN, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BUTTON_LOGIN),
                Enter.theValue(obtain("user").trim()).into(TXT_EMAIL),
                Enter.theValue(obtain("passwordUser").trim()).into(TXT_PASSWORD),
                Click.on(CHECK_LOGIN),
                Click.on(BUTTON_SIGN_IN),
                Wait.aTime(5000)
        );
        if (elementVisible(actor, IMAGE_AVATAR)) {
            actor.attemptsTo(
                    MoveTheMouseToTheTop.inAplication(),
                    SelectionShoes.inAplication(),
                    WaitUntil.the(LIST_SHOES_SIZE, isVisible()).forNoMoreThan(10).seconds(),
                    SelectionShoesSize.inAplication()
            );
            if(elementVisible(actor, BUTTON_ADD_TO_CAR)){
                actor.attemptsTo(
                        Click.on(BUTTON_ADD_TO_CAR),
                        WaitUntil.the(BUTTON_GO_TO_CAR, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(BUTTON_GO_TO_CAR),
                        WaitUntil.the(BUTTON_CHECKOUT, isEnabled()).forNoMoreThan(20).seconds(),
                        Click.on(BUTTON_CHECKOUT),
                        WaitUntil.the(BUTTON_PLACE_ORDER, isEnabled()).forNoMoreThan(20).seconds(),
                        Click.on(BUTTON_PLACE_ORDER),
                        WaitUntil.the(LABEL_THANKYOU, isVisible()).forNoMoreThan(20).seconds(),
                        Wait.aTime(5000)
                );
            }else{
                actor.attemptsTo(WaitUntil.the(
                        BUTTON_ADD_TO_CAR_RAFFLE, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(BUTTON_ADD_TO_CAR_RAFFLE),
                        WaitUntil.the(BUTTON_RAFFLE_1, isVisible()).forNoMoreThan(10).seconds(),
                        Scroll.to(BUTTON_RAFFLE_1),
                        Click.on(BUTTON_RAFFLE_1),
                        WaitUntil.the(BUTTON_RAFFLE_2, isVisible()).forNoMoreThan(10).seconds(),
                        Scroll.to(BUTTON_RAFFLE_2),
                        Click.on(BUTTON_RAFFLE_2),
                        WaitUntil.the(BUTTON_RAFFLE_3, isVisible()).forNoMoreThan(10).seconds(),
                        Scroll.to(BUTTON_RAFFLE_3),
                        Click.on(BUTTON_RAFFLE_3),
                        Wait.aTime(5000)
                );
            }
        }else{
            throw new NullPointerException("Could not authenticate with the credentials");
        }
    }
}

package com.company.certification.reto.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.company.certification.reto.model.DataTest.obtain;
import static com.company.certification.reto.userinterface.BuyArticlesPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SkipPopupLogInProblem implements Interaction {

    public static SkipPopupLogInProblem inAplication() {
        return instrumented(SkipPopupLogInProblem.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Exception capturar;
        try {
            while (USER_LOGIN.resolveFor(actor).withTimeoutOf(Duration.ofSeconds(5)).isVisible()) {
                actor.attemptsTo(Click.on(USER_LOGIN));
                TXT_EMAIL.resolveFor(actor).clear();
                actor.attemptsTo(
                        Type.theValue(obtain("user")).into(TXT_EMAIL),
                        Type.theValue(obtain("passwordUser")).into(TXT_PASSWORD),
                        Click.on(BUTTON_SIGN_IN),
                        WaitUntil.the(USER_LOGIN, isVisible()).forNoMoreThan(5).seconds()
                );
            }
        } catch (Exception e) {
            capturar = e;
        }
    }
}

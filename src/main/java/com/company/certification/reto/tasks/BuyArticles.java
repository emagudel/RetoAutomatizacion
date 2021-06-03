package com.company.certification.reto.tasks;


import com.company.certification.reto.interactions.SaveUser;
import com.company.certification.reto.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.company.certification.reto.model.DataTest.obtain;
import static com.company.certification.reto.userinterface.BuyArticlesPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuyArticles implements Task {

    public static BuyArticles inTheAplication() {
        return instrumented(BuyArticles.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BUTTON_LOGIN_LINIO, isVisible()).forNoMoreThan(10).seconds(),
                MoveMouse.to(BUTTON_LOGIN_LINIO),
                Click.on(BUTTON_SESION_LINIO),
                Enter.theValue(obtain("user").trim()).into(TXT_EMAIL_LINIO),
                Enter.theValue(obtain("passwordUser").trim()).into(TXT_PASSWORD_LINIO),
                Click.on(BUTTON_CONTINUE_LOGIN_LINIO),
                Wait.aTime(5000)
        );
        actor.attemptsTo(
                SaveUser.saveInformationUser()
        );
    }
}

package com.company.certification.reto.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToCartButtonForRaffle implements Interaction {
    private Target target;

    public static AddToCartButtonForRaffle inAplication(Target target) {
        return instrumented(AddToCartButtonForRaffle.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            while (target.resolveFor(actor).withTimeoutOf(Duration.ofSeconds(10)).isVisible()) {
                actor.attemptsTo(
                        WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds(),
                        Scroll.to(target),
                        Click.on(target)
                );
            }
        } catch (Exception e) {
            throw new NullPointerException("Problems selecting" + e);
        }
    }
}

package com.company.certification.reto.interactions;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Wait implements Interaction , IsSilent {

    private int var;

    protected Wait(int var) {
        this.var = var;
    }

    public static Wait aTime(int var) {
        return instrumented(Wait.class, var);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(var);
    }

}

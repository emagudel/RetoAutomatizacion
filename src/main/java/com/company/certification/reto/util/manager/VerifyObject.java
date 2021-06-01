package com.company.certification.reto.util.manager;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class VerifyObject {

    private static final Logger LOGGER = LogManager.getLogger(VerifyObject.class.getName());

    public static boolean elementEnable(Actor actor, Target target) {
        boolean result = false;
        try {
            actor.attemptsTo(WaitUntil.the(target, isEnabled()).forNoMoreThan(20).seconds());
            result = target.resolveFor(actor).isEnabled();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    public static boolean elementVisible(Actor actor, Target target) {
        boolean result = false;
        try {
            actor.attemptsTo(WaitUntil.the(target, isVisible()).forNoMoreThan(20).seconds());
            result = target.resolveFor(actor).isVisible();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    public static boolean elementPresent(Actor actor, Target target) {
        boolean result = false;
        try {
            actor.attemptsTo(WaitUntil.the(target, isPresent()).forNoMoreThan(20).seconds());
            result = target.resolveFor(actor).isPresent();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;

    }
}

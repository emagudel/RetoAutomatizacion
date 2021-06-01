package com.company.certification.reto.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.awt.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MoveTheMouseToTheTop implements Interaction {

    public static MoveTheMouseToTheTop inAplication() {
        return instrumented(MoveTheMouseToTheTop.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Exception capturar;
        try {
            Robot robot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            robot.mouseMove(-screenSize.width, -screenSize.height);
        } catch (Exception e) {
            capturar = e;
        }
    }
}

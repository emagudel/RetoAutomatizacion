package com.company.certification.reto.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.company.certification.reto.model.DataTest.obtain;

public class VerifyExpectedResult implements Question<Boolean> {

  public static VerifyExpectedResult inAplication() {
    return new VerifyExpectedResult();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
      String expectedData = obtain("expectedResult");
      String expectedFront = obtain("sailFromCruise");
      return expectedFront.contains(expectedData);
  }

}

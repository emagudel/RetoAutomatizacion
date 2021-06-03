package com.company.certification.reto.questions;

import com.company.certification.reto.util.manager.VerifyFields;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.company.certification.reto.model.DataTest.obtain;
import static com.company.certification.reto.util.constant.BuyArticlesConstantManager.INFORME_SERENITY;
import static com.company.certification.reto.util.manager.VerifyFields.validarCampo;
import static com.company.certification.reto.util.manager.VerifyFields.verificarValorContenido;

public class VerifyExpectedResult implements Question<Boolean> {

  public static VerifyExpectedResult inAplication() {
    return new VerifyExpectedResult();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
      VerifyFields.cleanReport();
      boolean resultVerify;
      String expectedData = obtain("expectedResult");
      String expectedFront = obtain("userLogin");
      resultVerify = verificarValorContenido("RESULT EXPECTED", expectedFront, expectedData);
      Serenity.recordReportData().withTitle("Result final")
              .andContents(Serenity.sessionVariableCalled(INFORME_SERENITY));

      return resultVerify;
  }

}

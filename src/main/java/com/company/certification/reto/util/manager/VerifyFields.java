package com.company.certification.reto.util.manager;


import net.serenitybdd.core.Serenity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.company.certification.reto.util.constant.BuyArticlesConstantManager.INFORME_SERENITY;

public class VerifyFields {

    private static final Logger LOGGER = LogManager.getLogger("Verify of fields");
    private static String validadorDeInformes = "";
    private static String resultadoCampo = "Result ";
    private static String respuestaOK = "  : OK";
    private static String respuestaERR = "  : ERROR";


    public static boolean validarCampo(String campo, String valorObtenido, String valorEsperado, Boolean resultadoAntes) {
        Boolean resultado;
        LOGGER.info("Valor Obtenido Campo " + campo + " : " + valorObtenido);
        LOGGER.info("Valor Esperado Campo " + campo + " : " + valorEsperado);
        validadorDeInformes += "Valor Obtenido Campo " + campo + " : " + valorObtenido + "\n" +
                "Valor Esperado Campo " + campo + " : " + valorEsperado + "\n";

        try {
            if (valorObtenido.equalsIgnoreCase(valorEsperado)) {
                LOGGER.info(resultadoCampo + respuestaOK);
                validadorDeInformes += resultadoCampo + respuestaOK + "\n\n";
                Serenity.setSessionVariable(INFORME_SERENITY).to(validadorDeInformes);
                resultado = true;
            } else {
                LOGGER.info(resultadoCampo + respuestaERR);
                validadorDeInformes += resultadoCampo + respuestaERR + "\n\n";
                Serenity.setSessionVariable(INFORME_SERENITY).to(validadorDeInformes);
                resultado = false;
            }
        } catch (Exception e) {
            LOGGER.info(resultadoCampo + campo + respuestaERR);
            LOGGER.error(e.getMessage(), e);
            validadorDeInformes += resultadoCampo + respuestaERR + "\n\n";
            Serenity.setSessionVariable(INFORME_SERENITY).to(validadorDeInformes);
            resultado = false;
        }

        return resultado && resultadoAntes;
    }

    public static boolean verificarValorContenido(String field, String valueObtained, String valueExpected) {
        boolean result = false;
        LOGGER.info("Valor Obtenido Campo " + field + " : " + valueObtained);
        LOGGER.info("Valor Esperado Campo " + field + " : " + valueExpected);
        validadorDeInformes += "\n" + "Valor Obtenido Campo " + field + " : " + valueObtained + "\n" +
                "Valor Esperado Campo " + field + " : " + valueExpected + "\n";

        try {
            if (valueObtained.contains(valueExpected)) {
                LOGGER.info(resultadoCampo + respuestaOK);
                validadorDeInformes += resultadoCampo + respuestaOK + "\n\n";
                Serenity.setSessionVariable(INFORME_SERENITY).to(validadorDeInformes);
                result = true;
            } else {
                LOGGER.info(resultadoCampo + respuestaERR);
                validadorDeInformes += resultadoCampo + respuestaERR + "\n\n";
                Serenity.setSessionVariable(INFORME_SERENITY).to(validadorDeInformes);
                result = false;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            LOGGER.info(resultadoCampo + respuestaERR);
            validadorDeInformes += resultadoCampo + respuestaERR + "\n\n";
            Serenity.setSessionVariable(INFORME_SERENITY).to(validadorDeInformes);
            result = false;
        }
        return result;
    }


    public static void cleanReport() {
        validadorDeInformes = "";
    }
}

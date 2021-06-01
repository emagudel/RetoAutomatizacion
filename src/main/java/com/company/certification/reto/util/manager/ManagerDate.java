package com.company.certification.reto.util.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ManagerDate {

    private static final Logger LOGGER = LogManager.getLogger(ManagerDate.class.getName());

    public static String obtenerFechaSistema(String strFormat) {
        SimpleDateFormat fechaActual = new SimpleDateFormat(strFormat);
        return fechaActual.format(new Date());
    }

    public static String retornarDiaActual() {
        Calendar calendario = new GregorianCalendar();
        return Integer.toString(calendario.get(Calendar.DATE));
    }

    public static String retornarMesActual() {
        Calendar calendario = new GregorianCalendar();
        return Integer.toString(calendario.get(Calendar.MONTH));
    }

    public static String retornarMesAnterior() {
        Calendar calendario = new GregorianCalendar();
        return Integer.toString(calendario.get(Calendar.MONTH) - 1);
    }

    public static String retornarAnnioActual() {
        Calendar calendario = new GregorianCalendar();
        return Integer.toString(calendario.get(Calendar.YEAR));
    }

}
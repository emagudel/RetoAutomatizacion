package com.company.certification.reto.tasks;


import com.company.certification.reto.model.DataTest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.company.certification.reto.util.manager.ManagerDate.obtenerFechaSistema;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class LoadDataTest implements Task{

    private static final Logger LOGGER = LogManager.getLogger(LoadDataTest.class.getName());

    private final List<Map<String, Object>> information;

    public LoadDataTest(List<Map<String, Object>> information) {
        this.information = information;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!information.isEmpty()) {
            Set<Map.Entry<String, Object>> setMapaAux = information.get(0).entrySet();
            Map<String, Object> mapAuxiliar = setMapaAux.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            if (DataTest.getMap() == null) {
                DataTest.setMap(mapAuxiliar);
                DataTest.getMap().put("horaTransaccion", obtenerFechaSistema("HHmmss"));
                DataTest.getMap().put("fechaTransaccion", obtenerFechaSistema("yyyyMMdd"));
            } else {
                DataTest.getMap().putAll(mapAuxiliar);
            }
        } else {
            LOGGER.info("Verifique que la estructura de la lista en el feature este bien definida");
        }
    }

    public static LoadDataTest loadData(List<Map<String, Object>> information) {
        return instrumented(LoadDataTest.class, information);
    }

}

package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Hook {

    @Before
    public void init(Scenario scenario) {
        log.info(String.format("TESTE INICIADO: %s",scenario.getName()));
    }

    @After
    public void end(Scenario scenario){
        log.info(String.format("TESTE FINALIZADO: %s",scenario.getName()));
        log.info(String.format("TESTE STATUS: %s",scenario.getStatus()));
    }
}










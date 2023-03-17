package edu.nur.edd.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog {
    private static Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) {
        TestLog a = new TestLog();
        a.m(true);

       // a.m2();
    }

    private void m(boolean conError) {
        logger.debug("Entrando al metodo m1");

        try {
            int a = 5 + 4;
            if(conError)
                throw new IllegalArgumentException("Error en la conversion de archivos");
            logger.debug("Hizo  la operacion 5+4");
        } catch(Exception q) {
            logger.error("Paso algo raro", q);
        }

        logger.info("Termina metodo m");
    }

    private void m2() throws IllegalArgumentException {

    }
}

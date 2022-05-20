package com.afterAll.spring5newfeat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Demo {
    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void main(String[] args) {
        logger.info("info");
        logger.warn("warn");
        logger.debug("debug");
        logger.error("error");
    }
}

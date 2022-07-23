package com.kuehnenagel;

import com.kuehnenagel.events.Event;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Decathlon project's aim is to calculate the results of a Decathlon competition.
 * See readme.md for details.
 *
 * @author Halil Ibrahim Oymaci - hioymaci@gmail.com
 */
public class Main {

    private static final String LOG_FILE_PROPERTIES = "logging.properties";

    private static final Logger log = Logger.getLogger((Main.class.getName()));

    public static void main(String[] args) {
        setupLogging();
        log.info("Hello World!");
        log.info("aaa");
        int point = PointCalculator.calculatePointForTrack(10.395, Event.RACE_100M);
        log.info(() -> "100m-dash point is " + point);
    }

    private static void setupLogging() {
        URL url = Main.class.getClassLoader().getResource(LOG_FILE_PROPERTIES);
        if (url == null) {
            System.err.println("Log file is not found. Default logging properties is used.");
            return;
        }

        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream(url.getFile()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

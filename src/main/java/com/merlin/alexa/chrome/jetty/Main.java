package com.merlin.alexa.chrome.jetty;

import com.sun.corba.se.impl.activation.ServerMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Created by Aaron on 8/27/2016.
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(ServerMain.class);

    public static void main(String args[]) throws Exception {
        // add SLF4JBridgeHandler to j.u.l's root logger, should be done once during
        // the initialization phase of your application
        SLF4JBridgeHandler.install();

        try {
            JettyServer server = new JettyServer(8080);
            server.start();
            log.info("Server started");
            server.join();
        } catch (Exception e) {
            log.error("Failed to start server.", e);
        }
    }
}

package org.myan.server;

/**
 * Created by myan on 2017/7/17.
 * Intellij IDEA
 */
public class Main {

    public static void main(String[] args) {
        String serverPort = System.getenv("PORT");
        if (serverPort == null || serverPort.isEmpty()) {
            serverPort = "7001";
        }
        JettyServer server = new JettyServer(Integer.valueOf(serverPort));
        server.start();
    }
}

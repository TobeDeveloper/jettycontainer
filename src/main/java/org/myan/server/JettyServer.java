package org.myan.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by myan on 2017/7/17.
 * Intellij IDEA
 */
class JettyServer {
    private static final String WEB_APP_ROOT = "src/main/webapp";
    private static final Logger LOG = Logger.getLogger("JettyServer");

    private int port;
    private String bindAddress;
    private Server server;
    JettyServer(int port) {
        this(port, null);
    }

    public JettyServer(int port, String binding) {
        this.port = port;
        this.bindAddress = binding;
    }

    void start() {
        this.server = new Server(createDefaultThreadPool());
        NetworkTrafficServerConnector connector = createConnector();
        server.addConnector(connector);

        //add handlers
        WebAppContext webAppContext = createContext();
        AccessLogHandler logHandler = new AccessLogHandler();
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[]{webAppContext, logHandler});
        server.setHandler(handlers);

        server.setStopAtShutdown(true);
        try {
            server.start();
            LOG.info("Server started at port:"+port);
            server.join();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Failed to start server:"+e.getMessage());
            throw new RuntimeException();
        }
    }

    private NetworkTrafficServerConnector createConnector() {
        NetworkTrafficServerConnector connector = new NetworkTrafficServerConnector(server);
        connector.setPort(this.port);
        connector.setHost(this.bindAddress);
        return connector;
    }

    private ThreadPool createDefaultThreadPool() {
        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setMinThreads(10);
        threadPool.setMaxThreads(100);
        return threadPool;
    }

    private WebAppContext createContext() {
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setWar(WEB_APP_ROOT);
        return webAppContext;
    }
}

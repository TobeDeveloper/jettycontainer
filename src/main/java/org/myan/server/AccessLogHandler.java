package org.myan.server;

import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.RequestLog;
import org.eclipse.jetty.server.handler.RequestLogHandler;

import java.io.File;

/**
 * Created by myan on 2017/7/17.
 * Intellij IDEA
 */
class AccessLogHandler extends RequestLogHandler {
    private final static String LOG_PATH = "./var/logs/access/yyyy_mm_dd.request.log";

    @Override
    public void setRequestLog(RequestLog requestLog) {
        super.setRequestLog(createRequestLog());
    }

    private RequestLog createRequestLog() {
        NCSARequestLog log = new NCSARequestLog();

        File logPath = new File(LOG_PATH);
        if (!logPath.getParentFile().exists())
            logPath.getParentFile().mkdirs();

        log.setFilename(logPath.getPath());
        log.setRetainDays(90);
        log.setExtended(false);
        log.setAppend(true);
        log.setLogTimeZone("GMT");
        log.setLogLatency(true);
        return log;
    }
}

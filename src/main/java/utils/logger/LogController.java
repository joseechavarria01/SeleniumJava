/**
 * @author Jose Francisco Echavarria
 */
package utils.logger;

import com.aventstack.extentreports.ExtentReports;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RunUtil;
import utils.config.Config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogController {
    private static Logger logger;
    private RunUtil runUtil = RunUtil.getInstance();
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public <T> LogController(final Class<T> clazz) {
        logger = LoggerFactory.getLogger(clazz);
        logger.info("Logger initialized for class: " + clazz.getName());
    }

    public void trace(final String message) {
        logger.trace(getMessage() + " -> " + message);
    }

    public void debug(final String message) {
        logger.debug(getMessage() + " -> " + message);
    }

    public void info(final String message) {
        logger.info(getMessage() + " -> " + message);
    }

    public void warn(final String message) {
        logger.warn(getMessage() + " -> " + message);
    }

    public void error(final String message) {
        logger.error(getMessage() + " -> " + message);
    }

    private String getMessage() {
        if (System.getProperty("runId") != null) {
            this.runUtil.setRunId(System.getProperty("runId"));
        }
        // Obtener la fecha y hora actual con el formato deseado
        String dateStamp = LocalDateTime.now().format(fmt);
        return dateStamp + " - " + this.runUtil.getRunId();
    }
}

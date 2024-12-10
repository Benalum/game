package Logging;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

public class AppLogger {
    private static Logger logger = Logger.getLogger("Logging.AppLogger");
    private static FileHandler fileHandler;

    static {
        try {
            // Configure the logger with handler and formatter
            fileHandler = new FileHandler("resources/Logging/player.txt", true); // Append mode is true
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (SecurityException | IOException e) {
            logger.log(Level.SEVERE, "Error occur in FileHandler.", e);
        }
    }

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    public static void logError(String message) {
        logger.log(Level.SEVERE, message);
    }
}

package org.mts.lab2.enums;

import java.util.logging.Level;

public enum LoggingTypes {
    DEBUG,
    WARN,
    INFO,
    ERROR,
    FATAL;

    @Override
    public String toString() {
        switch (this){
            case INFO -> {
                return LoggingTypes.INFO.name();
            }
            case WARN -> {
                return LoggingTypes.WARN.name();
            }
            case DEBUG -> {
                return LoggingTypes.DEBUG.name();
            }
            case ERROR -> {
                return LoggingTypes.ERROR.name();
            }
            case FATAL -> {
                return LoggingTypes.FATAL.name();
            }
            default -> {
                return null;
            }
        }
    }
}

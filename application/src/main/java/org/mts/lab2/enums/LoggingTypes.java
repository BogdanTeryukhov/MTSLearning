package org.mts.lab2.enums;

import java.util.logging.Level;

public enum LoggingTypes {
    DEBUG,
    INFO,
    ERROR,
    FATAL;

    @Override
    public String toString() {
        switch (this){
            case INFO -> {
                return "INFO";
            }
            case DEBUG -> {
                return "DEBUG";
            }
            case ERROR -> {
                return "ERROR";
            }
            case FATAL -> {
                return "FATAL";
            }
            default -> {
                return null;
            }
        }
    }
}

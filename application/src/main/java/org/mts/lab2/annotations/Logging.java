package org.mts.lab2.annotations;

import org.mts.lab2.enums.LoggingTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {
    String name() default "";
    boolean entering() default false;
    boolean exiting() default false;
    LoggingTypes level() default LoggingTypes.INFO;
}

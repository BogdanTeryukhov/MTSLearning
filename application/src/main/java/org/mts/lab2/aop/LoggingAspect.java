package org.mts.lab2.aop;

import io.micrometer.common.util.StringUtils;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.mts.lab2.annotations.Logging;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Aspect
@Log4j2
@Component
public class LoggingAspect {
    private static final String ENTER = ">> {}";
    private static final String EXIT = "<< {}";


    @Around("@annotation(logging) && execution(* org.mts..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint, Logging logging) throws Throwable {

        String val = fetchAnnotationValue(joinPoint, logging);

        if (logging.entering()) {
            switch (Objects.requireNonNull(logging.level().toString())) {
                case "INFO" -> log.info(ENTER, val);
                case "DEBUG" -> log.debug(ENTER, val);
                case "ERROR" -> log.error(ENTER, val);
                case "FATAL" -> log.fatal(ENTER, val);
            }
        }

        Object result = joinPoint.proceed();

        if (logging.exiting()) {
            switch (Objects.requireNonNull(logging.level().toString())) {
                case "INFO" -> log.info(EXIT, val);
                case "DEBUG" -> log.debug(EXIT, val);
                case "ERROR" -> log.error(EXIT, val);
                case "FATAL" -> log.fatal(EXIT, val);
            }
        }
        return result;
    }


    private String fetchAnnotationValue(ProceedingJoinPoint joinPoint, Logging logging) {
        return Optional.ofNullable(logging)
                .map(Logging::name)
                .filter(StringUtils::isNotBlank)
                .orElse(joinPoint.getSignature().getName());
    }
}

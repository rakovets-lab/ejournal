package by.iteen.aspect;


import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Log4j
public class Logger {

    @Pointcut("execution(public * by.iteen.service.*.* (..))")
    public void allServices() {};


    @Before("execution(public * by.iteen.service.*.* (..))")
    public void printParameters(JoinPoint joinPoint) {
        StringBuffer logMessage = new StringBuffer();
        logMessage.append(">>>>> " + joinPoint.getTarget().getClass().getSimpleName() + " call method " + joinPoint.getSignature().getName() + "(");
        Object[] arguments = joinPoint.getArgs();
        int size = arguments.length;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                logMessage.append(arguments[i] + ((i + 1 == size)? "" : ", "));
            }
        }
        logMessage.append(") <<<<<");
        log.info(logMessage);
    }

}

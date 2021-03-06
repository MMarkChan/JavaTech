package springmvc.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CentralMonitoringHandler {
	private static Logger monitorLogger = LoggerFactory.getLogger("monitoring");

	@Around("execution(* xpadro.spring.mvc.*..*Service+.*(..)) && target(service)")
	public Object logServiceAccess(ProceedingJoinPoint jp, Object service) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = jp.proceed();
		long totalTime = System.currentTimeMillis() - startTime;
		monitorLogger.info("{}|Invocation time {}ms ", service.getClass().getSimpleName(), totalTime);
		
		return result;
	}
}
